package com.cnu.blackjack;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new Deck(1));
        game.addPlayer("player01",5000);
        game.addPlayer("player02",5000);

        game.placeBet("player01",100);
        game.placeBet("player02",200);



        game.start();

        //Evaluator();
    }
}
