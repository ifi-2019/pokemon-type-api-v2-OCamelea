package com.ifi.tp.pokemon_type_api.service;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ifi.tp.pokemon_type_api.repository.PokemonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    protected PokemonTypeRepository pokemonTypeRepository;

    @Autowired
    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository){
        this.pokemonTypeRepository = pokemonTypeRepository;


    }

    @Override
    public PokemonType getPokemonType(int id) {
        return this.pokemonTypeRepository.findPokemonTypeById(id);
    }

    @Override
    public List<PokemonType> getPokemonTypes(List<String> types) {
        return this.pokemonTypeRepository.findPokemonByTypes(types);
    }

    @Override
    public PokemonType getPokemonName(String name) {
        return this.pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        return this.pokemonTypeRepository.findAllPokemonType();
    }
}