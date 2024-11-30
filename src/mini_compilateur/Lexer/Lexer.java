package mini_compilateur.Lexer;

import java.util.*;

public class Lexer {
    private final String expression;
    private final int expressionLength;

    private int currentIndex;

    private final List<Token> tokens;

    public Lexer(String expression) {
        this.expression = expression;
        this.expressionLength = expression.length();
        this.currentIndex = 0;
        this.tokens = new ArrayList<>();
        makeTokens();
    }

    public void makeTokens() {
        while (currentIndex < expressionLength) {
            char currentChar = expression.charAt(currentIndex);

            if (Arrays.asList(' ', '\r', '\t').contains(currentChar)) {
                currentIndex++;
            } else if (Character.isDigit(currentChar)) {
                tokens.add(new Token(TokenType.CONSTANT, getDigits()));
            } else if (currentChar == '=') {
                tokens.add(new Token(TokenType.EQUAL, Character.toString(currentChar)));
                currentIndex++;
            } else if (currentChar == '(') {
                tokens.add(new Token(TokenType.OPENPARENTHESE, "("));
                currentIndex++;
            } else if (currentChar == ')') {
                tokens.add(new Token(TokenType.CLOSEPARENTHESE, ")"));
                currentIndex++;
            } else if (Arrays.asList('*', '+', '/', '-').contains(currentChar)) {
                tokens.add(new Token(TokenType.OPERATOR, Character.toString(currentChar)));
                currentIndex++;
            } else {
                System.out.println("Char not found");
                break;
            }
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    private String getDigits() {
        StringBuilder digits = new StringBuilder();
        while (currentIndex < expressionLength && Character.isDigit(expression.charAt(currentIndex))) {
            digits.append(expression.charAt(currentIndex));
            currentIndex++;
        }
        return digits.toString();
    }

    private String getLetters() {
        StringBuilder letters = new StringBuilder();
        while (currentIndex < expressionLength && Character.isLetter(expression.charAt(currentIndex))) {
            letters.append(expression.charAt(currentIndex));
            currentIndex++;
        }
        return letters.toString();
    }
}
