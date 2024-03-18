package com.example.proyecto1_api_recipeapp.controllers;

import com.example.proyecto1_api_recipeapp.entity.Recipe;
import com.example.proyecto1_api_recipeapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService service;
    private SimpleJpaRepository RecipeRepository;

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe){
        return service.SaveRecipe(recipe);

    }
    @GetMapping("/recipe")
    public List<Recipe> findAllRecipes(){
        return service.getRecipe();

    }

    @DeleteMapping("/delete/(id)")
    public String deleteRecipe(@PathVariable int id){
        return service.deleteRecipe(id);
    }

    @PutMapping
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe updatedRecipe) {
        Recipe existingRecipe = (Recipe) RecipeRepository.findById(id).orElse(null);
        if (existingRecipe != null) {
            existingRecipe.setName(updatedRecipe.getName());
            existingRecipe.setIngredients(updatedRecipe.getIngredients());
            existingRecipe.setInstructions(updatedRecipe.getInstructions());
            return (Recipe) RecipeRepository.save(existingRecipe);
        }
        return null;
    }

    }


