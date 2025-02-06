package org.example;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * ClassName: LogFileSplitter
 * Package: org.example
 * Description:
 *
 * @Author LeeHao
 * @Create 2025/1/17 19:16
 * @Version 1.0
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LogFileSplitter {
    public static void main(String[] args) {
        // 源文件路径
        String inputFile = "/Users/leehao/code/PyCharm/logparser/data/loghub_2k/OpenStack_Total/OpenStack_100%.log";

        // 输出文件名
        String[] outputFiles = {
                "/Users/leehao/code/PyCharm/logparser/data/loghub_2k/OpenStack_Total/OpenStack_25%.log",
                "/Users/leehao/code/PyCharm/logparser/data/loghub_2k/OpenStack_Total/OpenStack_50%.log",
                "/Users/leehao/code/PyCharm/logparser/data/loghub_2k/OpenStack_Total/OpenStack_75%.log"
        };

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            // 统计文件总行数
            int totalLines = countTotalLines(inputFile);

            // 计算切割行数
            int[] splitPoints = {
                    totalLines / 4,       // 25%
                    totalLines / 2,       // 50%
                    (totalLines * 3) / 4  // 75%
            };

            // 用于存储当前读取行数
            int currentLineCount = 0;

            // 用于临时存储行数据
            List<String> allLines = new ArrayList<>();

            // 按行读取文件
            String line;
            while ((line = reader.readLine()) != null) {
                allLines.add(line);
                currentLineCount++;

                // 检查是否需要写入文件
                for (int i = 0; i < splitPoints.length; i++) {
                    if (currentLineCount == splitPoints[i]) {
                        writeToFile(outputFiles[i], allLines.subList(0, splitPoints[i]));
                        System.out.println("写入文件: " + outputFiles[i]);
                    }
                }

                // 如果已经读满 75%，提前退出
                if (currentLineCount == splitPoints[splitPoints.length - 1]) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 统计文件总行数
    private static int countTotalLines(String inputFile) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            int totalLines = 0;
            while (reader.readLine() != null) {
                totalLines++;
            }
            return totalLines;
        }
    }

    // 将指定的行写入输出文件
    private static void writeToFile(String outputFile, List<String> lines) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}