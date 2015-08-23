package newinterface;

/**
 * Created by tangl9 on 2015-08-11.
 */
public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
