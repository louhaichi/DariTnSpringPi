package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Coupon;
import tn.esprit.spring.Repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	CouponRepository couponRepository;
	@Override
	public Coupon saveCoupon(Coupon c) {
		
		return couponRepository.save(c);
	}

	@Override
	public Coupon updateCoupon(Coupon c) {
		
		return couponRepository.save(c);
	}

	@Override
	public void deleteCoupon(Coupon c) {
		
		couponRepository.delete(c);
		
	}

	@Override
	public void deleteCouponById(Long id) {
		
		couponRepository.deleteById(id);
		
	}

	@Override
	public Coupon getCoupon(Long id) {
		
		return couponRepository.findById(id).get();
	}

	@Override
	public List<Coupon> getAllCoupons() {
		
		return couponRepository.findAll();
	}

}
