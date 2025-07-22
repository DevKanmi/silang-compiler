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

    //Implement Scanning logic: here we are tryng to convert source code tokens as output.
    private void scanToken() {
        char c = advance();

        switch(c) {
            case '(': addToken(TokenType.LEFT_PAREN); break;
            case ')': addToken(TokenType.RIGHT_PAREN); break;
            case '{': addToken(TokenType.LEFT_BRACE); break;
            case '}': addToken(TokenType.RIGHT_BRACE); break;
            case ',': addToken(TokenType.COMMA); break;
            case ';': addToken(TokenType.SEMICOLON); break;

            case '+': addToken(TokenType.PLUS); break;
            case '-': addToken(TokenType.MINUS); break;
            case '*': addToken(TokenType.STAR); break;
            case '/': addToken(TokenType.SLASH); break;

            case '=': addToken(TokenType.ASSIGN); break;
            case '<': addToken(TokenType.LESS); break;
            case '>': addToken(TokenType.GREATER); break;

                // Whitespace & line tracking
            case ' ':
            case '\r':
            case '\t':
                // Ignore these
                break;
            case '\n':
                line++;
                break;

            default:
                System.out.println("Unexpected character: '" + c + "' at line " + line);
                break;

        }

    }

    private void addToken(TokenType type){
        addToken(type, null);
    }

    private void addToken(TokenType type, Object literal){
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }

    private char advance() {
        return source.charAt(current++);
    }
}
