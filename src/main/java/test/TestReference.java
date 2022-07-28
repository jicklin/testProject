package test;

/**
 * @author mal
 * @date 2022-01-05 14:08
 */
public class TestReference {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b.setCity("新沂");
        a.setB(b);
        //b = new B();
        b.setCity("南京");
        System.out.println(a);

    }


    static class A{

        private B b;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "A{" +
                    "b=" + b +
                    '}';
        }
    }

    static class B{
        private String city;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "B{" +
                    "city='" + city + '\'' +
                    '}';
        }
    }


}
