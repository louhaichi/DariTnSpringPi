package tn.esprit.spring.Service;

import java.util.List;
import java.util.Set;

import tn.esprit.spring.Entity.Coupon;

public interface CouponService {
	Coupon saveCoupon(Coupon c,Long idUser);
	Coupon updateCoupon(Coupon c);
	void deleteCoupon(Coupon c);
	 void deleteCouponById(Long id);
	 Coupon getCoupon(Long id);
	List<Coupon> getAllCoupons();
	
	
}