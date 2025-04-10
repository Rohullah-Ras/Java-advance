package nl.sibrenrocva.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nl.sibrenrocva.demo.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    
}
