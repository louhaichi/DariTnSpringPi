package tn.esprit.spring.Service;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Coupon;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.CouponRepository;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	CouponRepository couponRepository;
	@Autowired
	UserRepository userRepo;
	
	// generer un code coupon alpha numerique de 100 caracteres
	public String CodeCoupon() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 100;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}
	
	@Override
	public Coupon saveCoupon(Coupon c,Long idUser) {
		User u = userRepo.findById(idUser).orElse(null);
		c.setUser(u);
		c.setEtat(true);
		c.setCode(CodeCoupon());
		
		
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