package test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mal
 * @date 2021-07-16 10:48
 */
public class TestFreemarker {

    public static void main(String[] args) {
        Map<String, Object> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("map", ImmutableMap.of("游泳培训", "小红", "游泳卡券", "小黑"));
        objectObjectHashMap.put("tradeType", "培训");
        objectObjectHashMap.put("projectName", "游泳");
        objectObjectHashMap.put("tradeTypeProjectName", "游泳培训");

        String data = "这是几${map[tradeTypeProjectName]}";
        String templateData = getTemplateData(data, objectObjectHashMap);
        System.out.println(templateData);

    }

    /**
     * freemarker解析模板
     *
     * @param data
     * @param object
     * @return
     */
    public static String getTemplateData(String data, Map<String, Object> object) {
        StringTemplateLoader templateLoader = new StringTemplateLoader();
        templateLoader.putTemplate("myTemplate", data);

        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setTemplateLoader(templateLoader);

        Template template;
        String content;
        try {
            template = configuration.getTemplate("myTemplate", "utf-8");
            StringWriter swriter = new StringWriter();
            template.process(object, swriter);
            content = swriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("短信模板解析失败!");
        }

        return content;
    }

}
