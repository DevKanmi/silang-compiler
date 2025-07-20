package silang.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    private int start = 0;
    private int current = 0;
    private int line = 1;

    public  Lexer(String source){
        this.source = source;
    }

    public List<Token> tokenize(){
        while(!isAtEnd()){
            start = current;
            scanToken();
        }

        tokens.add(new Token(TokenType.EOF, "", null, line));
        return tokens;
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    //Scanning logic
    private void scanToken() {
        char c = advance();

    }

    private char advance() {
        return source.charAt(current++);
    }
}
