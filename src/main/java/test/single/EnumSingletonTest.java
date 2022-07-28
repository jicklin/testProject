package test.single;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/6/20
 */
public enum  EnumSingletonTest {
    INSTANCHE;


    public void doSomething() {
        System.out.println("hahah");

    }


    public static void main(String[] args) {
        System.out.println(EnumSingletonTest.INSTANCHE);

        EnumSingletonTest.INSTANCHE.doSomething();

    }
}
