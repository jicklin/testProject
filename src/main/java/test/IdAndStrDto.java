package test;

/**
 * @author mal
 * @date 2021-06-30 16:12
 */
public class IdAndStrDto {

    private String name;

    private Integer id;

    public IdAndStrDto(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
