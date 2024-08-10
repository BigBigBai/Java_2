package bigbigbai._03_dynamic_array;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 10; i < 20; i++) {
            list.add(0, i);
        }

        while (list.size() > 0) {
            System.out.println(list.remove(0));
        }
        
        System.out.println();
    }
}
