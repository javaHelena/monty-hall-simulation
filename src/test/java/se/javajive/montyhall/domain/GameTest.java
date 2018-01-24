package se.javajive.montyhall.domain;

import org.junit.Before;
import org.junit.Test;
import se.javajive.montyhall.exception.MontyHallGameException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class GameTest {

    @Test
    public void initGameTest(){
        Game game = new Game();
        List<Box> winnerBoxes = new ArrayList();

        for (Box box : game.getAvailableBoxes().values()) {
            if (box.containsPrize){
                winnerBoxes.add(box);
            }
        }
        assertEquals(3, game.getAvailableBoxes().size());
        assertTrue(winnerBoxes.size()==1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionTest(){
        Game game = new Game();
        try {
            game.playGame(GameStrategy.valueOf("NOTHING"));
        } catch (MontyHallGameException e) {
            e.printStackTrace();
        }
    }




}
