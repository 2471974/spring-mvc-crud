package guru.spring.springmvccrud.services;

import guru.spring.springmvccrud.domain.Recipe;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}
