import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(100);
        System.out.println(i1 == i2);

        Stack<Integer> s1 = new Stack<>();
        System.out.println(s1.empty());
    }

    @Test
    public void test() {
        String str = "AB";
        int bi = str.charAt(0) - '0';
        int bj = str.charAt(1) - '0';
        System.out.println(bi);
    }
}