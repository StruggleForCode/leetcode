package org.example;

/**
 * ClassName: SingleInstance
 * Package: org.example
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/8/24 17:10
 * @Version 1.0
 */
public class SingleInstance {

    public static volatile SingleInstance instance = null;

    public SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }


}
