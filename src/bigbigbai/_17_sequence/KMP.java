package bigbigbai._17_sequence;

public class KMP {
    public static void main(String[] args) {
        String text = "Hello World!";
        String pattern = "or";
        System.out.println(indexOf(text, pattern));
    }

    public static int indexOf(String text, String pattern) {
        int pi = 0;
        int ti = 0;
        int patLen = pattern.length();
        int textLen = text.length();
        char[] patChar = pattern.toCharArray();
        char[] textChar = text.toCharArray();
        int[] next = next(pattern);

        while (pi < patLen && ti <= textLen - patLen) {
            if (pi < 0 ||  patChar[pi] == textChar[ti]) { // (NB)
                pi++;
                ti++;
            } else {
//                ti -= pi - 1;
//                pi = 0;
                pi = next[pi];
            }
        }

        return pi == patLen ? ti - pi : -1;
    }

    public static int[] next(String pattern) {
        int[] next = new int[pattern.length()];
        char[] charArray = pattern.toCharArray();
        int i = 0;
        int n = next[i] = -1;
        while (i < charArray.length - 1) {
            // 1. if pattern[i] == pattern[n]
            // then next[i+1] = n + 1
            if (n < 0 || charArray[i] == charArray[n]) {
                next[++i] = ++n;
            } else {
                // 2. if pattern[i] != pattern[n], next[n] = k
                // if pattern[i] == pattern[k]
                // then next[i + 1] = k + 1
                // if pattern[i] != pattern[k]
                // substitute k for n and repeat 2
                n = next[n]; // (NB) n is like k
            }
        }

        return next;
    }
}
