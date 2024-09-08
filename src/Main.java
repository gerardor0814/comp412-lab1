import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String helpStatement = """
                Command Syntax:
                        ./lab1_ref [flags] filename

                Required arguments:
                        filename  is the pathname (absolute or relative) to the input file

                Optional flags:
                        -h       prints this message

                At most one of the following three flags:
                        -s       prints tokens in token stream
                        -p       invokes parser and reports on success or failure
                        -r       prints human readable version of parser's IR
                If none is specified, the default action is '-p'.""";
        String fileName = "";
        int option = 0;
        boolean multipleFlags = false;
        for (String arg : args) {
            switch (arg) {
                case "-h" -> {
                    System.out.println(helpStatement);
                    return;
                }
                case "-s" -> {
                    if (option != 0) {
                        multipleFlags = true;
                    } else {
                        option = 1;
                    }
                }
                case "-p" -> {
                    if (option != 0) {
                        multipleFlags = true;
                    }
                    if (option < 2) {
                        option = 2;
                    }
                }
                case "-r" -> {
                    if (option != 0) {
                        multipleFlags = true;
                    }
                    option = 3;
                }
                default -> {
                    if (fileName.isEmpty()) {
                        fileName = arg;
                    } else {
                        System.out.println("ERROR:  Attempt to open more than one input file.\n");
                        System.out.println(helpStatement);
                        return;
                    }
                }
            }
        }
        if (multipleFlags){
            System.out.println("ERROR:  Multiple command-line flags found.\n" +
                    "        Try '-h' for information on command-line syntax.");
        }

        if (option == 0){
            option = 2;
        }

        Scanner scanner = new Scanner(fileName);

        switch (option) {
            case 1:
                runSFlag(scanner);
                break;
            case 2:
                runPFlag(scanner);
                break;
            case 3:
                runRFlag(scanner);
                break;
            default:
                System.out.println("ERROR:  Unknown option.");
        }

    }

    public static void runSFlag(Scanner scanner) throws IOException {
        while (true) {
            Trio currentWord = scanner.getNextWord();
            System.out.print(currentWord);
            if (currentWord.isEOF()) {
                break;
            }
        }
    }

    public static void runPFlag(Scanner scanner){

    }

    public static void runRFlag(Scanner scanner){

    }
}