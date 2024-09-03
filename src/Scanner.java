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

    public String getNextWord() {
        String nextWord = "";

        if (currentIndex < currentLine.length()) {
            while (currentLine.charAt(currentIndex) == ' ') {
                currentIndex++;
                if (currentIndex == currentLine.length()) {
                    return "\n";
                }
            }
        } else {
            nextWord = "\n";
            this.getNextLine();
            if (this.currentLine == null) {
                return "";
            }
            return nextWord;
        }

        while (currentIndex < currentLine.length()) {
            if (currentLine.charAt(currentIndex) == ' ') {
                break;
            }
            if (currentLine.charAt(currentIndex) == '/') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == '/') {
                    this.getNextLine();
                    return "\n";
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
                                return "store";
                            }
                        }
                    }
                } else if (currentLine.charAt(currentIndex) == 'u') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'b') {
                        return "sub";
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
                                     return "loadI";
                                 } else {
                                     currentIndex--;
                                     return "load";
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
                                        return "lshift";
                                    }
                                }
                            }
                        }
                    }
                } else if (currentLine.charAt(currentIndex) == 'r') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 's'){
                        currentIndex++;
                        if (currentLine.charAt(currentIndex) == 'h') {
                            currentIndex++;
                            if (currentLine.charAt(currentIndex) == 'i') {
                                currentIndex++;
                                if (currentLine.charAt(currentIndex) == 'f') {
                                    currentIndex++;
                                    if (currentLine.charAt(currentIndex) == 't') {
                                        return "rshift";
                                    }
                             }
                        }
                    }
                }
            } else if (currentLine.charAt(currentIndex) == 'm') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == 'u') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'l') {
                        currentIndex++;
                        if (currentLine.charAt(currentIndex) == 't') {
                            return "mult";
                        }
                    }
                }

            } else if (currentLine.charAt(currentIndex) == 'a') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == 'd') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'd') {
                        return "add";
                    }
                }
                
            } else if (currentLine.charAt(currentIndex) == 'n') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == 'o') {
                    currentIndex++;
                    if (currentLine.charAt(currentIndex) == 'p') {
                        return "nop";
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
                                    return "output";
                                }
                            }
                        }
                    }
                }
            } else if (currentLine.charAt(currentIndex) == '=') {
                currentIndex++;
                if (currentLine.charAt(currentIndex) == '>') {
                    return "=>";
                }

            } else if (currentLine.charAt(currentIndex) == ',') {
                currentIndex++;
                return ",";
                
            } else {
                currentIndex++;
                if (currentIndex == this.currentLine.length()) {
                    getNextLine();
                    if (currentLine == null) {
                        return "";
                    }
                    return "\n";
                }
                return " ";
            }
        }
        return nextWord;
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
}
            
