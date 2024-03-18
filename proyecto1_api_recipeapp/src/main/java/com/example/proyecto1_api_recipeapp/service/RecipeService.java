package com.example.proyecto1_api_recipeapp.service;

import com.example.proyecto1_api_recipeapp.entity.Recipe;
import com.example.proyecto1_api_recipeapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.Extension;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Service
public class RecipeService {

    @Autowired
    private RecipeRepository repository;

    public List<Recipe> getRecipe() {
        return repository.findAll();
    }

    public Recipe SaveRecipe(Recipe recipe){
        return repository.save(recipe);
    }
    public String deleteRecipe(int id){
        repository.deleteById((long) id);
        return "Recipe Removed" + id;
    }
    public Recipe updateRecipe (Recipe recipe){
        Recipe existingRecipe = repository.findById(recipe.getId()).orElse(null);
        existingRecipe.setInstructions(recipe.getInstructions());
        existingRecipe.setName(recipe.getName());
        return repository.save(existingRecipe);
    }
 }


