package javacompiler;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by darlingtld on 2015/8/23 0023.
 */
public class ParameterNames {
    public void method(String a, int b, double c) {

    }

    public static void main(String[] args) throws Exception {
        Method method = ParameterNames.class.getMethod("method", String.class, int.class, double.class);
        for (final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }
    }
}
