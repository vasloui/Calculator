import java.util.Objects;

public class Operations {

    static Temps temps = new Temps();
    Save save = new Save();

    // Calculates, sets and prints the result.
    public String calculations() {

//        String result = null;

        if (Objects.equals(temps.getOperator(), "1")) {
            temps.setResult(add(temps.getFirst(), temps.getSecond()));

        } else if (Objects.equals(temps.getOperator(), "2")) {
            temps.setResult(minus(temps.getFirst(), temps.getSecond()));

        } else if (Objects.equals(temps.getOperator(), "3")) {
            temps.setResult(multiply(temps.getFirst(), temps.getSecond()));

        } else if (Objects.equals(temps.getOperator(), "4")) {
            temps.setResult(exponent(temps.getFirst(), temps.getSecond()));

        } else if (Objects.equals(temps.getOperator(), "5")) {
            temps.setResult(sqrRoot(temps.getFirst()));
//            if (!Objects.equals(temps.getResult(), 0)) {
//            }
        }

        return "Result is: " + String.valueOf(temps.getResult());
    }

    // Adds two numbers.
    private double add(double first, double second) {
        return first + second;
    }

    // Subtracts one number from one other.
    private double minus(double first, double second) {
        return first - second;
    }

    // Finds the product of two numbers.
    private double multiply(double first, double second) {
        return first * second;
    }

    // Finds the power off one number.
    private double exponent(double first, double second) {
        double ifirst = 1;
        double isecond = 0;
        for (int i = 0; i < second; i++) {
            ifirst = ifirst * first;
            isecond++;
        }
        if ((second - isecond) != 0) {
            System.out.println("Can only perform calculations with natural numbers as the exponent.");
        }
        return ifirst;
    }

    // Finds the square root of a number.
    private double sqrRoot(double first) {
        double ifirst = 1;
        double isecond = 0;
        root:
        while (true) {
            isecond++;
            ifirst = isecond * isecond;
            if (Objects.equals(ifirst, first)) {
                break root;
            }
            if (ifirst > first) {
                isecond = 0;
                System.out.println("Number may not have a square root that is a natural number.");
                break root;
            }
        }
        return isecond;
    }
}
