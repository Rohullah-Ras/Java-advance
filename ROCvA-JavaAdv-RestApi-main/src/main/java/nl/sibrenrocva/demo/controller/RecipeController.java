package nl.sibrenrocva.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import nl.sibrenrocva.demo.model.Recipe;
import nl.sibrenrocva.demo.service.RecipeService;


@RestController
@RequestMapping("/api/Recipe")
public class RecipeController {

        @Autowired
        private RecipeService recipeService;

        @GetMapping("/{id}")
        public Recipe getRecipeById(@PathVariable Long id) {
            return recipeService.getRecipeById(id);
        }

        @GetMapping
        public List<Recipe> getRecipes() {
            return recipeService.getRecipes();
        }

        @PostMapping
        public Recipe createRecipe(@RequestBody Recipe recipe) {
            return recipeService.addRecipe(recipe);
        }

        @PutMapping("/{id}")
        public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
            return recipeService.updateRecipe(id, recipe);
        }

        @DeleteMapping("/{id}")
        public void deleteRecipe(@PathVariable Long id) {
            recipeService.deleteRecipe(id);
        }
    }
    