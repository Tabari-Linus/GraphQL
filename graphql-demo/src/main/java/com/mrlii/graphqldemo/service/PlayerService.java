package com.mrlii.graphqldemo.service;

import com.mrlii.graphqldemo.exception.InvalidPlayerIdException;
import com.mrlii.graphqldemo.exception.PlayerNotFoundException;
import com.mrlii.graphqldemo.model.Player;
import com.mrlii.graphqldemo.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerService {

    private List<Player> players = new ArrayList<>();

    AtomicInteger id = new AtomicInteger(0);

    public  List<Player> findAll(){
        return players;
    }

    public Optional<Player> findById(Integer id){
        Optional<Player> player = players.stream()
                .filter(p -> p.id().equals(id))
                .findFirst();

        if(player.isPresent()){
            return player;
        }
        else{
            throw new PlayerNotFoundException("Player not found");
        }
    }

    public Player create(String name, Team team){
        Player player = new Player(id.incrementAndGet(), name, team);
        players.add(player);
        return player;
    }

    public Player update(Integer id, String name, Team team){
        Player updaterPlayer = new Player(id, name, team);
        Optional<Player> optional = players.stream()
                .filter(player -> player.id().equals(id))
                .findFirst();
        if(optional.isPresent()){
            players.remove(optional.get());
            players.add(updaterPlayer);
            return updaterPlayer;
        }else{
            throw new InvalidPlayerIdException("Invalid player Id");
        }
    }

    public void delete(Integer id){
        Optional<Player> optional = players.stream()
                .filter(player -> player.id().equals(id))
                .findFirst();
        if(optional.isPresent()){
            players.remove(optional.get());
        }
        else{
            throw new InvalidPlayerIdException("Invalid player Id");
        }

    }

    @PostConstruct
    private void init(){
        players.add(new Player(id.incrementAndGet(), "Jack Penda", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Rohit Sharma", Team.MI));
        players.add(new Player(id.incrementAndGet(), "Virat Kohli", Team.DC));
        players.add(new Player(id.incrementAndGet(), "MS Dhoni", Team.GT));
        players.add(new Player(id.incrementAndGet(), "Hardik Pandya", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Ravindra Jadeja", Team.MI));
    }
}
