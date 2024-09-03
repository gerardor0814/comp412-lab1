import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Scanner {

    private BufferedReader bufferedReader;
    private int currentIndex;
    FileReader fileReader;
    private String currentLine;
    private int currentLineIndex;

    public Scanner(String fileName) {

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Could not open file " + fileName + " as the input file.");
            return;
        }
        bufferedReader = new BufferedReader(fileReader);
        currentLineIndex = 0;
        this.getNextLine();
        currentIndex = 0;
    }

    public Pair<String, String> getNextWord() {
        String nextWord = "";

        if (currentIndex < currentLine.length()) {
            while (currentLine.charAt(currentIndex) == ' ') {
                currentIndex++;
                if (currentIndex == currentLine.length()) {
                    return new Pair<>("NEWLINE", "\"\\n\"");
                }
            }
        } else {
            this.getNextLine();
            if (this.currentLine == null) {
                return new Pair<>("ENDFILE", "\"\"");
            } else {
                return new Pair<>("NEWLINE", "\"\\n\"");
            }
        }

        while (currentIndex < currentLine.length()) {
            char currentChar = currentLine.charAt(currentIndex);
            if (currentLine.charAt(currentIndex) == '/') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == '/') {
                    this.getNextLine();
                    return new Pair<>("NEWLINE", "\"\\n\"");
                }
            }
            if (currentLine.charAt(currentIndex) == 's') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == 't') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'o') {
                        currentIndex++;
                        if (currentLine.charAt(currentIndex) == 'r') {
                            currentIndex++;
                            if (currentLine.charAt(currentIndex) == 'e') {
                                currentIndex++;
                                return new Pair<>("MEMOP", "\"store\"");
                            }
                        }
                    }
                } else if (currentLine.charAt(currentIndex) == 'u') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'b') {
                        currentIndex++;
                        return new Pair<>("ARITHOP", "\"sub\"");
                    }
                }
            } else if (currentLine.charAt(currentIndex) == 'l') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'o') {
                         currentIndex++;
                         if (currentLine.charAt(currentIndex) == 'a') {
                             currentIndex++;
                             if (currentLine.charAt(currentIndex) == 'd') {
                                 currentIndex++;
                                 if (currentLine.charAt(currentIndex) == 'I') {
                                     currentIndex++;
                                     return new Pair<>("LOADI", "\"loadI\"");
                                 } else {
                                     currentIndex--;
                                     return new Pair<>("MEMOP", "\"load\"");
                                 }
                             }
                         }
                    } else if (currentLine.charAt(currentIndex) == 's') {
                        currentIndex++;
                        if (currentLine.charAt(currentIndex) == 'h') {
                            currentIndex++;
                            if (currentLine.charAt(currentIndex) == 'i') {
                                currentIndex++;
                                if (currentLine.charAt(currentIndex) == 'f') {
                                    currentIndex++;
                                    if (currentLine.charAt(currentIndex) == 't') {
                                        currentIndex++;
                                        return new Pair<>("ARITHOP", "\"lshift\"");
                                    }
                                }
                            }
                        }
                    }
                } else if (currentLine.charAt(currentIndex) == 'r') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 's') {
                        currentIndex++;
                        if (currentLine.charAt(currentIndex) == 'h') {
                            currentIndex++;
                            if (currentLine.charAt(currentIndex) == 'i') {
                                currentIndex++;
                                if (currentLine.charAt(currentIndex) == 'f') {
                                    currentIndex++;
                                    if (currentLine.charAt(currentIndex) == 't') {
                                        currentIndex++;
                                        return new Pair<>("ARITHOP", "\"rshift\"");
                                    }
                             }
                        }
                    }
                } else if (currentLine.charAt(currentIndex) >= '0' && currentLine.charAt(currentIndex) <= '9') {
                        int currentVal = 0;
                        int temp;
                        while (currentLine.charAt(currentIndex) >= '0' && currentLine.charAt(currentIndex) <= '9') {
                            temp = Character.getNumericValue(currentLine.charAt(currentIndex));
                            currentVal = currentVal * 10 + temp;
                            currentIndex++;
                            if (currentIndex > currentLine.length() - 1) {
                                break;
                            }
                        }
                        return new Pair<>("REG", "\"r" + currentVal + "\"");
                    }
            } else if (currentLine.charAt(currentIndex) == 'm') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == 'u') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'l') {
                        currentIndex++;
                        if (currentLine.charAt(currentIndex) == 't') {
                            currentIndex++;
                            return new Pair<>("ARITHOP", "\"mult\"");
                        }
                    }
                }

            } else if (currentLine.charAt(currentIndex) == 'a') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == 'd') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'd') {
                        currentIndex++;
                        return new Pair<>("ARITHOP", "\"add\"");
                    }
                }

            } else if (currentLine.charAt(currentIndex) == 'n') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == 'o') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'p') {
                        currentIndex++;
                        return new Pair<>("NOP", "\"nop\"");
                    }
                }

            } else if (currentLine.charAt(currentIndex) == 'o') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == 'u') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 't') {
                        currentIndex++;
                        if (currentLine.charAt(currentIndex) == 'p') {
                            currentIndex++;
                            if (currentLine.charAt(currentIndex) == 'u') {
                                currentIndex++;
                                if (currentLine.charAt(currentIndex) == 't') {
                                    currentIndex++;
                                    return new Pair<>("OUTPUT", "\"output\"");
                                }
                            }
                        }
                    }
                }
            } else if (currentLine.charAt(currentIndex) == '=') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == '>') {
                    currentIndex++;
                    return new Pair<>("INTO", "\"=>\"");
                }

            } else if (currentLine.charAt(currentIndex) == ',') {
                currentIndex++;
                return new Pair<>("COMMA", "\",\"");

            } else if (currentLine.charAt(currentIndex) >= '0' && currentLine.charAt(currentIndex) <= '9') {
                int currentVal = 0;
                int temp;
                while (currentLine.charAt(currentIndex) >= '0' && currentLine.charAt(currentIndex) <= '9') {
                    temp = Character.getNumericValue(currentLine.charAt(currentIndex));
                    currentVal = currentVal * 10 + temp;
                    currentIndex++;
                    if (currentIndex > currentLine.length() - 1) {
                        break;
                    }
                }
                return new Pair<>("CONST", "\"" + currentVal + "\"");
            } else {
                currentIndex++;
                if (currentIndex == this.currentLine.length()) {
                    getNextLine();
                    if (currentLine == null) {
                        return new Pair<>("ENDFILE", "\"\"");
                    }
                    return new Pair<>("NEWLINE", "\"\\n\"");
                }
            }
        }
        return new Pair<>(nextWord, nextWord);
    }

    private void getNextLine() {
        try {
            currentLine = bufferedReader.readLine();
            currentLineIndex++;
        } catch (IOException e) {
            System.out.println("ERROR: Could not read next line from file");
        }
        currentIndex = 0;
    }

    public int getCurrentLine() {
        return currentLineIndex;
    }
}
            
