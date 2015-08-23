package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tangl9 on 2015-08-12.
 */
public class CollectionSort {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("less", "wallace", "sven", "bobby");

        // sort list with old java style
        sortNames(names);

        System.out.println(names);

        List<String> names2 = Arrays.asList("less", "wallace", "sven", "bobby");
        // sort list with lambda
        sortNamesLambda(names2);

        System.out.println(names2);

    }

    private static void sortNamesLambda(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
    }

    private static void sortNames(List<String> names) {
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
    }
}
