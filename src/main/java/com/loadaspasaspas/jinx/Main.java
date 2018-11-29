package com.loadaspasaspas.jinx;

import com.loadaspasaspas.jinx.parser.ArgumentParserException;
import com.loadaspasaspas.jinx.parser.JinxArgumentParser;

public class Main {

    public static void main(String[] args) {
        try {
            JinxArgumentParser parser = new JinxArgumentParser();
            JinxSolverConfiguration config = parser.parse(args);

            JinxSolver solver = new JinxSolver(config);

            solver.printNext(config.getKeyCount());
        } catch (ArgumentParserException e) {
            e.printStackTrace();
        }
    }
}