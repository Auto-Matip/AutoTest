package unit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SimpleTest {
    @Tag("Smoke")
    @Test
    void test() {
        assert Practic.isEven(2) == true;
    }
}