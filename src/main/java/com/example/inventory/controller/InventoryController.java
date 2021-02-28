package com.example.inventory.controller;

import com.example.inventory.service.MyUserDetailsService;
import com.example.inventory.exception.UserFoundException;
import com.example.inventory.models.AuthenticationRequest;
import com.example.inventory.models.AuthenticationResponse;
import com.example.inventory.models.Product;
import com.example.inventory.service.ProductRepository;
import com.example.inventory.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class InventoryController {


	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;


	@Autowired
	private MyUserDetailsService userDetailsService;



	@Autowired
	private ProductRepository productRepository;


	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}


	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@PostMapping("/create/products")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {

		Optional<Product> optionalProduct = productRepository.findById(product.getProductId());

		if (optionalProduct.isPresent()) {
		   throw new UserFoundException("Product ID:"+ product.getProductId());
		}

		Product newProduct = productRepository.save(product);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newProduct.getProductId()).toUri();

		return ResponseEntity.created(location).build();

	}



}