package test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestHashCode {

    public static void main(String[] args) {
        String str="2020年11月17日场馆银行卡收入";
        String str2="2020年11月17日场馆现金收入";
        String str3="2020年11月17日场馆支付宝收入";
        String str4="2020年11月17日场馆微信收入";
        String str5="2020年11月17日场馆电汇收入";
        String str6="2020年11月17日场馆银行卡（联通支付）收入";
        List<String> list = new ArrayList<String>();
        list.add(str);
        list.add(str2);
        list.add(str3);
        List b = list.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());

        System.out.println(str.hashCode()&9999);
        System.out.println(str.hashCode()&9999);
        System.out.println(str2.hashCode()&9999);
        System.out.println(str3.hashCode()&9999);
        System.out.println(str4.hashCode()&9999);
        System.out.println(str5.hashCode()&9999);
        System.out.println(str6.hashCode()&9999);

    }
}
