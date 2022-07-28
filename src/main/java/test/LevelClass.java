package test;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/6/17
 */
public class LevelClass {

    private String class1;

    private String class2;

    private String class3;

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getClass2() {
        return class2;
    }

    public void setClass2(String class2) {
        this.class2 = class2;
    }

    public String getClass3() {
        return class3;
    }

    public synchronized void setClass3(String class3) {
        this.class3 = class3;
    }

    public static void main(String[] args) {

    }

}

