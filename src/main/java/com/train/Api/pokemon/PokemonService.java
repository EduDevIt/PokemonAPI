package com.train.Api.pokemon;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class PokemonService {

    private List<Pokemon> pokemonArray = new ArrayList<>();

    public PokemonService(){
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

    public void add (Pokemon newPokemon){
        pokemonArray.add(newPokemon);
    }
    public void update (Pokemon pokemonUpdate, String id){
        for (Pokemon pokemon : pokemonArray) {
            if (pokemon.getId().equals(id)) {
                pokemon.setName(pokemonUpdate.getName());
                pokemon.setType1(pokemonUpdate.getType1());
                pokemon.setType2(pokemonUpdate.getType2());
            }
        }
    }
}
