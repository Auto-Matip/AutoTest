package rest.endpoints;

import java.util.HashMap;
import java.util.Map;

public class ParallelContext {
    private static final ThreadLocal<String> testData = new ThreadLocal<>();

    public static void set(String value) {
        testData.set(value);
    }

    public static String get() {
        return testData.get();
    }

    public static void clear() {
        testData.remove(); // Важно очищать во избежание утечек памяти
    }
}