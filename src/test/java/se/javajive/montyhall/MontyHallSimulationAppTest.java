package se.javajive.montyhall;


import org.junit.Test;
import se.javajive.montyhall.domain.Game;
import se.javajive.montyhall.domain.GameStrategy;
import se.javajive.montyhall.exception.MontyHallGameException;

import static org.junit.Assert.assertTrue;


public class MontyHallSimulationAppTest {

    @Test
    public void successfulSwitchGames() throws MontyHallGameException {
        int numberOfWins = 0;
        int numberOfLosses = 0;

        for (int i = 0; i < 100000; i++) {
            Game game = new Game();
            boolean result = game.playGame(GameStrategy.SWITCH);
            if (result) {
                numberOfWins++;
            } else {
                numberOfLosses++;
            }
        }
        assertTrue(numberOfWins > numberOfLosses);
    }

    @Test
    public void successfulKeepGames() throws MontyHallGameException {
        int numberOfWins = 0;
        int numberOfLosses = 0;

        for (int i = 0; i < 100000; i++) {
            Game game = new Game();
            boolean result = game.playGame(GameStrategy.KEEP);
            if (result) {
                numberOfWins++;
            } else {
                numberOfLosses++;
            }
        }
        assertTrue(numberOfWins < numberOfLosses);
    }

}

