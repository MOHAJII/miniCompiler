package mini_compilateur.Lexer;

import java.util.*;

public class Lexer {
    private final String EQUAL = "EQUAL";
    private final String OPERAND = "OPERAND";
    private final String CONSTANT = "CONSTANT";
    private final String OPERATOR = "OPERATOR";
    private final String OPENPARENTHESE = "OPENPARENTHESE";
    private final String CLOSEPARENTHESE = "CLOSEPARENTHESE";

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
                tokens.add(new Token(CONSTANT, getDigits()));
            } else if (currentChar == '=') {
                tokens.add(new Token(EQUAL, Character.toString(currentChar)));
                currentIndex++;
            } else if (currentChar == '(') {
                tokens.add(new Token(OPENPARENTHESE, "("));
                currentIndex++;
            } else if (currentChar == ')') {
                tokens.add(new Token(CLOSEPARENTHESE, ")"));
                currentIndex++;
            } else if (Arrays.asList('*', '+', '/', '-').contains(currentChar)) {
                tokens.add(new Token(OPERATOR, Character.toString(currentChar)));
                currentIndex++;
            } else if (Character.isLetter(currentChar)) {
                tokens.add((new Token(OPERAND, getLetters())));
            } else {
                System.out.println("Char not found");
                break;
            }
        }
    }

    private List<Token> getTokens() {
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
