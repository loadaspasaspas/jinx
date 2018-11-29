package com.loadaspasaspas.jinx;

public class JinxSolverConfiguration {

    private int[][] differentialBounds;
    private int[] initialKey;
    private int keyCount;
    private int maxGrowthSequence;
    private int maxIdenticalSequence;
    private int maxNumber;
    private int maxUnique;
    private int minGrowthSequence;
    private int minIdenticalSequence;
    private int minNumber;
    private int minUnique;
    private char[] symbol;

    public JinxSolverConfiguration() {
        differentialBounds = new int[][]{{0, 15}, {0, 15}, {2, 24}, {3, 37}, {7, 50}, {8, 54}, {13, 62}, {15, 66}, {18, 78}, {19, 79}};
        initialKey = new int[10];
        symbol = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        keyCount = 0;
        maxGrowthSequence = 2;
        maxIdenticalSequence = 2;
        maxNumber = 8;
        maxUnique = 9;
        minGrowthSequence = 0;
        minIdenticalSequence = 0;
        minNumber = 4;
        minUnique = 6;
    }

    public int[][] getDifferentialBounds() {
        return differentialBounds;
    }

    public int[] getInitialKey() {
        return initialKey;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public int getMaxGrowthSequence() {
        return maxGrowthSequence;
    }

    public int getMaxIdenticalSequence() {
        return maxIdenticalSequence;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getMaxUnique() {
        return maxUnique;
    }

    public int getMinGrowthSequence() {
        return minGrowthSequence;
    }

    public int getMinIdenticalSequence() {
        return minIdenticalSequence;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getMinUnique() {
        return minUnique;
    }

    public char[] getSymbol() {
        return symbol;
    }

    public void setDifferentialBounds(int[][] differentialBounds) {
        this.differentialBounds = differentialBounds;
    }

    public void setInitialKey(int[] initialKey) {
        this.initialKey = initialKey;
    }

    public void setKeyCount(int value) {
        this.keyCount = value;
    }

    public void setMaxGrowthSequence(int maxGrowthSequence) {
        this.maxGrowthSequence = maxGrowthSequence;
    }

    public void setMaxIdenticalSequence(int maxIdenticalSequence) {
        this.maxIdenticalSequence = maxIdenticalSequence;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public void setMaxUnique(int maxUnique) {
        this.maxUnique = maxUnique;
    }

    public void setMinGrowthSequence(int minGrowthSequence) {
        this.minGrowthSequence = minGrowthSequence;
    }

    public void setMinIdenticalSequence(int minIdenticalSequence) {
        this.minIdenticalSequence = minIdenticalSequence;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public void setMinUnique(int minUnique) {
        this.minUnique = minUnique;
    }

    public void setSymbol(char[] symbol) {
        this.symbol = symbol;
    }
}
