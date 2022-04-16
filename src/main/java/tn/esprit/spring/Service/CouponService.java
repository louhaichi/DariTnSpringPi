package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Coupon;

public interface CouponService {
	Coupon saveCoupon(Coupon c);
	Coupon updateCoupon(Coupon c);
	void deleteCoupon(Coupon c);
	 void deleteCouponById(Long id);
	 Coupon getCoupon(Long id);
	List<Coupon> getAllCoupons();
}
