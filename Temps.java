import java.util.Scanner;

// This class allows modification on basic variables, that need to be used across classes.
public class Temps {
    Scanner scanner = new Scanner(System.in);

    private String input; // The input the user gave
    private String operator; // The choice of the operator
    private double first; // First numeric input
    private double second; // Second numeric input
    private double result; // Result of calculation


    Temps() {
        this.operator = null;
        this.first = 0;
        this.second = 0;
        this.result = 0;
        this.input = null;


    }

    // Setters
    public void setInput(String input) {
        this.input = input;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public void setResult(double result) {
        this.result = result;
    }

    // Getters
    public String getInput() {
        return input;
    }

    public String getOperator() {
        return operator;
    }

    public double getFirst() {
        return first;
    }

    public double getSecond() {
        return second;
    }

    public double getResult() {
        return result;
    }


}
