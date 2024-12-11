package org.example.framework;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class FileReader {

    public static List<String> read(int day) {
        Path path = getPath(day);
        return getDataFromFile(path);
    }

    private static List<String> getDataFromFile(Path path) {
        try {
            if (path != null && Files.exists(path)) {
                return List.copyOf(Files.readAllLines(path));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    private static Path getPath(int day) {
        String fileName = String.format("day%02d.txt", day);
        ClassLoader classLoader = FileReader.class.getClassLoader();
        URL url = classLoader.getResource("days/" + fileName);
        try {
            return Path.of(Objects.requireNonNull(url).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
