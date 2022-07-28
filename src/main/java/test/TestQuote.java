package test;

/**
 * @author mal
 * @date 2021-10-19 17:35
 */
public class TestQuote {

    public static void main(String[] args) {
        Aa a1 = new Aa();
        Aa a2 = a1;
        a1 = new Aa();
        System.out.println(a1);
        System.out.println(a2);

    }

    static class Aa{

    }
}
