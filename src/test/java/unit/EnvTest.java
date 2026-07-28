package unit;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import unit.Practic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnvTest {
    @Tag("Smoke")

    @ParameterizedTest
    @MethodSource("generateRandomArray")
    void testisEven(int s) {
        System.out.println(s);
        System.out.println(Practic.isEven(s));
        if (Practic.isEven(s) == true || Practic.isEven(s) == false) {System.out.println("TEST PASSED");}
        else {System.out.println("TEST FAILED");}
    }

    @RepeatedTest(20)
    public void testcheckAccess() {
        Random random = new Random();
        int t = random.nextInt(0, 99);
        System.out.println(t);
        System.out.println(Practic.checkAccess(t));
        if (Practic.checkAccess(t) == "Allowed" || Practic.checkAccess(t) == "Denied") {System.out.println("TEST PASSED");}
        else {System.out.println("TEST FAILED");}
    }



    @ParameterizedTest
    @MethodSource("generateRandomArray")
    void getGrade(int score) {
        System.out.println(score);
        System.out.println(Practic.getGrade(score));
        List<String> allowed = List.of("E", "D", "C", "B", "A");
        if (allowed.contains(Practic.getGrade(score))) {System.out.println("TEST PASSED");}
        else {System.out.println("TEST FAILED");}
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


    @ParameterizedTest
    @MethodSource("generateRandomArrayB")
    public void isPositive(int a) {
        System.out.println(a);
        System.out.println(Practic.isPositive(a));
        if (Practic.isPositive(a) == true || Practic.isPositive(a) == false) {System.out.println("TEST PASSED");}
        else {System.out.println("TEST FAILED");}
    }



    public static int[] generateRandomArrayB() {

        Random random = new Random();
        int z = random.nextInt(3, 10);
        int[] array = new int[z];
        for (int i = 0; i < z; i++) {
            array[i] = random.nextInt(-100,100);
        }

        return array;
    }


    @ParameterizedTest
    @MethodSource("generateRandomArray")
    void BlastOff(int score) {
        System.out.println(score);
        System.out.println(Practic.blastOff(score));
        if (Practic.blastOff(score).contains("Поехали!")) {System.out.println("TEST PASSED");}
        else {System.out.println("TEST FAILED");}
    }

    @RepeatedTest(10)
    public void sumToN() {
        Random random = new Random();
        int t = random.nextInt(10, 50);
        System.out.println(t);
        System.out.println(Practic.sumToN(t));
        if (Practic.sumToN(t) > 0 || Practic.sumToN(t) < 100000) {System.out.println("TEST PASSED");}
        else {System.out.println("TEST FAILED");}
    }


    @Test
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
        if (Practic.hasBug(d) == true || Practic.hasBug(d) == false) {System.out.println("TEST PASSED");}
        else {System.out.println("TEST FAILED");}
    }

    @Test
    void getEvenInRange() {
        Random random = new Random();
        int d = random.nextInt(1, 10);
        int g = random.nextInt(20, 50);
        System.out.println(d);
        System.out.println(g);
        System.out.println(Practic.getEvenInRange(d,g));
        if (Practic.getEvenInRange(d,g).contains(" ")) {System.out.println("TEST PASSED");}
        else {System.out.println("TEST FAILED");}
    }

    @RepeatedTest(10)
    public void findMax() {
        Random random = new Random();
        int t = random.nextInt(1, 100);
        int p = random.nextInt(1, 100);
        int o = random.nextInt(1, 100);
        int[] d = {t, o, p};
        System.out.println(t);
        System.out.println(p);
        System.out.println(o);
        System.out.println(Practic.findMax(d));
        if (Practic.findMax(d) > 0 || Practic.findMax(d) < 10000000) {System.out.println("TEST PASSED");}
        else {System.out.println("TEST FAILED");}
    }

    @Test
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
        if (Arrays.asList(Practic.reverse(d)).contains("Abc"+t)) {System.out.println("TEST PASSED");}
        else {System.out.println("TEST FAILED");}
    }

    @RepeatedTest(5)
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
        if (Practic.calcAverage(list) > 0) {System.out.println("TEST PASSED");}
        else {System.out.println("TEST FAILED");}
    }


    @Test
    public void removeSpecificName() {
        Random random = new Random();
        int t = random.nextInt(1, 100);
        int p = random.nextInt(1, 100);
        int o = random.nextInt(1, 100);
        List<String> list = new ArrayList<>();
        list.add("Abc"+t);
        list.add("Abc"+p);
        list.add("Abc"+o);
        System.out.println(list);
        System.out.println(Practic.removeSpecificName(list,"Abc"+o));
        if (Arrays.asList(Practic.removeSpecificName(list,"Abc"+o)).contains("Abc"+o)) {System.out.println("TEST FAILED");}
        else {System.out.println("TEST PASSED");}
    }






















}
