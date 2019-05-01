package sample;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Model {

    public int findPosition(Button[] tileList, String value) {
        int found = 0;
        for (int i = 1; i < tileList.length; i++) {
            if(tileList[i].getText().equals(value)) {
                found = i;
            }

        }
        return found;
    }

    public void swapVariable(Button[] tileList, int first, int second) {
        String firstValue = tileList[first].getText();
        tileList[first].setText(tileList[second].getText());
        tileList[second].setText(firstValue);
    }

    public int[] checkShuffle(Button[] tileList, int location) {
        ArrayList<Integer> plusNotAvailable = new ArrayList<>(Arrays.asList(4, 8, 12));
        ArrayList<Integer> minusNotAvailable = new ArrayList<>(Arrays.asList(5, 9, 13));
        int[] shuffleList;
        if (plusNotAvailable.contains(location)) {
            shuffleList = new int[3];
            shuffleList[0] = -1;
            shuffleList[1] = -4;
            shuffleList[2] =  4;
        }
        else if (minusNotAvailable.contains(location)) {
            shuffleList = new int[3];
            shuffleList[0] = 1;
            shuffleList[1] = -4;
            shuffleList[2] =  4;
        }
        else {
            shuffleList = new int[4];
            shuffleList[0] = -1;
            shuffleList[1] = -4;
            shuffleList[2] =  4;
            shuffleList[3] =  1;
        }
        return shuffleList;
    }

    public boolean checkMove(Button[] tileList, int location) {
        ArrayList<Integer> minusNotAvailable = new ArrayList<>(Arrays.asList(4, 8, 12));
        ArrayList<Integer> plusNotAvailable = new ArrayList<>(Arrays.asList(5, 9, 13));
        if (minusNotAvailable.contains(location)) {
            if (location == findPosition(tileList, " ") + 1 || location == findPosition(tileList, " ") - 4 || location == findPosition(tileList, " ") + 4) {
                return true;
            } else {
                return false;
            }
        } else if (plusNotAvailable.contains(location)) {
            if (location == findPosition(tileList, " ") - 1 || location == findPosition(tileList, " ") - 4 || location == findPosition(tileList, " ") + 4) {
                return true;
            } else {
                return false;
            }
        } else {
            if (location == findPosition(tileList, " ") - 1 || location == findPosition(tileList, " ") + 1 || location == findPosition(tileList, " ") - 4 || location == findPosition(tileList, " ") + 4) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void shuffle(Button[] tileList) {
        for (int i = 0; i < 400; i++) {
            int switchingLocation = findPosition(tileList, " ") + pickRandom(checkShuffle(tileList, findPosition(tileList, " ")));
            try {
                swapVariable(tileList, switchingLocation, findPosition(tileList, " "));
            } catch(ArrayIndexOutOfBoundsException e) {

            } catch(NullPointerException e) {

            }
        }
    }


    private int pickRandom(int[] listShuffled) {
        Random rand = new Random();
        return listShuffled[rand.nextInt(listShuffled.length)];
    }

    public boolean gameEnd(Button[] tileList) {
        for (int i = 1; i < tileList.length - 1; i++) {
            try {
                if (findPosition(tileList, String.valueOf(i)) != i) {
                    return false;
                }
            } catch(NullPointerException e) {

            }
        }
        return true;
    }
}
