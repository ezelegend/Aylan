package app.viteboot.mapper;


import app.viteboot.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ProductMapper {
    @Select("select " +
            "id as id, " +
            "brand as brand, " +
            "color as color, " +
            "name as name, " +
            "code as code, " +
            "engine as engine, " +
            "description as description " +
            "from product ")
    List<ProductEntity> findAllProduct();

    //Buscar Producto por ID//
    @Select("select " +
            "id as id, " +
            "brand as brand, " +
            "color as color, " +
            "name as name, " +
            "code as code, " +
            "engine as engine, " +
            "description as description " +
            "from product " +
            "where id = #{id}")
    ProductEntity findProductById(@Param("id") Long id);
}
