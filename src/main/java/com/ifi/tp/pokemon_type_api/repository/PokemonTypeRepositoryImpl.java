package com.ifi.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        for (PokemonType pokemon : pokemons) {
            if (pokemon.getId() == id)
                return pokemon;
        }
        return null;
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        for (PokemonType pokemon : pokemons) {
            if (pokemon.getName().equals(name) )
                return pokemon;
        }
        return null;
    }

    @Override
    public List<PokemonType> findPokemonByTypes(List<String> types) {
        List<PokemonType> pokemonsTypes = new ArrayList<PokemonType>();
        for (PokemonType pokemon : pokemons) {
            if (pokemon.getTypes().containsAll(types) )
                pokemonsTypes.add(pokemon);

        }
        return pokemonsTypes;
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        return pokemons;
    }
}