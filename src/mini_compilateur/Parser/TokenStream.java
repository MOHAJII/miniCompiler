package mini_compilateur.Parser;

import mini_compilateur.Lexer.Token;

import java.util.List;

public class TokenStream {
    private final List<Token> tokens;
    private int position = 0;

    public TokenStream(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Token getCurrentToken() {
        return position < tokens.size() ? tokens.get(position) : null;
    }

    public void advance() {
        if (position < tokens.size()) position++;
    }

    public boolean isAtEnd() {
        return position >= tokens.size();
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
