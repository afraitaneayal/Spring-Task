package com.example.demo.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/product")
public class ProductController {

    private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	} 

    @GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}

    @GetMapping(path = "{productId}")
	public Product getProduct(@PathVariable("productId") Long id) {
		return productService.getProduct(id);
	}

	@PostMapping
	public void registerNewProduct(@RequestBody Product product){
		productService.addNewProduct(product);
	}

	@DeleteMapping(path = "{productId}")
	public void deleteCustomer(@PathVariable("productId") Long id){
		productService.deleteProduct(id);
	}
	
	@PutMapping(path = "{productId}")
	public void updateCustomer(
		@PathVariable("productId") Long customerId,
		@RequestParam(required = false) String name,
		@RequestParam(required= false) Long price
	) {
		productService.updateProduct(customerId, name, price);
	}
}
