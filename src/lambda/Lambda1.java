package lambda;

import java.util.Arrays;

/**
 * Created by darlingtld on 2015/8/23 0023.
 */
public class Lambda1 {
    public static void main(String[] args) {
        Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));
        System.out.println("==========================================");

        Arrays.asList("a", "b", "d").forEach((String e) -> System.out.println(e));
        System.out.println("==========================================");
        Arrays.asList("a", "b", "d").forEach(e -> {
            System.out.println(e);
            System.out.println(e);
        });
        System.out.println("==========================================");
        String separator = ",";
        Arrays.asList("a", "b", "d").forEach(
                (String e) -> System.out.print(e + separator));

        System.out.println();
        System.out.println("==========================================");

        Arrays.asList("a", "b", "d").sort((e1, e2) -> e1.compareTo(e2));

        Arrays.asList("a", "b", "d").sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });
    }
}
