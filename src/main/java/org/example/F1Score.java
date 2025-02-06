package org.example;

/**
 * ClassName: F1Score
 * Package: org.example
 * Description:
 *
 * @Author LeeHao
 * @Create 2025/1/18 21:12
 * @Version 1.0
 */
public class F1Score {
    public static void main(String[] args) {
        float precision = 0.999674F;
        float recall = 0.999965F;
        float f1Score = 2 * precision * recall / (precision + recall);
        System.out.println(f1Score);

    }
}
