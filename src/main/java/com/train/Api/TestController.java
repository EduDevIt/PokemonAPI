package com.train.Api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemonAPI")
public class TestController {

    private List<Pokemon> pokemonArray = new ArrayList<>();
    public TestController(){
        pokemonArray.add(new Pokemon());
        pokemonArray.add(new Pokemon());
        pokemonArray.add(new Pokemon());
        pokemonArray.add(new Pokemon());
    }
    @GetMapping
    @RequestMapping("/test")
    public ResponseEntity<String> getTest(){
        pokemonArray.add(new Pokemon());
        return ResponseEntity.ok("Hola");

    }
    @GetMapping
    @RequestMapping("/{pokemon}")
    public ResponseEntity<String> segunda(@PathVariable String pokemon) {
        return ResponseEntity.ok(pokemon);
    }

}


//Crear una tabla que tenga nombre de pokemon, descripcion,tipo, color.
//Crear un controlador get post delete update, 4 endpoints y que haga sus cosas.