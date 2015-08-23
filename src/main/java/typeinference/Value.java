package typeinference;

/**
 * Created by darlingtld on 2015/8/23 0023.
 */
public class Value<T> {
    public static <T> T defaultValue() {
        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return (value != null) ? value : defaultValue;
    }

    public static void main(String[] args) {
        final Value<String> value = new Value<>();
        System.out.println(value.getOrDefault("123", Value.defaultValue()));
    }

}