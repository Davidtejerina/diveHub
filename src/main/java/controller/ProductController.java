package controller;


import dtos.ProductDTO.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mappers.ProductMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/DiveHub/products")
@RequiredArgsConstructor
@Slf4j

public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;


    @GetMapping("")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){

        log.info("getAllProducts");

        return ResponseEntity.ok(
                productMapper.toResponse(productService.findAll())
        );
    }
}
