package org.interview.history;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * ClassName: Main3
 * Package: org.interview.current
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/9/13 22:40
 * @Version 1.0
 */
public class MaiJiMain01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String xInput = scanner.nextLine();
        String yInput = scanner.nextLine();
        int[] xIn = parseInput(xInput);
        int[] yIn = parseInput(yInput);

        int result = countValidLocation(yIn, xIn);
        System.out.println(result);
    }

    private static int[] parseInput(String input) {
        String[] parts = input.split(",");
        int[] res = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            res[i] = Integer.parseInt(parts[i]);
        }
        return res;
    }

    private static int countValidLocation(int[] xIn, int[] yIn) {
        int n = xIn.length;
        Set<String> houses = new HashSet<>();

        for (int i = 0; i < n; i++) {
            houses.add(xIn[i] + "," + yIn[i]);
        }
        Set<String> candidates = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int x = xIn[i];
            int y = yIn[i];
            for (int j = 0; j < n; j++) {
                int x1 = xIn[j];
                int y1 = yIn[j];
                if (x != x1) {
                    candidates.add(x1 + "," + y);
                }
                if (y != y1) {
                    candidates.add(x + "," + y1);
                }
            }
        }
        int validCount = 0;
        for (String candidate : candidates) {
            String[] parts = candidate.split(",");
            int partX = Integer.parseInt(parts[0]);
            int partY = Integer.parseInt(parts[1]);

            boolean hasEast = false;
            boolean hasNorth = false;
            boolean hasSouth = false;
            boolean hasWest = false;

            for (int i = 0; i < n; i++) {
                int x = xIn[i];
                int y = yIn[i];
                if (x > partX && y == partY) hasEast = true;
                if (x < partX && y == partY) hasWest = true;
                if (x == partX && y > partY) hasNorth = true;
                if (x == partX && y < partY) hasSouth = true;
            }
            if (hasEast && hasNorth && hasSouth && hasWest) {
                validCount++;
            }
        }
        return validCount;
    }
}
