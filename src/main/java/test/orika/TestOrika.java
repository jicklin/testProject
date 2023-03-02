package test.orika;

/**
 * @author mal
 * @date 2023-01-06 9:44
 */
public class TestOrika {

    public static void main(String[] args) {
        LocationDto locationDto = new LocationDto("malin", "EN");
        LocationInfo locationInfo = BeanCopyUtils.copyBean(locationDto, LocationInfo.class);
        System.out.println(locationInfo);

        int start = 1;
        int end = 2;
        do {
            System.out.println(start);
            start++;

        } while (!(start > end));

    }
}
