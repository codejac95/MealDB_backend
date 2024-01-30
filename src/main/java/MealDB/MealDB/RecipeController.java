package MealDB.MealDB;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class RecipeController {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    @GetMapping
    public List<Recipe> getAllRecipes() {
        System.out.println("Alla grejer");
        return (List<Recipe>) recipeRepository.findAll();
    }

    @PostMapping("/add")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        System.out.println("lagt till en");
        return recipeRepository.save(recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Integer id) {
        recipeRepository.deleteById(id);
    }
}
