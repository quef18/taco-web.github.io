package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.Taco;
import com.example.demo.entity.Ingredient;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    private RestTemplate rest = new RestTemplate();
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients =

                Arrays.asList(rest.getForObject("http://localhost:8080/
                        ingredients",Ingredient[].class));
                        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),

                    filterByType(ingredients, type));

        }
    }
}
