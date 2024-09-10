/**
 * 0 - MEMOP: load, store
 * 1 - LOADI: loadI
 * 2 - ARITHOP: add, sub, mult, lshift, rshift
 * 3 - OUTPUT: output
 * 4 - NOP: nop
 * 5 - CONSTANT: a non-negative integer
 * 6 - REGISTER: ‘r’ followed by a constant
 * 7 - COMMA: ‘,’
 * 8 - INTO: “=>”
 * 9 - EOF: input has been exhausted
 * 10 - EOL: end of the current line
 */

public class Parser {

    private Scanner scanner;

    public Parser(Scanner scanner) {
        this.scanner = scanner;
    }

    public void parseR() {
        Trio currentWord;
        boolean valid = true;
        while (valid) {
            currentWord = scanner.getNextWord();
            switch (currentWord.Category()) {
                case 0 -> {
                    if (currentWord.Words() == 0) {
                        currentWord = scanner.getNextWord();
                        if (currentWord.Category() == 6) {
                            currentWord = scanner.getNextWord();
                            if (currentWord.Category() == 8) {
                                currentWord = scanner.getNextWord();
                                if (currentWord.Category() == 6) {
                                    currentWord = scanner.getNextWord();
                                    if (currentWord.Category() != 10) {
                                        System.err.println("ERROR " + currentWord.Line() + ": Extraneous argument in load operation");
                                        scanner.getNextLine();
                                    }
                                } else {
                                    System.err.println("ERROR " + currentWord.Line() + ": Missing target register in load operation");
                                    scanner.getNextLine();
                                }
                            } else {
                                System.err.println("ERROR " + currentWord.Line() + ": Missing into symbol in load operation");
                                scanner.getNextLine();
                            }
                        } else {
                            System.err.println("ERROR " + currentWord.Line() + ": Missing source register in load operation");
                            scanner.getNextLine();
                        }
                    } else {
                        currentWord = scanner.getNextWord();
                        if (currentWord.Category() == 6) {
                            currentWord = scanner.getNextWord();
                            if (currentWord.Category() == 8) {
                                currentWord = scanner.getNextWord();
                                if (currentWord.Category() == 6) {
                                    currentWord = scanner.getNextWord();
                                    if (currentWord.Category() != 10) {
                                        System.err.println("ERROR " + currentWord.Line() + ": Extraneous argument in store operation");
                                        scanner.getNextLine();
                                    }
                                } else {
                                    System.err.println("ERROR " + currentWord.Line() + ": Missing target register in store operation");
                                    scanner.getNextLine();
                                }
                            } else {
                                System.err.println("ERROR " + currentWord.Line() + ": Missing into symbol in store operation");
                                scanner.getNextLine();
                            }
                        } else {
                            System.err.println("ERROR " + currentWord.Line() + ": Missing source register in store operation");
                            scanner.getNextLine();
                        }
                    }
                }
                case 1 -> {
                    currentWord = scanner.getNextWord();
                    if (currentWord.Category() == 5) {
                        currentWord = scanner.getNextWord();
                        if (currentWord.Category() == 8) {
                            currentWord = scanner.getNextWord();
                            if (currentWord.Category() == 6) {
                                currentWord = scanner.getNextWord();
                                if (currentWord.Category() != 10) {
                                    System.err.println("ERROR " + currentWord.Line() + ": Extraneous argument in loadI operation");
                                    scanner.getNextLine();
                                }
                            } else {
                                System.err.println("ERROR " + currentWord.Line() + ": Missing target register in loadI operation");
                                scanner.getNextLine();
                            }
                        } else {
                            System.err.println("ERROR " + currentWord.Line() + ": Missing into symbol in loadI operation");
                            scanner.getNextLine();
                        }
                    } else {
                        System.err.println("ERROR " + currentWord.Line() + ": Missing constant in loadI operation");
                        scanner.getNextLine();
                    }
                }
                case 2 -> {
                    if (currentWord.Words() == 0) {
                        currentWord = scanner.getNextWord();
                        if (currentWord.Category() == 6) {
                            currentWord = scanner.getNextWord();
                            if (currentWord.Category() == 7) {
                                currentWord = scanner.getNextWord();
                                if (currentWord.Category() == 6) {
                                    currentWord = scanner.getNextWord();
                                    if (currentWord.Category() == 8) {
                                        currentWord = scanner.getNextWord();
                                        if (currentWord.Category() == 6) {
                                            currentWord = scanner.getNextWord();
                                            if (currentWord.Category() != 10) {
                                                System.err.println("ERROR " + currentWord.Line() + ": Extraneous argument in add operation");
                                                scanner.getNextLine();
                                            }
                                        } else {
                                            System.err.println("ERROR " + currentWord.Line() + ": Missing target register in add operation");
                                            scanner.getNextLine();
                                        }
                                    } else {
                                        System.err.println("ERROR " + currentWord.Line() + ": Missing into symbol in add operation");
                                        scanner.getNextLine();
                                    }
                                } else {
                                    System.err.println("ERROR " + currentWord.Line() + ": Missing second source register in add operation");
                                    scanner.getNextLine();
                                }
                            } else {
                                System.err.println("ERROR " + currentWord.Line() + ": Missing comma between source registers in add operation");
                                scanner.getNextLine();
                            }
                        } else {
                            System.err.println("ERROR " + currentWord.Line() + ": Missing first source register in add operation");
                            scanner.getNextLine();
                        }
                    } else if (currentWord.Words() == 1) {
                        currentWord = scanner.getNextWord();
                        if (currentWord.Category() == 6) {
                            currentWord = scanner.getNextWord();
                            if (currentWord.Category() == 7) {
                                currentWord = scanner.getNextWord();
                                if (currentWord.Category() == 6) {
                                    currentWord = scanner.getNextWord();
                                    if (currentWord.Category() == 8) {
                                        currentWord = scanner.getNextWord();
                                        if (currentWord.Category() == 6) {
                                            currentWord = scanner.getNextWord();
                                            if (currentWord.Category() != 10) {
                                                System.err.println("ERROR " + currentWord.Line() + ": Extraneous argument in sub operation");
                                                scanner.getNextLine();
                                            }
                                        } else {
                                            System.err.println("ERROR " + currentWord.Line() + ": Missing target register in sub operation");
                                            scanner.getNextLine();
                                        }
                                    } else {
                                        System.err.println("ERROR " + currentWord.Line() + ": Missing into symbol in sub operation");
                                        scanner.getNextLine();
                                    }
                                } else {
                                    System.err.println("ERROR " + currentWord.Line() + ": Missing second source register in sub operation");
                                    scanner.getNextLine();
                                }
                            } else {
                                System.err.println("ERROR " + currentWord.Line() + ": Missing comma between source registers in sub operation");
                                scanner.getNextLine();
                            }
                        } else {
                            System.err.println("ERROR " + currentWord.Line() + ": Missing first source register in sub operation");
                            scanner.getNextLine();
                        }
                    } else if (currentWord.Words() == 2) {
                        currentWord = scanner.getNextWord();
                        if (currentWord.Category() == 6) {
                            currentWord = scanner.getNextWord();
                            if (currentWord.Category() == 7) {
                                currentWord = scanner.getNextWord();
                                if (currentWord.Category() == 6) {
                                    currentWord = scanner.getNextWord();
                                    if (currentWord.Category() == 8) {
                                        currentWord = scanner.getNextWord();
                                        if (currentWord.Category() == 6) {
                                            currentWord = scanner.getNextWord();
                                            if (currentWord.Category() != 10) {
                                                System.err.println("ERROR " + currentWord.Line() + ": Extraneous argument in mult operation");
                                                scanner.getNextLine();
                                            }
                                        } else {
                                            System.err.println("ERROR " + currentWord.Line() + ": Missing target register in mult operation");
                                            scanner.getNextLine();
                                        }
                                    } else {
                                        System.err.println("ERROR " + currentWord.Line() + ": Missing into symbol in mult operation");
                                        scanner.getNextLine();
                                    }
                                } else {
                                    System.err.println("ERROR " + currentWord.Line() + ": Missing second source register in mult operation");
                                    scanner.getNextLine();
                                }
                            } else {
                                System.err.println("ERROR " + currentWord.Line() + ": Missing comma between source registers in mult operation");
                                scanner.getNextLine();
                            }
                        } else {
                            System.err.println("ERROR " + currentWord.Line() + ": Missing first source register in mult operation");
                            scanner.getNextLine();
                        }
                    } else if (currentWord.Words() == 3) {
                        currentWord = scanner.getNextWord();
                        if (currentWord.Category() == 6) {
                            currentWord = scanner.getNextWord();
                            if (currentWord.Category() == 7) {
                                currentWord = scanner.getNextWord();
                                if (currentWord.Category() == 6) {
                                    currentWord = scanner.getNextWord();
                                    if (currentWord.Category() == 8) {
                                        currentWord = scanner.getNextWord();
                                        if (currentWord.Category() == 6) {
                                            currentWord = scanner.getNextWord();
                                            if (currentWord.Category() != 10) {
                                                System.err.println("ERROR " + currentWord.Line() + ": Extraneous argument in lshift operation");
                                                scanner.getNextLine();
                                            }
                                        } else {
                                            System.err.println("ERROR " + currentWord.Line() + ": Missing target register in lshift operation");
                                            scanner.getNextLine();
                                        }
                                    } else {
                                        System.err.println("ERROR " + currentWord.Line() + ": Missing into symbol in lshift operation");
                                        scanner.getNextLine();
                                    }
                                } else {
                                    System.err.println("ERROR " + currentWord.Line() + ": Missing second source register in lshift operation");
                                    scanner.getNextLine();
                                }
                            } else {
                                System.err.println("ERROR " + currentWord.Line() + ": Missing comma between source registers in lshift operation");
                                scanner.getNextLine();
                            }
                        } else {
                            System.err.println("ERROR " + currentWord.Line() + ": Missing first source register in lshift operation");
                            scanner.getNextLine();
                        }
                    } else {
                        currentWord = scanner.getNextWord();
                        if (currentWord.Category() == 6) {
                            currentWord = scanner.getNextWord();
                            if (currentWord.Category() == 7) {
                                currentWord = scanner.getNextWord();
                                if (currentWord.Category() == 6) {
                                    currentWord = scanner.getNextWord();
                                    if (currentWord.Category() == 8) {
                                        currentWord = scanner.getNextWord();
                                        if (currentWord.Category() == 6) {
                                            currentWord = scanner.getNextWord();
                                            if (currentWord.Category() != 10) {
                                                System.err.println("ERROR " + currentWord.Line() + ": Extraneous argument in rshift operation");
                                                scanner.getNextLine();
                                            }
                                        } else {
                                            System.err.println("ERROR " + currentWord.Line() + ": Missing target register in rshift operation");
                                            scanner.getNextLine();
                                        }
                                    } else {
                                        System.err.println("ERROR " + currentWord.Line() + ": Missing into symbol in rshift operation");
                                        scanner.getNextLine();
                                    }
                                } else {
                                    System.err.println("ERROR " + currentWord.Line() + ": Missing second source register in rshift operation");
                                    scanner.getNextLine();
                                }
                            } else {
                                System.err.println("ERROR " + currentWord.Line() + ": Missing comma between source registers in rshift operation");
                                scanner.getNextLine();
                            }
                        } else {
                            System.err.println("ERROR " + currentWord.Line() + ": Missing first source register in rshift operation");
                            scanner.getNextLine();
                        }
                    }
                }
                case 3 -> {
                    currentWord = scanner.getNextWord();
                    if (currentWord.Category() == 5) {
                        currentWord = scanner.getNextWord();
                        if (currentWord.Category() != 10) {
                            System.err.println("ERROR " + currentWord.Line() + ": Extraneous argument in the output operation");
                            scanner.getNextLine();
                        }
                    } else {
                        System.err.println("ERROR " + currentWord.Line() + ": Missing constant in output operation");
                        scanner.getNextLine();
                    }
                }
                case 4 -> {
                    currentWord = scanner.getNextWord();
                    if (currentWord.Category() != 10) {
                        System.err.println("ERROR " + currentWord.Line() + ": extraneous argument in the nop operation");
                        scanner.getNextLine();
                    }
                }
                case 9 -> {
                    valid = false;
                }
                case 10 -> {
                    continue;
                }
                default -> {
                    System.err.println("ERROR " + currentWord.Line() + ": illegal start to a line");
                    scanner.getNextLine();
                }
            }
        }
    }

    public void parseP() {
        Trio currentWord;
        do {
            currentWord = scanner.getNextWord();
        } while (!currentWord.isEOF());
        if (scanner.hasErrors()) {
            System.err.println("Parse found errors");
        } else {
            System.out.println("Parse succeeded");
        }
    }
}
