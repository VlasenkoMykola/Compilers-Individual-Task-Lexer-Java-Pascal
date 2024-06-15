import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
	    // comment.pas circle.pas
            InputStream in = new BufferedInputStream(new FileInputStream("circle.pas"));
            ArrayList<String> keywords = readWordlist("pascal-reserved-keywords.txt");
            Lexer lexer = new Lexer(in, keywords);
            List<Token> tokens = lexer.analyze();
            int currentLine = -1;
            for (Token token : tokens) {
                if (token.getLine() != currentLine) {
                    System.out.println();
                    currentLine = token.getLine();
                    System.out.print(currentLine+1 + ":     ");
                }
                System.out.print("(" + token.getType().toString());
                if (!token.getValue().equals("") || token.getType() == TokenType.STRING_LITERAL) {
                    System.out.print(", " + token.getValue());
                }
                System.out.print(")  ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> readWordlist(String fileName) throws FileNotFoundException {
	File file = new File(fileName);
	if (!file.exists()) {
	    file = new File("src/main/resources/" + fileName);
	}
        Scanner scanner = new Scanner(file);
        ArrayList<String> wordlist = new ArrayList<>();
        while (scanner.hasNext()){
            String word = scanner.next();
            wordlist.add(word);
        }

        return wordlist;
    }

}
