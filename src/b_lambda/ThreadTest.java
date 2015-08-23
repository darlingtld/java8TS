package b_lambda;

import java.util.function.Function;

/**
 * Created by tangl9 on 2015-08-14.
 */
public class ThreadTest {
    public static void main(String[] args) {

        Thread t = new Thread(
                () -> {
                    System.out.println("Hello from a thread in run");
                }
        );

        Function<Integer, String> f = new Function<Integer, String>() {
            @Override
            public String apply(Integer t) {
                return null;
            }
        };
//        Function<Integer, String> f2 = (t) -> String.valueOf(t);
//        Function<Integer, String> f1 = String::valueOf;
    }
}
