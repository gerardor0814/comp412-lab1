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

    public Pair getNextWord() {
        String nextWord = "";

        if (currentIndex < currentLine.length()) {
            while (currentLine.charAt(currentIndex) == ' ') {
                currentIndex++;
                if (currentIndex == currentLine.length()) {
                    return new Pair(10, 0);
                }
            }
        } else {
            this.getNextLine();
            if (this.currentLine == null) {
                return new Pair(9, 0);
            } else {
                return new Pair(10, 0);
            }
        }

        while (currentIndex < currentLine.length()) {
            char currentChar = currentLine.charAt(currentIndex);
            if (currentLine.charAt(currentIndex) == '/') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == '/') {
                    this.getNextLine();
                    return new Pair(10,0);
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
                                return new Pair(0, 1);
                            }
                        }
                    }
                } else if (currentLine.charAt(currentIndex) == 'u') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'b') {
                        currentIndex++;
                        return new Pair(2, 1);
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
                                     return new Pair(1, 0);
                                 } else {
                                     currentIndex--;
                                     return new Pair(0, 0);
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
                                        return new Pair(2, 3);
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
                                        return new Pair(2, 4);
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
                        return new Pair(6, currentVal);
                    }
            } else if (currentLine.charAt(currentIndex) == 'm') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == 'u') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'l') {
                        currentIndex++;
                        if (currentLine.charAt(currentIndex) == 't') {
                            currentIndex++;
                            return new Pair(2, 2);
                        }
                    }
                }

            } else if (currentLine.charAt(currentIndex) == 'a') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == 'd') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'd') {
                        currentIndex++;
                        return new Pair(2, 0);
                    }
                }

            } else if (currentLine.charAt(currentIndex) == 'n') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == 'o') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'p') {
                        currentIndex++;
                        return new Pair(4, 0);
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
                                    return new Pair(3, 0);
                                }
                            }
                        }
                    }
                }
            } else if (currentLine.charAt(currentIndex) == '=') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == '>') {
                    currentIndex++;
                    return new Pair(8, 0);
                }

            } else if (currentLine.charAt(currentIndex) == ',') {
                currentIndex++;
                return new Pair(7, 0);

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
                return new Pair(5, currentVal);
            } else {
                currentIndex++;
                if (currentIndex == this.currentLine.length()) {
                    getNextLine();
                    if (currentLine == null) {
                        return new Pair(9, 0);
                    }
                    return new Pair(10, 0);
                }
            }
        }
        return new Pair(0, 0);
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

    public int getCurrentLineIndex() {
        return currentLineIndex;
    }
}
            
