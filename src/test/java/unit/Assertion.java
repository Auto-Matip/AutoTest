package unit;

import java.util.ArrayList;
import java.util.List;

public class Assertion {

    public static boolean divisionByFive(int n) {
        if (n % 5 == 0) return true;
        return false;
    }

public static List<Integer> increase(List<Integer> list, int value) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            list.set(i, list.get(i) + value);
        }
return list;
}

    public static String duplicate(String n) {

        String m = n + " " + n;

        return m;
    }

    public static String WrongCheckAccess(int age) {
        if (age < 18) {
            return "Allowed";
        }
        return "Denied";
    }
}
