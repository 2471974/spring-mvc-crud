package guru.spring.springmvccrud.services;

import guru.spring.springmvccrud.commands.RecipeCommand;
import guru.spring.springmvccrud.models.Recipe;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findRecipeById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    void deleteRecipeById(Long idToDelete);

}
