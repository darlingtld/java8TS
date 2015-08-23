package lambda;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by tangl9 on 2015-08-14.
 */
public class Lambda3 {

    public static void main(String[] args) {
        File dir = new File("/src");

        String[] filelist = dir.list(new FilenameFilter() {
            public boolean accept(File f, String s) {
                return s.endsWith(".java");
            }
        });
//        With lambda expressions, this can be simplified:
        File dir1 = new File("/src");
        String[] filelist1 = dir1.list((f, s) -> {
            return s.endsWith(".java");
        });
    }
}
