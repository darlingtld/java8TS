package lambda;

/**
 * Created by darlingtld on 2015/8/23 0023.
 */
@FunctionalInterface
public interface FunctionalDefaultLambda {

    void method();

    default void defaultMethod() {
        System.out.println("default method");
    }

    static void staticMethod() {
        System.out.println("static method");
    }
}
