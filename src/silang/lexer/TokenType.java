package silang.lexer;

public enum TokenType{

    // Keywords
    LET, IF, ELSE, PRINT, TRUE, FALSE,

    // Identifiers and literals
    IDENTIFIER, NUMBER,

    //Operators
    PLUS, MINUS, STAR, SLASH,
    GREATER, LESS, EQUAL_EQUAL, BANG_EQUAL,
    ASSIGN,

    //Extra-characters
    SEMICOLON, COMMA,
    LEFT_PAREN, RIGHT_PAREN,
    LEFT_BRACE, RIGHT_BRACE,

    //Special
    EOF
}
