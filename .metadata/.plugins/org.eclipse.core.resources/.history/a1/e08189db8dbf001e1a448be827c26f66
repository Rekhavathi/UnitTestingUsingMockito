package com.test.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.springcloud.model.Coupon;

//CouponRepo is required to perform CRUD operations against the Model Coupon

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
