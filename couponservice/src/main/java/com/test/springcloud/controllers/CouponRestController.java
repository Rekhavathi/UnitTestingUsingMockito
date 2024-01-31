package com.test.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springcloud.model.Coupon;
import com.test.springcloud.repos.CouponRepo;

//Coupon REST Controller will expose out the RESTful API so that it can later on be used by the Product Service
@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	//Inject the repository, Coupon repo is the interface
	@Autowired
	CouponRepo repo;

	// This method returns a coupon after creating a coupon in the database
	@PostMapping("/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		if (coupon == null) {
			throw new IllegalArgumentException("Coupon is required");
		}
		return repo.save(coupon);

	}

	//Given a coupon code, return the existing coupon
	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);

	}
}
