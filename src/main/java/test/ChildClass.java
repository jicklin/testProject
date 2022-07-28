package test;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/5/20
 */
public class ChildClass extends FatherClass {



    private String childValue;

    public String getChildValue() {
        return childValue;
    }

    public void setChildValue(String childValue) {
        this.childValue = childValue;
    }

    public static void main(String[] args) throws JsonProcessingException {
        List<FatherClass> fatherClasses = new ArrayList<>();

        ChildClass childClass = new ChildClass();

        childClass.setChildValue("1");
        childClass.setFatherValue("2");

        FatherClass fatherClass = new FatherClass();
        fatherClass.setFatherValue("3");
        fatherClasses.add(fatherClass);
        fatherClasses.add(childClass);

        System.out.println(JSON.toJSONString(fatherClasses));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(fatherClasses));
    }
}
