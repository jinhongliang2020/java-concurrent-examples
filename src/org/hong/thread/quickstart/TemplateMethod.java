package org.hong.thread.quickstart;

/**
 * @author hong
 * @version v1.1
 * @ClassName: TemplateMethod
 * @Description: (设计模式之 模板方法)
 * @date 2017/11/15
 */
public class TemplateMethod {


    public final void print(String msg) {
        System.out.println("print start...");
        wrapPrint(msg);
        System.out.println("print end...");
    }

    /**
     * 定义为同一个包内能被重写.
     * @param msg
     */
    protected void wrapPrint(String msg) {
        // ... 可有可无默认实现
        System.out.println("hello TemplateMethod");
    }


    public static void main(String[] args) {

        TemplateMethod templateMethod = new TemplateMethod() {
            @Override
            public void wrapPrint(String msg) {
                System.out.println("hello "+msg);
            }
        };

        templateMethod.print("world");


        TemplateMethod templateMethod2 =new TemplateMethod();
        templateMethod2.print("tttt");

    }
}
