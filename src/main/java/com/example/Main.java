package com.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();

        SimpleStartup theStartup = new SimpleStartup();

        int randomNum = (int) (Math.random() * 5); // Génère un nombre entre 0 et 4
        ArrayList<String> locations = new ArrayList<>();
        locations.add(String.valueOf(randomNum));
        locations.add(String.valueOf(randomNum + 1));
        locations.add(String.valueOf(randomNum + 2));
        theStartup.setLocationCells(locations);

        boolean isAlive = true;

        while (isAlive) {
            String guess = String.valueOf(helper.getUserInput("enter a number"));
            String result = theStartup.checkYourself(guess);
            numOfGuesses++;
            System.out.println(result);
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }
    }
}