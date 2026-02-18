package Advanced_Calculator;
import java.util.*;
public class CalculationHistory {
    private List<String> calculation = new ArrayList<>();

    public void add(String operation) {
        calculation.add(operation);
    }

    public void show() {
        System.out.println();
        System.out.println("History of Calculation :");
        for (String op : calculation) {
            System.out.println("➤ " + op);
        }
    }
}

