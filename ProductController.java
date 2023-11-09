package app.viteboot.controller;

import app.viteboot.dto.ResponseDTO;
import app.viteboot.entity.ProductEntity;
import app.viteboot.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
@Log4j2
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    ResponseEntity<ResponseDTO> getAllProduct(){
        ResponseDTO respro = ResponseDTO.builder().build();

        List<ProductEntity> productList = productService.findAllProduct();

        try{
            respro = ResponseDTO
                    .builder()
                    .status(Objects.nonNull(productList))
                    .message(Objects.nonNull(productList) ? "Producto Obtenido con éxito" : "Ha ocurrido un error al obtener los productos")
                    .data(productList)
                    .build();
            log.info("Productos obtenidos con éxito");
            return new ResponseEntity<ResponseDTO>(respro, HttpStatus.OK);
        }catch (Exception ex) {
            log.error( "Error, no se encontraron los productos");
            return new ResponseEntity<ResponseDTO>(respro, HttpStatus.BAD_REQUEST);
        }
    }


}
