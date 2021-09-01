package com.myhomeDB.controllers;

import com.myhome.ProductDto;
import com.myhomeDB.exeptions.ResourceNotFoundException;
import com.myhomeDB.models.Product;
import com.myhomeDB.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/{id}")
    public ProductDto findById(@PathVariable Long id) {
        Product p = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return new ProductDto(p.getId(), p.getTitle(), p.getPrice());
    }

    @GetMapping
    public List<ProductDto> findAll(
    ) {
        //return productService.findPage(pageIndex - 1, 5).map(ProductDto::new);
        return productService.findAll().stream()
                .map(product -> new ProductDto(product.getId(), product.getTitle(), product.getPrice()))
                .collect(Collectors.toList());
    }


    @PostMapping
    public ProductDto createNewProduct(@RequestBody ProductDto newProductDto) {
        Product product = new Product();
        product.setPrice(newProductDto.getPrice());
        product.setTitle(newProductDto.getTitle());
        productService.save(product);
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
