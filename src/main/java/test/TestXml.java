package test;

import com.thoughtworks.xstream.XStream;

public class TestXml {

    public static void main(String[] args) {
        XStream xStream = new XStream();
        Student student = new Student();
        student.setAge(1);
        student.setName("哈哈");
        xStream.alias("student", Student.class);

        String s = xStream.toXML(student);
        System.out.println(s);
    }


    public static class Student{

        private String name;

        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
