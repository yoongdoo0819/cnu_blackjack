package com.cnu.blackjack;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class EvaluatorTest {

    @Test
    public void 게임초기화시_모든플레이어는_2장의카드를_받는다() {
        Game game = new Game(new Deck(1));
        game.addPlayer("Player01",5000);
        game.addPlayer("Player02",5000);

        //Evaluator 객체 생성시 플레이어에 대해 2장씩 카드 줌(생성자에서 dealCardToPlayer 호출)
        //딜러는 카드 받을 필요 없음!!! 마지막에 Dealer.getDealerScore() 호출하면 17~24 사이 값 반환해줌
        Evaluator evaluator = new Evaluator(game.getPlayerList());

        //2장씩 받았는지 확인
        for(Player player : evaluator.getPlayerMap().values()){
            assertThat(player.getHand().getCardList().size(),is(2));
        }
    }

    @Test
    public void 각_플레이어는_16이하면_히트한다() { //카드 받는것
        Game game = new Game(new Deck(1));
        game.addPlayer("Player01",5000);

        Evaluator evaluator = new Evaluator(game.getPlayerList());
        Player player = evaluator.getPlayerMap().get("Player01");
        int score = evaluator.evaluatePlayerScore(player);
        if(score <= 16 ){
            player.hitCard();
            assertThat(player.getHand().getCardList().size(),is(3));
        }else{
            assertThat(player.getHand().getCardList().size(),is(2));
        }
    }



    @Test
    public void 카드를_받으면_플레이어의_hand에_카드의값을_누적해준다(){

    }
     
    @Test
    public void 블랙잭이나오면_2배로_보상받고_해당_플레이어의_턴은_끝난다() {

    }

    @Test
    public void 각_플레이어는_17이상이면_스탠드한다() { //카드 그만받기
        Game game = new Game(new Deck(1));
        game.addPlayer("Player01",5000);
        game.addPlayer("Player02",5000);
        Evaluator evaluator = new Evaluator(game.getPlayerList());
    }

    @Test
    public void 히트를_했는데_21이_넘어가면_버스트한다(){

    }

    @Test
    public void 모든_플레이어의_턴이끝나면_카드가21에_가까운쪽이_승리한다(){

    }
}
