package guru.spring.springmvccrud.controllers;

import guru.spring.springmvccrud.commands.RecipeCommand;
import guru.spring.springmvccrud.models.Ingredient;
import guru.spring.springmvccrud.services.IngredientService;
import guru.spring.springmvccrud.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public RecipeController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping
    @RequestMapping("/{id}/show")
    public String recipeShow(
            @PathVariable String id,
            Model model) {
        model.addAttribute("recipe", recipeService.findRecipeById(Long.valueOf(id)));
        return "recipe/show";
    }

    @GetMapping
    @RequestMapping("/new")
    public String recipeAddForm(
            Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/form";
    }

    @GetMapping
    @RequestMapping("{id}/edit")
    public String recipeEditForm(
            @PathVariable String id,
            Model model) {

        model.addAttribute("recipe", recipeService.findRecipeById(Long.valueOf(id)));
        return "recipe/form";
    }

    @GetMapping
    @RequestMapping("{id}/delete")
    public String deleteRecipe(
            @PathVariable String id,
            Model model) {
        recipeService.deleteRecipeById(Long.valueOf(id));
        //model.addAttribute("recipes", recipeService.getRecipes());
        return "redirect:/" ;
    }

    @PostMapping
    @RequestMapping("")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/" + + savedCommand.getId() + "/show" ;
    }




    @GetMapping
    @RequestMapping("/{id}/ingredients")
    public String listIngredients(
            @PathVariable String id,
            Model model) {
        model.addAttribute("recipe", recipeService.findRecipeById(Long.valueOf(id)));
        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("/{recipeId}/ingredient/{ingrId}/show")
    public String showIngredient(
            @PathVariable String recipeId,
            @PathVariable String ingrId,
            Model model) {
        model.addAttribute("ingredient",
                ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(ingrId)));
        return "recipe/ingredient/show";
    }


}
