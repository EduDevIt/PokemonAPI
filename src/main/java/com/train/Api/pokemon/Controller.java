package com.train.Api.pokemon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@RestController
@RequestMapping("/pokemonAPIarray/")
public class Controller {

    private List<Pokemon> pokemonArray = new ArrayList<>();

    public Controller(){
        pokemonArray.add(new Pokemon("Bulbasaur", "1", "Grass", "Poison"));
        pokemonArray.add(new Pokemon("Charmander", "4", "Fire", ""));
        pokemonArray.add(new Pokemon("Squirtle", "7", "Water", ""));
        pokemonArray.add(new Pokemon("Pikachu", "25", "Electric", ""));
        pokemonArray.add(new Pokemon("Jigglypuff", "39", "Normal", "Fairy"));
        pokemonArray.add(new Pokemon("Meowth", "52", "Normal", ""));
        pokemonArray.add(new Pokemon("Psyduck", "54", "Water", ""));
        pokemonArray.add(new Pokemon("Machop", "66", "Fighting", ""));
        pokemonArray.add(new Pokemon("Geodude", "74", "Rock", "Ground"));
        pokemonArray.add(new Pokemon("Magnemite", "81", "Electric", "Steel"));
        pokemonArray.add(new Pokemon("Onix", "95", "Rock", "Ground"));
        pokemonArray.add(new Pokemon("Cubone", "104", "Ground", ""));
        pokemonArray.add(new Pokemon("Koffing", "109", "Poison", ""));
        pokemonArray.add(new Pokemon("Rhyhorn", "111", "Ground", "Rock"));
        pokemonArray.add(new Pokemon("Magikarp", "129", "Water", ""));
    }



    @GetMapping("/list")
    public ResponseEntity<String> getList(){
        String lista="";
        for (Pokemon i : pokemonArray){
            lista= lista + i.toString() + "\n";
        }
        return ResponseEntity.ok(lista);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePokemon(@PathVariable String id, @RequestBody Pokemon updatedPokemon){
        for (Pokemon i : pokemonArray) {
            if (i.getId().equals(id)) {
                i.setName(updatedPokemon.getName());
                i.setType1(updatedPokemon.getType1());
                i.setType2(updatedPokemon.getType2());
                return ResponseEntity.ok("Pokemon updated succesfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon not found");
    }


    @DeleteMapping("/delete/{pokemon}")
    public ResponseEntity<String> deletePokemon(@PathVariable String pokemon){
        Iterator<Pokemon> iterator = pokemonArray.iterator();
        while (iterator.hasNext()){
            Pokemon i = iterator.next();
            if (i.getName().equalsIgnoreCase(pokemon)){
                iterator.remove();
                return ResponseEntity.ok("Pokemon deleted succesfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon not found");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPokemon(@RequestBody Pokemon newPokemon) {
        pokemonArray.add(newPokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pokemon added successfully!");
    }

    @GetMapping("/data/{pokemon}")
    public ResponseEntity<String> infoPokemon(@PathVariable String pokemon) {
        for (Pokemon i : pokemonArray){
            if (i.getName().toLowerCase().equals(pokemon.toLowerCase())){
                return ResponseEntity.ok(i.toString());
            }
        }
        return ResponseEntity.ok("The pokemon doesn't exist in our database");
    }


}


