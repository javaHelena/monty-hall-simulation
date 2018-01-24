package se.javajive.montyhall;

import se.javajive.montyhall.domain.Game;
import se.javajive.montyhall.domain.GameStrategy;
import se.javajive.montyhall.exception.MontyHallGameException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MontyHallSimulationApp {
    public static void main(String[] args) {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Welcome to the Monty Hall Simulation Application");
        System.out.println("1) Choose number of iterations for the simulator.");
        System.out.println("1) Choose the desired strategy: ");
        System.out.println("   K for Keeping the first choice");
        System.out.println("   S for Switching to the remaining box");
        System.out.println("   R for randomly choosing \"keeping\" or \"switching\"");
        System.out.println("   A for running all strategies.");
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Choose number of iterations in Monty App Simulation between 1 and  1000000 (10000): ");

        int numberOfIterations = getNumberOfIterations(input);

        System.out.print("Choose simulation strategy: K - Keep, S - Switch, R - Random, A - All (A):  ");
        String strategy = getStrategy(input);
        System.out.println();

        if (strategy.equalsIgnoreCase("K") || strategy.equalsIgnoreCase("A")) {
            runSimulation(numberOfIterations, GameStrategy.KEEP);
        }
        if (strategy.equalsIgnoreCase("S") || strategy.equalsIgnoreCase("A")) {
            runSimulation(numberOfIterations, GameStrategy.SWITCH);
        }
        if (strategy.equalsIgnoreCase("R") || strategy.equalsIgnoreCase("A")) {
            runSimulation(numberOfIterations, GameStrategy.RANDOM);
        }
    }

    private static String getStrategy(BufferedReader input) {
        List<String> allowedValues = Arrays.asList("K", "S", "R", "A");
        String strategy = "A";
        String userInput = null;
        try {
            userInput = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!"".equals(userInput.trim())) {
            if (allowedValues.contains(userInput)) {
                strategy = userInput;
            } else {
                System.out.println("Only letters K, S, R and A are allowed. Using A = all strategies.");
                strategy = "A";
            }
        }
        return strategy;
    }

    private static int getNumberOfIterations(BufferedReader input) {
        int iterations = 10000;
        String userInput = null;
        try {
            userInput = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!"".equals(userInput.trim())) {
            try {
                iterations = Integer.parseInt(userInput);
                if (iterations > 1000000) {
                    System.out.println("NUmber is too big, lets use 10000 iterations. ");
                    iterations = 10000;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Sorry, but that is a crappy number, lets use 10000 iterations. ");
            }
        }
        return iterations;
    }

    private static void runSimulation(int numberOfIterations, GameStrategy gameStrategy) {
        int numberOfWins = 0;
        for (int i = 0; i < numberOfIterations; i++) {
            if (runGame(gameStrategy)) {
                numberOfWins++;
            }
        }
        printPretty(numberOfIterations, numberOfWins, gameStrategy.name());
    }

    private static void printPretty(int numberOfIterations, int numberOfWins, String strategy) {
        System.out.println("============= " + strategy + " ===============");
        System.out.println("Number of iterations: " + numberOfIterations);
        System.out.println("Number of wins: " + numberOfWins);
        System.out.println("Successrate = " + 100.0 * numberOfWins / numberOfIterations + " %");
        System.out.println("===================================");
    }

    private static boolean runGame(GameStrategy gameStrategy) {
        Game game = new Game();
        boolean isWinning = false;

        try {
            isWinning = game.playGame(gameStrategy);
        } catch (Exception e) {
            System.out.println("===========ERROR=======================");
            System.out.println("An error occured in the simulation.");
            System.out.println(e.getMessage());
            System.out.println("Simulation is shutting down.");
            System.out.println("=======================================");
        }
        return isWinning;
    }

}
