package test;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest {

    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Integer>();
        list.add(null);
    }
}
