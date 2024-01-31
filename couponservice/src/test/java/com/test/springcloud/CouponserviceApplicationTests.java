package com.test.springcloud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.springcloud.controllers.CouponRestController;
import com.test.springcloud.model.Coupon;
import com.test.springcloud.repos.CouponRepo;

@SpringBootTest
class CouponserviceApplicationTests {

	private static final String SALE = "sale";

	//Mock the repository object
	@Mock
	private CouponRepo repo;
	
	//Injecting the mocked object into the controller
	@InjectMocks
	private CouponRestController controller;
	
	
	@Test
	public void testCreate() {
		Coupon coupon = new Coupon();
		coupon.setCode(SALE);
		when(repo.save(coupon)).thenReturn(coupon);
		Coupon couponCreated = controller.create(coupon);
		//verify if the save method is invoked
		verify(repo).save(coupon);
		assertNotNull(couponCreated);
		assertEquals(SALE,coupon.getCode());		
	}
	
	@Test
	public void testGetCoupon() {
		Coupon coupon = new Coupon();
		coupon.setId(1234);
		coupon.setDiscount(new BigDecimal(10));
		coupon.setCode(SALE);
		when(repo.findByCode(SALE)).thenReturn(coupon);
		Coupon couponResponse = controller.getCoupon(SALE);
		verify(repo).findByCode(SALE);
		assertEquals(new BigDecimal(10),couponResponse.getDiscount());
		
	}
	
	@Test
	public void testCreateWhenCouponIsNullThrowsException() {
		assertThrows(IllegalArgumentException.class,()->{
			controller.create(null);
		});
	}

	

}
