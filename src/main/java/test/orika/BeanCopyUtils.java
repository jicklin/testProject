package test.orika;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author mal
 * @date 2023-01-06 9:25
 */
public class BeanCopyUtils {

    public static final MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();

    public static final MapperFacade MAPPER_FACADE = MAPPER_FACTORY.getMapperFacade();

    public static <T> T copyBean(Object source, T target) {
        if (source != null) {
            MAPPER_FACADE.map(source, target);
        }
        return target;
    }


    public static <T> T copyBean(Object source, Class<T> targetClass) {
        if (source != null) {
            return MAPPER_FACADE.map(source, targetClass);
        }
        return null;
    }
}
