package com.rauloliva.wordsearch;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private char[][] board;
    private int n_rows;
    private int n_cols;

    private String word;
    private char[] letters;

    // pointers
    private int rowPointer = 0;
    private int colPointer = 0;
    private int wordPointer = 0;

    //private boolean wordIsFound = false;
    private String finalWord = "";

    // letters coords
    private List<String> coords;

    public Board(char[][] board, String word) {
        if (board[0][0] == 0) {
            throw new NullPointerException("Do not provide empty matrix");
        }

        this.board = board;
        this.n_rows = board.length;
        this.n_cols = board[0].length;
        this.word = word;
        this.letters = word.toCharArray();
        this.coords = new ArrayList<>();
    }

    public List<String> getLettersCoords() {
        return coords;
    }

    private boolean isMatch(char boardLetter) {
        // does the letter from the board matches the next letter in the 'search' word?
        if (boardLetter == letters[wordPointer]) {
            coords.add(rowPointer + ":" + colPointer);
            finalWord += "" + boardLetter;
            wordPointer++;
            return true;
        }

        return false;
    }

    public void start() {
        do {
            char boardLetter = board[rowPointer][colPointer];

            if (isMatch(boardLetter)) {
                // check every possible path to find all letters from 'search' word
                if (lookForward()) {
                    colPointer++;
                } else if (lookBack()) {
                    colPointer--;
                } else if (lookDown()) {
                    rowPointer++;
                } else if (lookUp()) {
                    rowPointer--;
                } else {
                    break;
                }

                continue;
            }

            resumeLoop();
        } while (loopIsOver());

        System.out.println("Final Word: " + finalWord);
        if (finalWord.equals(word)) {
            System.out.println("The word was found");
        } else {
            System.out.println("The word was not found");
        }
    }

    private void resumeLoop() {
        colPointer++;

        if (colPointer == n_cols) {
            colPointer = 0;
            rowPointer++;
        }
    }

    private boolean lookForward() {
        try {
            int colTmp = colPointer + 1;
            char nextChar = board[rowPointer][colTmp];

            return nextChar == letters[wordPointer];
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    private boolean lookBack() {
        try {
            int colTmp = colPointer - 1;
            char backChar = board[rowPointer][colTmp];

            return backChar == letters[wordPointer];
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    private boolean lookDown() {
        try {
            int rowTmp = rowPointer + 1;
            char downChar = board[rowTmp][colPointer];

            return downChar == letters[wordPointer];
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    private boolean lookUp() {
        try {
            int rowTmp = rowPointer - 1;
            char upChar = board[rowTmp][colPointer];

            return upChar == letters[wordPointer];
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    private boolean loopIsOver() {
        if (wordIsFound()) {
            return false;
        } else if (rowPointer == n_rows) {
            return false;
        }

        return true;
    }

    private boolean wordIsFound() {
        return wordPointer == letters.length;
    }
}
