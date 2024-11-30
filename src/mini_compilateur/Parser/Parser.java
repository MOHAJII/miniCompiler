package mini_compilateur.Parser;

import mini_compilateur.Lexer.Token;
import mini_compilateur.Lexer.TokenType;

public class Parser {
    private final TokenStream tokenStream;

    public Parser(TokenStream tokenStream) {
        this.tokenStream = tokenStream;
    }

    public void parse() {
        parseExpression();
    }

    private void parseExpression()  {
        parseTerme();
    }

    private void parseTerme() {
        Token token = tokenStream.getCurrentToken();
        tokenStream.advance();
    }


}
