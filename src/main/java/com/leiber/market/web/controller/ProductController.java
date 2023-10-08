package com.leiber.market.web.controller;

import com.leiber.market.domain.Product;
import com.leiber.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200, message = "0K")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with an id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "0K"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<Product> getProduct(
            @ApiParam(value = "The id of the product",
                    required = true, example = "4")
            @PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    @ApiOperation("Search a product with an category id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "That category does not exist")
    })
    public ResponseEntity<List<Product>> getByCategory(@ApiParam(value = "The category id the product", required = true,
            example = "5") @PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId).filter(Predicate.not(List::isEmpty))
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/products-scarse/{quantity}")
    @ApiOperation("Search for all scarce products with an quantity")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "quantity not found")
    })
    public ResponseEntity<List<Product>> getScarseProducts(@ApiParam(value = "The quantity", required = true, example = "100") @PathVariable("quantity") int quantity) {
        return productService.getScarseProducts(quantity).filter(Predicate.not(List::isEmpty))
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/products-expensive/{price}")
    @ApiOperation("Search for all expensive products with an price")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "price not found")
    })
    public ResponseEntity<List<Product>> getAllProductsExpensive(@ApiParam(value = "The price", required = true, example = "200.00") @PathVariable("price") BigDecimal price) {
        return productService.getProductExpensive(price).filter(Predicate.not(List::isEmpty))
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/products-unavailable/")
    @ApiOperation("Search for all unavailable products")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "All products are available")
    })
    public ResponseEntity<List<Product>> getAllProductNotAvailable() {
        return productService.getProductAvailable().filter(Predicate.not(List::isEmpty))
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ApiOperation("Create a new Product")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a product with an id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity remove(@ApiParam(value = "The product id", required = true, example = "10") @PathVariable("id") int productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Update a product with an id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<Product> update(@ApiParam(value = "The product id", required = true, example = "19") @PathVariable("id") int productId, @RequestBody Product productUpdate) {
        return new ResponseEntity<>(productService.updateProduct(productId, productUpdate), HttpStatus.OK);
    }
}
