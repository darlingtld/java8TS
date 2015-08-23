package c_function;

/**
 * Created by tangl9 on 2015-08-14.
 */
public class ConverterImpl {

    public static void main(String[] args){
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123


        Converter<String, Integer> converter1 = Integer::valueOf;
        Integer converted1 = converter1.convert("123");
        System.out.println(converted1);   // 123


        final int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        stringConverter.convert(2);
    }
}
