package unit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.MethodSource;


import java.util.Random;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Smoke1")
public class PracticTest {




    @BeforeEach
    void begin() {
        System.out.println("==============================" + "\nTest method start");
    }


    @AfterEach
    void end() {
        System.out.println("Test method end" + "\n==============================");
    }


    @Test
    void testisEven() {
        Random random = new Random();
        int s = random.nextInt(1, 100);
        System.out.println(s);
        System.out.println(Practic.isEven(s));
        //assertTrue(unit.unit.Practic.isEven(s) == true, "Нечетное");
    }

    @RepeatedTest(20)
    public void testcheckAccess() {
        Random random = new Random();
        int t = random.nextInt(0, 99);
        System.out.println(t);
        System.out.println(Practic.checkAccess(t));

    }



    @ParameterizedTest
    @MethodSource("generateRandomArray")
    void getGrade(int score) {
        System.out.println(score);
        System.out.println(Practic.getGrade(score));
    }




    public static int[] generateRandomArray() {

        Random random = new Random();
        int z = random.nextInt(3, 10);
        int[] array = new int[z];
        for (int i = 0; i < z; i++) {
            array[i] = random.nextInt(0,100);
        }

        return array;
    }


}