package lambda;

/**
 * Created by darlingtld on 2015/8/23 0023.
 */
public class Lambda2 {

    public static void main(String[] args) {

        FunctionalDefaultLambda functionalDefaultLambda = new FunctionalDefaultLambda() {
            @Override
            public void method() {
                System.out.println("lambda");
            }
        };
        FunctionalDefaultLambda functionalDefaultLambda1 = () -> System.out.println("lambda");
    }
}
