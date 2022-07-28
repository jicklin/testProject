package test;

import java.util.EnumMap;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/5/24
 */
public class EnumTest {


    enum Animal{
        DOG(1,"小白"), CAT(2, "小黑");

        private int id;
        private String name;

        Animal(int id, String name) {
            this.id = id;
            this.name = name;

        }
    }


    public static void main(String[] args) {
        System.out.println(Animal.valueOf("DOG"));

        EnumMap<Animal, String> enumMap = new EnumMap<Animal, String>(Animal.class);
        enumMap.put(Animal.DOG, "haha");

        System.out.println(Animal.DOG.toString());
        System.out.println(Animal.DOG.ordinal()
        );
        System.out.println(Animal.CAT.ordinal());

        System.out.println(CarTree.BuickEnum.Regal.getBrandModel());

        System.out.println(State.valueOf("SUCCESS"));


    }

    enum State{
        SUCCESS("1"),FAIL("0");

        String state;
        State(String state) {
            this.state = state;

        }
    }
}
