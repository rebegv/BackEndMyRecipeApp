package com.example.proyecto1_api_recipeapp.repository;

import com.example.proyecto1_api_recipeapp.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByName(String name);



}
