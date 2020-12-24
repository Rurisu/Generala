/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

import java.util.Arrays;

/**
 *
 * @author Marcelo
 */
public class Generala {

    public static int chance(int firstDice, int secondDice, int thirdDice, int forthDice, int fifthDice) {       
        return firstDice+secondDice+thirdDice+forthDice+fifthDice;
    }

    public static int generala(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        
        int generalaDie = Arrays.stream(counts).filter(d -> d == 5).findFirst().orElse(0);
        return generalaDie == 5 ? 50 : 0;
    }

    public static int ones(int... dice) {     
        return Arrays.stream(dice).filter(d -> d == 1).sum();
    }

    public static int twos(int... dice) {
        return Arrays.stream(dice).filter(d -> d == 2).sum();
    }

    public static int threes(int... dice) {
        return Arrays.stream(dice).filter(d -> d == 3).sum();
    }

    protected int[] dice;
    //constructor?
    public Generala(int firstDice, int secondDice, int thirdDice, int forthDice, int fifthDice) {
        dice = new int[5];
        dice[0] = firstDice;
        dice[1] = secondDice;
        dice[2] = thirdDice;
        dice[3] = forthDice;
        dice[4] = fifthDice;
    }

    public int fours() {
        return Arrays.stream(dice).filter(d -> d == 4).sum();
    }

    public int fives() {
        return Arrays.stream(dice).filter(d -> d == 5).sum();
    }

    public int sixes() {
        return Arrays.stream(dice).filter(d -> d == 6).sum();
    }

    public static int score_pair(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        int at;
        for (at = 0; at != 6; at++) {
            if (counts[6 - at - 1] >= 2) {
                return (6 - at) * 2;
            }
        }
        return 0;
    }

    public static int two_pair(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1) {
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        }
        if (n == 2) {
            return score * 2;
        } else {
            return 0;
        }
    }

    
    public static int four_of_a_kind(int... dice) {
        int[] tallies = new int[6];
        for (int die : dice) {
            tallies[die - 1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 4) {
                return (i + 1) * 4;
            }
        }
        return 0;
    }

    public static int three_of_a_kind(int... dice) {
        int[] tallies = new int[6];
        for (int die : dice) {
            tallies[die - 1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 3) {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    public static int smallStraight(int... dice) {
        int[] tallies = new int[6];
        for (int die : dice) {
            tallies[die - 1]++;
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            if(tallies[i] == 1)
                sum++;
        }
        if (sum == 5) return 15;
        return 0;
    }

    public static int largeStraight(int... dice) {
        int[] tallies = new int[6];
        for (int die : dice) {
            tallies[die - 1]++;
        }
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            if(tallies[i] == 1)
                sum++;
        }
        if (sum == 5) return 20;
        return 0;
    }

    public static int fullHouse(int... dice) {
        int[] tallies;
        boolean twoTimes = false;
        int i;
        int twoTimesPosition = 0;
        boolean threeTimes = false;
        int threeTimesPosition = 0;

        tallies = new int[6];
        for (int die : dice) {
            tallies[die - 1]++;
        }

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 2) {
                twoTimes = true;
                twoTimesPosition = i + 1;
            }
        }

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 3) {
                threeTimes = true;
                threeTimesPosition = i + 1;
            }
        }

        if (twoTimes && threeTimes) {
            return twoTimesPosition * 2 + threeTimesPosition * 3;
        } else {
            return 0;
        }
    }
}
