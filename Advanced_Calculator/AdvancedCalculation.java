package Advanced_Calculator;

public class AdvancedCalculation extends CalculatorBase{

    CalculationHistory history;

    public AdvancedCalculation() {
        history = new CalculationHistory();
        System.out.println("Smart Calculator Initialized!");
    }
    @Override
    public double add(double a, double b) {
        double res = a + b;
        history.add(a + " + " + b + " = " + res);
        return res;
    }
    @Override
    public double subtract(double a, double b) {
        double res = a - b;
        history.add(a + " - " + b + " = " + res);
        return res;
    }
    @Override
    public double multiply(double a, double b) {
        double res = a * b;
        history.add(a + " * " + b + " = " + res);
        return res;
    }
    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            history.add(a + " / " + b + " = Error (Divide by Zero)");
            System.out.println("Error: Cannot divide by zero");
            return Double.NaN;
        }
        double res = a / b;
        history.add(a + " / " + b + " = " + res);
        return res;
    }

    public double calculate(int a, int b, char op) {
        return calculate((double) a, (double) b, op);
    }

    public double calculate(double a, double b, char op) {
        switch (op) {
            case '+': return add(a, b);
            case '-': return subtract(a, b);
            case '*': return multiply(a, b);
            case '/': return divide(a, b);
            default:
                System.out.println("Invalid Operator");
                return Double.NaN;
        }
    }

    public void showHistory() {
        history.show();
    }
}
