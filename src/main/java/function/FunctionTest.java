package function;

import lambda.Person;

import java.util.Objects;
import java.util.function.*;

/**
 * Created by darlingtld on 2015/8/23 0023.
 */
public class FunctionTest {
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        Function<String, Integer> atoi = s -> Integer.parseInt(s);
        System.out.println(atoi.apply("12345"));

        BiFunction<Integer,Integer,Integer> sum = (t1, t2) -> t1+t2;
        System.out.println(sum.apply(12,23));



        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");     // "123"

        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }
}
