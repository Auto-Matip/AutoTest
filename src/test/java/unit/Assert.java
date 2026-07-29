package unit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Tag("Asserti")
public class Assert {
    @Test
    public void divisionByFive() {
        Random random = new Random();
        int m = random.nextInt(1, 4);
        System.out.println(m);
        System.out.println(Assertion.divisionByFive(m));
        Assertions.assertThat(Assertion.divisionByFive(m))
                .as("Should be false")
                .isEqualTo(false);
    }

    @Test
    public void increase() {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        Random random = new Random();
        int size = random.nextInt(5, 10);
        int max = random.nextInt(2, 100);
        int b = random.nextInt(1, 10);
        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(1, max);
            list.add(randomNumber);
            list1.add(randomNumber);
        }
        System.out.println(list);
        System.out.println(b);
        System.out.println(Assertion.increase(list,b));
        Assertions.assertThat(Assertion.increase(list,b))
                .as("Must be different")
                .isNotSameAs(list1);

    }

    @Test
    public void duplicate() {
        Random random = new Random();
        int b = random.nextInt(1, 10);
        System.out.println(Assertion.duplicate("Attempt № " + b));
        Assertions.assertThat(Assertion.duplicate("Attempt № " + b))
                .as("Must be same")
                .isEqualTo("Attempt № " + b + " Attempt № " + b);
    }

    @Test
    public void testWrongCheckAccess() {
        Random random = new Random();
        int t = random.nextInt(0, 18);
        System.out.println(t);
        System.out.println(Assertion.WrongCheckAccess(t));
        Assertions.assertThat(Assertion.WrongCheckAccess(t))
                .as("Should be Denied")
                .isEqualTo("Denied");
    }


}