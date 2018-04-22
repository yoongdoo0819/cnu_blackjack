package com.cnu.blackjack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EvaluatorTest {

    @Test
    public void 게임초기화시_모든플레이어는_2장의카드를_받는다() {
        Game game = new Game(new Deck(1));
        game.addPlayer("Player01",5000);
        game.addPlayer("Player02",5000);

        //딜러도 플레이어로 넣어야함
    }

    @Test
    public void 카드를_받으면_플레이어의_hand에_카드의값을_누적해준다(){

    }

    @Test
    public void 각_플레이어는_16이하면_히트한다() { //카드 받는것

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
