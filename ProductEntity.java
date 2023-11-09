package app.viteboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
    private Integer id;
    private String brand;
    private String color;
    private String name;
    private String code;
    private String engine;
    private String description;

}
