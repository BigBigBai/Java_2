package bigbigbai._00_assignment._0120;

import java.util.Arrays;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Problem3 {
    public static void main(String[] args) {
//        int[] arr = {16,0,10,4,15};
//        System.out.println(solution(arr));
    }

    public double solution(String input) {
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i+1]);

        if (arr.length <= 2) return Double.MAX_VALUE;

        double res = Double.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 2; i < arr.length; i++) {
            double totalSize = (double) (arr[i] - arr[i - 2]) / 2;
            totalSize = Math.round(totalSize * 10) / 10.0;

            res = Math.min(res, totalSize);
        }

        return res;
    }

    @Test
    public void testSolution() throws IOException {
        // 定义测试用例文件夹路径
        String testFolderPath = "src/bigbigbai/_00_assignment/_0120/testcase/S1";

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
            Problem3 p3 = new Problem3();
            String actualOutput = String.format("%.1f", p3.solution(inputContent.toString().trim()));

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
