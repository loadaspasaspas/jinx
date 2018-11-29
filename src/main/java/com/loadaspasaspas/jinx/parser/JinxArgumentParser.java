package com.loadaspasaspas.jinx.parser;

import com.loadaspasaspas.jinx.JinxSolverConfiguration;

public class JinxArgumentParser {

    private int current;
    private String[] args;

    public JinxArgumentParser() {
    }

    private boolean next() {
        return ++current < args.length;
    }

    private String value() {
        return args[current];
    }

    private int valueInt() throws NumberFormatException {
        return Integer.parseInt(args[current]);
    }

    public JinxSolverConfiguration parse(String[] args) throws ArgumentParserException {
        current = -1;
        this.args = args;
        JinxSolverConfiguration result = new JinxSolverConfiguration();

        while (next()) {
            switch (value()) {
                case "-count":
                    if (next()) {
                        try {
                            result.setKeyCount(valueInt());
                        } catch (NumberFormatException e) {
                            throw new ArgumentParserException("Invalid count format.");
                        }
                    } else {
                        throw new ArgumentParserException("Invalid count format.");
                    }

                    break;
                case "-key":
                    if (next()) {
                        char[] key = value().toCharArray();
                        int[] pKey = new int[key.length];

                        for (int i = 0; i < key.length; i++) {
                            switch (key[i]) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    pKey[i] = key[i] - '0';
                                    break;
                                case 'a':
                                case 'b':
                                case 'c':
                                case 'd':
                                case 'e':
                                case 'f':
                                    pKey[i] = key[i] - 'a' + 10;
                                    break;
                                case 'A':
                                case 'B':
                                case 'C':
                                case 'D':
                                case 'E':
                                case 'F':
                                    pKey[i] = key[i] - 'A' + 10;
                                    break;
                                default:
                                    throw new ArgumentParserException("Unknown key character.");
                            }
                        }

                        result.setInitialKey(pKey);
                    } else {
                        throw new ArgumentParserException("Invalid key format.");
                    }

                    break;
                default:
                    throw new ArgumentParserException("Unknown command option " + value() + ".");
            }
        }

        return result;
    }
}
