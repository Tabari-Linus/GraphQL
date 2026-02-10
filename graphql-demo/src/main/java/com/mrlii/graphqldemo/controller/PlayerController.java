package com.mrlii.graphqldemo.controller;

import com.mrlii.graphqldemo.model.Player;
import com.mrlii.graphqldemo.model.Team;
import com.mrlii.graphqldemo.service.PlayerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @QueryMapping
    public List<Player> findAll(){
        return playerService.findAll();
    }

    @QueryMapping
    public Optional<Player> findById(@Argument Integer id){
        return playerService.findById(id);
    }

    @MutationMapping
    public Player create(@Argument String name, @Argument Team team){
        return playerService.create(name, team);
    }

    @MutationMapping
    public Player update(@Argument Integer id, @Argument String name, @Argument Team team){
        return playerService.update(id, name, team);
    }

    @MutationMapping
    public void delete(@Argument Integer id){
        playerService.delete(id);
    }
}
