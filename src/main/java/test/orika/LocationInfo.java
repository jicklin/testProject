package test.orika;

import lombok.Data;
import lombok.ToString;

/**
 * @author mal
 * @date 2023-01-06 9:43
 */
@Data
@ToString
public class LocationInfo {

    private String name;


    private NationEnum nation;
}
