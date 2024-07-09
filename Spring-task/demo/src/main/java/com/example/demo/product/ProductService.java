package com.example.demo.product;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	} 
    public List<Product> getProducts() {
		    return productRepository.findAll();
	}

    public Product getProduct(Long productId){
		return productRepository.findById(productId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + productId + " does not exist"));
	}

	public void addNewProduct(Product product){
		Optional<Product> productByName =  productRepository.findProductByName(product.getName());
		if (productByName.isPresent()){
			throw new IllegalStateException ("Product already existing");
		}
		productRepository.save(product);
	}

	public void deleteProduct(Long productId){
		boolean exists = productRepository.existsById(productId);
		if (!exists){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + productId + " does not exists");
		}
		productRepository.deleteById(productId);
	}

	@Transactional
	public void updateProduct(Long productId, String name, Long price){
		Product product = productRepository.findById(productId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + productId + " does not exists"));
		if (name != null && name.length()> 0 && !Objects.equals(product.getName(), name)){
			product.setName(name);
		}
		if (price != null && price> 0 && !Objects.equals(product.getPrice(), price)){
			product.setPrice(price);
		}
	}

}
