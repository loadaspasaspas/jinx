package com.loadaspasaspas.jinx;

public class JinxSolverConfiguration {

    private int[][] differentialBounds;
    private int[] initialKey;
    private int keyCount;
    private int maxGrowthSequence;
    private int maxIdenticalSequence;
    private int maxNumberCount;
    private int maxUniqueCount;
    private int minGrowthSequence;
    private int minIdenticalSequence;
    private int minNumberCount;
    private int minUniqueCount;
    private char[] symbol;

    public JinxSolverConfiguration() {
        differentialBounds = new int[][]{{0, 15}, {0, 15}, {2, 24}, {3, 37}, {7, 50}, {8, 54}, {13, 62}, {15, 66}, {18, 78}, {19, 79}};
        initialKey = new int[10];
        symbol = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        keyCount = 0;
        maxGrowthSequence = 2;
        maxIdenticalSequence = 2;
        maxNumberCount = 8;
        maxUniqueCount = 9;
        minGrowthSequence = 0;
        minIdenticalSequence = 0;
        minNumberCount = 4;
        minUniqueCount = 6;
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

    public int getMaxNumberCount() {
        return maxNumberCount;
    }

    public int getMaxUniqueCount() {
        return maxUniqueCount;
    }

    public int getMinGrowthSequence() {
        return minGrowthSequence;
    }

    public int getMinIdenticalSequence() {
        return minIdenticalSequence;
    }

    public int getMinNumberCount() {
        return minNumberCount;
    }

    public int getMinUniqueCount() {
        return minUniqueCount;
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

    public void setMaxNumberCount(int maxNumberCount) {
        this.maxNumberCount = maxNumberCount;
    }

    public void setMaxUniqueCount(int maxUniqueCount) {
        this.maxUniqueCount = maxUniqueCount;
    }

    public void setMinGrowthSequence(int minGrowthSequence) {
        this.minGrowthSequence = minGrowthSequence;
    }

    public void setMinIdenticalSequence(int minIdenticalSequence) {
        this.minIdenticalSequence = minIdenticalSequence;
    }

    public void setMinNumberCount(int minNumberCount) {
        this.minNumberCount = minNumberCount;
    }

    public void setMinUniqueCount(int minUniqueCount) {
        this.minUniqueCount = minUniqueCount;
    }

    public void setSymbol(char[] symbol) {
        this.symbol = symbol;
    }
}
