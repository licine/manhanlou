package cat.tom.mhl.domain;

/**
 * @author shkstart
 * @create 2023-10-15 10:18
 * Menu 菜单表的javabean
 * id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键自增',
 *  `name` VARCHAR(50) NOT NULL COMMENT '菜名',
 *  type VARCHAR(50) not null COMMENT '菜品类型',
 *  price DOUBLE NOT NULL DEFAULT(0) COMMENT '价格'
 */
public class Menu {
    private Integer id;
    private String name;
    private String type;
    private Double price;

    public Menu() {
    }

    public Menu(Integer id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t\t\t" + name + "\t\t" + type + "\t\t\t" + price + "\t\t";
    }
}
