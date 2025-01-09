package bigbigbai._00_assignment._02_stack.lc2;

public class _1700_NumberOfStudentsUnableToEatLunch {
    // (牛B)
    // 模拟
    public int countStudents(int[] students, int[] sandwiches) {
        int index0 = 0, index1 = 0;
        for (int num : students) {
            if (num == 0) index0++;
            else index1++;
        }

        for (int num : sandwiches) {
            if (num == 0) index0--;
            else index1--;

            if (index0 < 0 || index1 < 0) break;
        }

        return index0 < 0 ? index1 : index0;
    }
}
