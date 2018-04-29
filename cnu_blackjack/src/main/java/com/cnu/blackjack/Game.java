package com.cnu.blackjack;

import com.cnu.blackjack.exceptions.DuplicatePlayerException;
import com.cnu.blackjack.exceptions.NotEveryoneHaveStatusException;
import com.cnu.blackjack.exceptions.NotEveyonePlacedBetException;
import com.cnu.blackjack.exceptions.PlayerDoesNotExistException;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Map<String, Player> playerList = new HashMap<>();
    private Deck deck;


    public Game(Deck deck) {
        this.deck = deck;
    }

    public void addPlayer(String playerName, int seedMoney) {
        Player player = new Player(seedMoney, new Hand(deck));
        if (playerList.get(playerName) != null) {
            throw new DuplicatePlayerException();
        }
        playerList.put(playerName, player);
    }

    public Map<String, Player> getPlayerList() {
        return playerList;
    }

    public void start() {

        playerList.forEach((name, player) -> {
            if (player.getCurrentBet() == 0) {
                throw new NotEveyonePlacedBetException();
            }
        });

        playerList.forEach((name, player) -> {
            if (player.getStatus() == null) {
                throw new NotEveryoneHaveStatusException();
            }
        });


        // 딜러 생성

        Evaluator evaluator = new Evaluator(this.playerList);
        evaluator.start();
        // evaluator.초기 카드분배(딜러,플레이어) 2장씩


    }

    public void placeBet(String name, int bet) {
        //Test
        System.out.println("place bet 호출");
        Player player = playerList.get(name);
        if (player == null) {
            throw new PlayerDoesNotExistException();
        }
        player.placeBet(bet);
    }
}
