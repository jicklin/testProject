package test;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/**
 * @author mal
 * @date 2022-04-14 17:56
 */
public class TestUrl {
    public static void main(String[] args) throws URISyntaxException {
        String url = "http://www.baidu.com?query=马林";
        String encode = URLEncoder.encode("query=a b");
        System.out.println("http://www.baidu.com?"+encode);
        URI uri = new URI(url);
        System.out.println(uri.toASCIIString());

        System.out.println(String.format("hahah%snnn", null));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(60*60*24*1000);

    }
}
