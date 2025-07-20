import silang.lexer.Lexer;
import silang.lexer.Token;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String source = Files.readString(Paths.get("src/test/test_programs/simple.sg"));
        Lexer lexer = new Lexer(source);
        List<Token> tokens = lexer.tokenize();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}

