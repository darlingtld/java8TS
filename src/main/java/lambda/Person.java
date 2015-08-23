package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by tangl9 on 2015-08-14.
 */
public class Person {
    public String firstName;
    public String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {

    }

    public static Person create(final Supplier<Person> supplier) {
        return supplier.get();
    }

    public static void meet(final Person per) {
        System.out.println("Meet " + per.toString());
    }

    public void follow(final Person another) {
        System.out.println("Follow the " + another.toString());
    }

    public void breakup() {
        System.out.println("Break up with" + this.toString());
    }

    public static void main(String[] args) {
        final Person person1 = Person.create(Person::new);
        final Person person2 = Person.create(Person::new);
        final List<Person> personList = Arrays.asList(person1, person2);
        personList.forEach(Person::meet);
        personList.forEach(Person::breakup);
        final Person police = Person.create(Person::new);
        personList.forEach(police::follow);

        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0
    }
}
