package function;

/**
 * Created by tangl9 on 2015-08-14.
 */

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

