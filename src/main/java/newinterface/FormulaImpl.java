package newinterface;

/**
 * Created by tangl9 on 2015-08-11.
 */
public class FormulaImpl implements Formula {
    @Override
    public double calculate(int a) {
        return a * 10;
    }

    public static void main(String[] args) {
        Formula formula = new FormulaImpl();
        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
    }
}
