package streams;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by darlingtld on 2015/8/23 0023.
 */
public class FileStream {

    public static void main(String[] args) throws IOException {
        String filename = "src/main/resources/test.txt";
        File file = new File(filename);
        final Path path = file.toPath();
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        }
    }
}
