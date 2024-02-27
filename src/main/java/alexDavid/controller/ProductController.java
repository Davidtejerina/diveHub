package alexDavid.controller;


import alexDavid.dtos.ProductDTO.ProductRequestDto;
import alexDavid.dtos.ProductDTO.ProductResponseDto;
import alexDavid.models.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import alexDavid.mappers.ProductMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import alexDavid.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/divehub/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;


    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(
    ) {
        return ResponseEntity.ok(productMapper.toResponse(productService.findAll()));
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(productMapper.toResponse(productService.findById(id)));
    }

    @GetMapping("/tag/{tag}")
    public ResponseEntity<List<ProductResponseDto>> getProductByTag(
            @PathVariable String tag
    ) {
        return ResponseEntity.ok(productMapper.toResponse(productService.findProductsByTagIgnoreCase(tag)));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ProductResponseDto>> getProductContainsInName(
            @PathVariable String name
    ) {
        return ResponseEntity.ok(productMapper.toResponse(productService.findByNameContainsIgnoreCase(name)));
    }

    @GetMapping("/price/descending")
    public ResponseEntity<List<ProductResponseDto>> getProductOrderByPrice(
    ) {
        return ResponseEntity.ok(productMapper.toResponse(productService.findAllByOrderByFinal_priceDesc()));
    }

    @GetMapping("/price/ascending")
    public ResponseEntity<List<ProductResponseDto>> getProductOrderByPriceAsc(){
        return ResponseEntity.ok(productMapper.toResponse(productService.findAllByOrderByFinal_priceAsc()));
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponseDto> postProduct(
            @RequestBody ProductRequestDto productRequestDto
    ) {
        Product productSaved = productService.save(productMapper.toModel(productRequestDto));
        return ResponseEntity.created(null).body(productMapper.toResponse(productSaved));
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductResponseDto> putProduct(
            @PathVariable Long id,
            @RequestBody ProductRequestDto productRequestDto
    ) {
        Product productUpdated = productService.update(id, productMapper.toModel(productRequestDto));
        return ResponseEntity.ok(productMapper.toResponse(productUpdated));
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteById(
            @PathVariable Long id
    ) {
        productService.deleteProductById(id);
    }
}


