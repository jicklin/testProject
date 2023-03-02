package test.lombok;

import lombok.Builder;
import lombok.Data;

/**
 * @author mal
 * @date 2022-10-14 11:21
 */
@Data
@Builder
public class TestBuilder {

    private String name;

    private Integer age;


}
