package bigbigbai._00_assignment._0120;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Problem4 {
    public static void main(String[] args) {
//        int[][] A = {{4,3,1},{6,5,2},{9,7,3}};
//        int[][] B = {{3,7,9},{2,5,6},{1,3,4}};
//        System.out.println(Arrays.deepToString(solution(B)));

    }

    public String solution(String input) {
        String[] lines = input.split("\n");
        int n = Integer.parseInt(lines[0]);
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] tem = lines[i+1].split(" ");
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(tem[j]);
            }
        }

//        int n = A.length;
        int[][] B = new int[n][n];

        int cw = A[0][1] - A[0][0];
        int ccw = A[1][0] - A[0][0];
        if (cw < 0 && ccw < 0) {
            boolean even = n % 2 == 0;
            for (int i = 0; i < n >> 1; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = A[i][j];
                    A[i][j] = A[n - 1 - i][n - 1 - j];
                    A[n - 1 - i][n - 1 - j] = temp;
                }
            }

            if (!even) {
                for (int j = 0; j < n >> 1; j++) {
                    int temp = A[n >> 1][j];
                    A[n >> 1][j] = A[n >> 1][n - 1 - j];
                    A[n >> 1][n - 1 - j] = temp;
                }
            }
        } else if (cw < 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    B[n - 1 - i][j] = A[j][i];
                }
            }
            return printRes(B);
        } else if (ccw < 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    B[i][n - 1 - j] = A[j][i];
                }
            }
            return printRes(B);
        }

        return printRes(A);
    }

    public String printRes(int[][] nums) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                res.append(nums[i][j]).append(" ");
            }
            res.append(nums[i][nums.length - 1]);
            if (i != nums.length - 1) res.append("\n");
        }
        return String.valueOf(res);
    }

    @Test
    public void testSolution() throws IOException {
        // 定义测试用例文件夹路径
        String testFolderPath = "src/bigbigbai/_00_assignment/_0120/testcase/S2";

        // 获取所有 .in 测试文件
        File folder = new File(testFolderPath);
        File[] inputFiles = folder.listFiles((dir, name) -> name.endsWith(".in"));

        if (inputFiles == null || inputFiles.length == 0) {
            throw new IOException("Testcase folder not found or empty!");
        }

        for (File inputFile : inputFiles) {
            // 对应的输出文件路径
            String outputFilePath = inputFile.getPath().replace(".in", ".out");
            File outputFile = new File(outputFilePath);

            if (!outputFile.exists()) {
                throw new IOException("Output file not found for: " + inputFile.getName());
            }

            // 读取输入文件的所有内容
            StringBuilder inputContent = new StringBuilder();
            try (BufferedReader inputReader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = inputReader.readLine()) != null) {
                    inputContent.append(line).append("\n");
                }
            }

            // 调用被测方法
            Problem4 p4 = new Problem4();
            String actualOutput = p4.solution(inputContent.toString().trim());

            // 读取期望输出文件的所有内容
            StringBuilder expectedOutput = new StringBuilder();
            try (BufferedReader outputReader = new BufferedReader(new FileReader(outputFile))) {
                String line;
                while ((line = outputReader.readLine()) != null) {
                    expectedOutput.append(line).append("\n");
                }
            }

            // 比较实际输出和期望输出
            String expectedOutputStr = expectedOutput.toString().trim();

            System.out.println("Testing file: " + inputFile.getName());
            assertEquals("Test failed for: " + inputFile.getName(), expectedOutputStr, actualOutput.trim());
        }
    }
}
