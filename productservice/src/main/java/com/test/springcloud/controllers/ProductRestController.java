package com.test.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.springcloud.dto.Coupon;
import com.test.springcloud.model.Product;
import com.test.springcloud.repo.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	
	//Inject the repository,  Product repo is the interface
	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponService.url}")
	private String couponServiceUrl;
	
	// This method returns a product after creating a product in the database
	@PostMapping("/products")
	public Product create(@RequestBody Product product)
	{
	
		System.out.println("here"+getCouponServiceURL() + product.getCouponCode());
		Coupon coupon = restTemplate.getForObject(getCouponServiceURL() + product.getCouponCode(), Coupon.class);
		//Coupon coupon = restTemplate.getForObject("http://localhost:9091/couponapi/coupons/"+product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);
	}
	
	public String getCouponServiceURL() {
		return couponServiceUrl;
	}

	public void setCouponServiceURL(String couponServiceURL) {
		this.couponServiceUrl = couponServiceURL;
	}

}

