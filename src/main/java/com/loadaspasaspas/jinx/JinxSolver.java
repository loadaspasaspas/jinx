package com.loadaspasaspas.jinx;

import java.io.*;

public class JinxSolver {

    private int position;
    private int lastPosition;
    private int value;

    private int[] numberCount;
    private int[] uniqueCount;
    private int[] accumulatedDifferential;
    private int[][] frequency;
    private int[] sequence;
    private int[] stability;

    private int[] key;
    private char[] symbol;

    private int[][] differentialBounds;
    private final int minIdenticalSequence;
    private final int maxIdenticalSequence;

    public JinxSolver() {
        this(new JinxSolverConfiguration());
    }

    public JinxSolver(JinxSolverConfiguration config) {
        key = config.getInitialKey();
        symbol = config.getSymbol();

        lastPosition = key.length - 1;
        numberCount = new int[key.length];
        uniqueCount = new int[key.length];
        accumulatedDifferential = new int[key.length];
        frequency = new int[key.length][symbol.length];
        sequence = new int[key.length];
        stability = new int[key.length];

        differentialBounds = config.getDifferentialBounds();
        minIdenticalSequence = config.getMinIdenticalSequence() - lastPosition;
        maxIdenticalSequence = config.getMaxIdenticalSequence();

    }

    public void printNext(int count) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512)) {
            position = 0;
            value = key[0];

            while (count > 0) {
                while (value < 16) {
                    update();

                    if (valid()) {
                        if (position == lastPosition) {
                            key[lastPosition] = value;

                            char[] result = new char[key.length];

                            for (int i = 0; i < key.length; i++) {
                                result[i] = symbol[key[i]];
                            }

                            out.write(result);
                            out.write('\n');

                            if (--count == 0) {
                                break;
                            }

                            value++;
                        } else {
                            value = key[++position];
                        }
                    } else {
                        value++;
                    }
                }

                while (value > 15) {
                    if (position == 0) {
                        count = 0;
                        break;
                    } else {
                        key[position] = 0;
                        value = key[--position] + 1;
                    }
                }
            }

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        if (position == 0) {
            numberCount[0] = value < 10 ? 1 : 0;
            uniqueCount[0] = 1;

            for (int i = 0; i < frequency[0].length; i++)
                frequency[0][i] = 0;

            frequency[0][value] = 1;
            sequence[0] = 0;
            stability[0] = 0;
        } else {
            int previousIndex = position - 1;
            int previous = key[previousIndex];

            for (int i = 0; i < frequency[position].length; i++)
                frequency[position][i] = frequency[previousIndex][i];

            frequency[position][value]++;

            if (value == previous) {
                stability[position] = stability[previousIndex] + 1;
            } else {
                stability[position] = 0;
            }

            if (value == previous + 1) {
                sequence[position] = sequence[previousIndex] < 1 ? 1 : sequence[previousIndex] + 1;
            } else if (value == previous - 1) {
                sequence[position] = sequence[previousIndex] > -1 ? -1 : sequence[previousIndex] - 1;
            } else {
                sequence[position] = 0;
            }

            numberCount[position] = value < 10 ? numberCount[previousIndex] + 1 : numberCount[previousIndex];
            uniqueCount[position] = frequency[position][value] == 1 ? uniqueCount[previousIndex] + 1 : uniqueCount[previousIndex];
            accumulatedDifferential[position] = Math.abs(value - key[previousIndex]) + accumulatedDifferential[previousIndex];
        }

        key[position] = value;
    }

    private boolean valid() {
        int val = key[position];

        if (accumulatedDifferential[position] < differentialBounds[position][0] || accumulatedDifferential[position] > differentialBounds[position][1]
                || frequency[position][val] > 3
                || Math.abs(sequence[position]) > 1
                || stability[position] > 1) {
            return false;
        }

        switch (position) {
            case 0:
                return true;
            case 1:
                return val != key[0]
                        && val != key[0] - 15
                        && val != key[0] - 14;
            case 2:
                return val != key[1]
                        && val != key[1] - 15
                        && val != key[1] - 13
                        && val != key[1] + 15
                        && val != key[0] - 15
                        && val != key[0] - 14
                        && val != key[0] - 13
                        && val != key[0] + 13;
            case 3:
                return (key[2] == key[0] ? val != key[1] && val != key[1] + 1 && val != key[2] : true)
                        && val != key[2] - 15
                        && val != key[2] - 14
                        && val != key[2] + 14
                        && val != key[2] + 15
                        && val != key[1] + 13
                        && val != key[1] + 14
                        && val != key[1] + 15
                        && val != key[0] - 15
                        && val != key[0] - 14
                        && val != key[0] - 13
                        && val != key[0] + 14
                        && val != key[0] + 15;
            case 4:
                return val != key[3] + 15
                        && val != key[2] - 15
                        && val != key[2] + 14
                        && val != key[2] + 15
                        && val != key[1] - 15
                        && val != key[1] + 13
                        && val != key[1] + 14
                        && val != key[1] + 15
                        && val != key[0] - 13
                        && val != key[0] + 13
                        && val != key[0] + 14;
            case 5:
                return (key[4] == key[2] ? val != key[3] : true)
                        && val != key[4] - 15
                        && val != key[4] - 14
                        && val != key[4] - 13
                        && val != key[4] + 14
                        && val != key[4] + 15
                        && val != key[3] - 15
                        && val != key[3] - 14
                        && val != key[3] - 13
                        && val != key[3] + 14
                        && val != key[2] - 15
                        && val != key[2] - 14
                        && val != key[2] - 13
                        && val != key[2] + 15
                        && val != key[1] - 14
                        && val != key[1] + 13
                        && val != key[1] + 14
                        && val != key[0] - 15
                        && val != key[0] - 14
                        && uniqueCount[position] > 1;
            case 6:
                return uniqueCount[position] > 2
                        && numberCount[position] > 0;
            case 7:
                return uniqueCount[position] > 3
                        && numberCount[position] > 1;
            case 8:
                return uniqueCount[position] > 4
                        && numberCount[position] > 2
                        && numberCount[position] < 9;
            case 9:
                return (val == key[1] ? val != key[2] : true)
                        && uniqueCount[position] > 5
                        && uniqueCount[position] < 10
                        && numberCount[position] > 3
                        && numberCount[position] < 9;
            default:
                return true;
        }
    }
}
