package unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Practic {



    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isPositive(int n) {
        if (n >= 0) return true;
        return false;
    }

    public static String checkAccess(int age) {
        if (age > 18) {
            return "Allowed";
        }
        return "Denied";
    }

    public static String getGrade(int score) {
        if (score >= 0 && score <= 20) {
            return "E";
        } else if (score >= 21 && score <= 40) {
            return "D";
        } else if (score >= 41 && score <= 60) {
            return "C";
        } else if (score >= 61 && score <= 80) {
            return "B";
        } else if (score >= 81 && score <= 100) {
            return "A";
        }
        return "NA";
    }


    public static String blastOff(int n) {

        String m = "Поехали!";
        for (int i = 1; i <= n; i++) {
            m = i + " " + m;
        }
        return m;
    }

    public static boolean hasBug(String[] messages) {
        boolean a = false;
        for (String message : messages) {
            if (message == "Bug") {
                a = true;
                return a;
            }
        }
        return a;
    }


    public static int sumToN(int n) {

        int m = 0;
        for (int i = 0; i <= n; i++) {
            m = i + m;
        }
        return m;
    }


    public static String getEvenInRange(int start, int end) {

        String m = "";
        String result;
        for (int i = end; i >= start; i--) {
            if (i % 2 == 0) {
                m = i + " " + m;

            }

        }
        if (m.length() > 0) {
            result = m.substring(0, m.length() - 1);
            return result;
        }
        return m;
    }


    public static int findMax(int[] arr) {

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


    public static String[] reverse(String[] arr) {
        String[] reversed = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public static int calcAverage(List<Integer> list) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < list.size(); i++) {
            a = list.get(i) + a;
        }
        b = a / list.size();
        return b;
    }

    public static List<String> removeSpecificName(List <String> list, String nameToRemove) {
        List <String> removed = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), nameToRemove)) {
                removed.remove(i);
                return removed;

            }
        }
        return removed;
    }


}

