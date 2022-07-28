package test.single;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/6/20
 */
public class StaticSingletonTest {

    public static class SingletonHolder {
        private static StaticSingletonTest instance = new StaticSingletonTest();
    }

    private StaticSingletonTest() {

    }

    public static StaticSingletonTest getInstance() {
        return SingletonHolder.instance;
    }

}
