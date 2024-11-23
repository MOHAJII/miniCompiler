package mini_compilateur;

import mini_compilateur.Lexer.Lexer;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("A = 576 + (2 * (8 - 3))");
        System.out.println("\r mohammed");
        System.out.println(lexer.getTokens());

    }
}
