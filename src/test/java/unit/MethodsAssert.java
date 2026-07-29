package unit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Tag("Assert")
public class MethodsAssert {



    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, 11, 13, 15, 17,19})
    public void testisEven(int s) {
        System.out.println(s);
        System.out.println(Practic.isEven(s));
        Assertions.assertThat(Practic.isEven(s))
                .as("Should be false")
                .isEqualTo(false);
    }

    @RepeatedTest(10)
    public void testcheckAccess() {
        Random random = new Random();
        int t = random.nextInt(19, 99);
        System.out.println(t);
        System.out.println(Practic.checkAccess(t));
        Assertions.assertThat(Practic.checkAccess(t))
                .as("Should be Allowed")
                .isEqualTo("Allowed");
    }



    @RepeatedTest(10)
    void getGrade() {
        Random random = new Random();
        int score = random.nextInt(0, 20);
        System.out.println(score);
        System.out.println(Practic.getGrade(score));
        Assertions.assertThat(Practic.getGrade(score))
                .as("Should be E grade")
                .isEqualTo("E");
    }

    @RepeatedTest(10)
    public void isPositive() {
        Random random = new Random();
        int a = random.nextInt(-100, -1);
        System.out.println(a);
        System.out.println(Practic.isPositive(a));
        Assertions.assertThat(Practic.isPositive(a))
                .as("Should be false")
                .isEqualTo(false);
    }

    @RepeatedTest(10)
    void BlastOff() {
        Random random = new Random();
        int score = random.nextInt(1, 10);
        System.out.println(score);
        System.out.println(Practic.blastOff(score));
        Assertions.assertThat(Practic.blastOff(score))
                .as("Should starts with score")
                .startsWith("" + score);
    }

    @RepeatedTest(10)
    public void sumToN() {
        Random random = new Random();
        int t = random.nextInt(10, 50);
        System.out.println(t);
        System.out.println(Practic.sumToN(t));
        Assertions.assertThat(Practic.sumToN(t))
                .as("Should be greater than t")
                .isGreaterThan(t);
    }


    @RepeatedTest(10)
    void hasBug() {
        Random random = new Random();
        int s = random.nextInt(1, 5);
        String[] d = new String[5];
        d[0] = "Abc"+s;
        d[1] = "Cba"+s;
        d[2] = "Bug";
        d[3] = "Bud"+s;
        d[4] = "Ayo"+s;
        System.out.println(Arrays.toString(d));
        System.out.println(Practic.hasBug(d));
        Assertions.assertThat(Practic.hasBug(d))
                .as("Should be true")
                .isEqualTo(true);
    }

    @RepeatedTest(10)
    void getEvenInRange() {
        Random random = new Random();
        int d = 1;
        int g = random.nextInt(10, 20);
        System.out.println(d);
        System.out.println(g);
        System.out.println(Practic.getEvenInRange(d,g));
        Assertions.assertThat(Practic.getEvenInRange(d,g))
                .as("Should contains 2 4 6 8")
                .contains("2 4 6 8");
    }

    @RepeatedTest(10)
    public void findMax() {
        Random random = new Random();
        int t = random.nextInt(1, 10);
        int p = random.nextInt(21, 100);
        int o = random.nextInt(10, 20);
        int[] d = {t, o, p};
        System.out.println(t);
        System.out.println(p);
        System.out.println(o);
        System.out.println(Practic.findMax(d));
        Assertions.assertThat(Practic.findMax(d))
                .as("Should be p")
                .isEqualTo(p);
    }

    @RepeatedTest(10)
    public void reverse() {
        Random random = new Random();
        int t = random.nextInt(1, 100);
        int p = random.nextInt(1, 100);
        int o = random.nextInt(1, 100);
        String[] d = new String[5];
        d[0] = "Abc"+t;
        d[1] = "Cba"+p;
        d[2] = "Bug"+o;
        d[3] = "Bud"+t;
        d[4] = "Ayo"+p;
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(Practic.reverse(d)));
        Assertions.assertThat(Practic.reverse(d))
                .as("Should starts with Ayo")
                .startsWith("Ayo"+p);
    }

    @RepeatedTest(10)
    void calcAverage() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int size = random.nextInt(5, 10);
        int min = random.nextInt(1, 10);
        int max = random.nextInt(11, 100);
        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(min, max);
            list.add(randomNumber);
        }
        System.out.println(list);
        System.out.println(Practic.calcAverage(list));
        Assertions.assertThat(Practic.calcAverage(list))
                .as("Should be less than max")
                .isLessThan(max);
    }


    @RepeatedTest(10)
    public void removeSpecificName() {
        Random random = new Random();
        int t = random.nextInt(1, 100);
        int p = random.nextInt(1, 100);
        int o = random.nextInt(1, 100);
        List<String> list = new ArrayList<>();
        list.add("Asc"+t);
        list.add("Arm"+p);
        list.add("Abc"+o);
        System.out.println(list);
        System.out.println(Practic.removeSpecificName(list,"Abc"+o));
        Assertions.assertThat(Practic.removeSpecificName(list,"Abc"+o))
                .as("Should not contains Abc+o")
                .doesNotContain("Abc"+o);
    }






















}

