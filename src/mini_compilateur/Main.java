package mini_compilateur;

import mini_compilateur.Lexer.Lexer;
import mini_compilateur.Lexer.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("576 + (2 * (8 - 3))");
        lexer.makeTokens();

        System.out.printf(lexer.getTokens().toString());

    }
}
