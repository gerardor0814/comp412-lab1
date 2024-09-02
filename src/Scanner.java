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

    public Scanner(String fileName) throws IOException {

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

    public String getNextWord() throws IOException {
        String nextWord = "";

        if (currentIndex < currentLine.length()) {
            while (currentLine.charAt(currentIndex) == ' ') {
                nextWord += ' ';
                currentIndex++;
            }
        } else {
            nextWord += '\n';
            System.out.print(" " + currentLineIndex);
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
                    return "// \n";
                }
            }
            nextWord += currentLine.charAt(currentIndex);
            currentIndex++;
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
