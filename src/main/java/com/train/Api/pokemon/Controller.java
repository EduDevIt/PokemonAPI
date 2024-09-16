package com.train.Api.pokemon;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemonAPIarray")
public class Controller {


    private PokemonService pokemonService;



    @GetMapping()
    public ResponseEntity<List<Pokemon>> getAll(){
        return ResponseEntity.ok(pokemonArray);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody Pokemon updatedPokemon){
        for (Pokemon pokemon : pokemonArray) {
            if (pokemon.getId().equals(id)) {
                pokemon.setName(updatedPokemon.getName());
                pokemon.setType1(updatedPokemon.getType1());
                pokemon.setType2(updatedPokemon.getType2());
                return ResponseEntity.ok("Pokemon updated succesfully");
            }
        }
        pokemonService.update(updatedPokemon,id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon not found");
    }

    @DeleteMapping("/{pokemon}")
    public ResponseEntity<String> delete(@PathVariable String pokemon){
        boolean removed = pokemonArray.removeIf(element -> element.getName().equalsIgnoreCase(pokemon));
        if (removed){
            return ResponseEntity.ok("Pokemon deleted succesfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon not found");
    }

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Pokemon newPokemon) {
        pokemonService.add(newPokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pokemon added successfully!");
    }

    @GetMapping("/{pokemon}")
    public ResponseEntity<Pokemon> infoPokemon(@PathVariable String pokemon) {
        return pokemonArray.stream()
                .filter(element -> element.getName().equalsIgnoreCase(pokemon))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));


    }

//crear una clase nueva que se llamara pokemon service. migrar la logica del array al pokemon service.
    //tendra un metodo add delete create. y aqui llamaria al pokemon service
    //ver inyeccion de depencias
}


