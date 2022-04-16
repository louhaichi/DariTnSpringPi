package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.Entity.Coupon;
import tn.esprit.spring.Service.CouponService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController

@RequestMapping("/api/v1")

public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	@GetMapping("/AfficheCoupon")
	public List<Coupon> afficheCoupons (){
		return couponService.getAllCoupons();
		}
	
	@PostMapping("/AjoutCoupon")
	public Coupon ajoutCoupon(@RequestBody Coupon c){
		return couponService.saveCoupon(c);
		}
	
	@GetMapping("/AfficheCoupon/{id}")
	public ResponseEntity<Coupon> AfficheCouponById(@PathVariable Long id){
		Coupon C= couponService.getCoupon(id) ;
		return ResponseEntity.ok(C); //cast 
		}
	
	@PutMapping("/ModifierCoupon/{id}")
	public ResponseEntity<Coupon>  ModifierCoupon(@RequestBody Coupon C, @PathVariable Long id){
		Coupon Cx= couponService.getCoupon(id);
		Cx.setCode(C.getCode());
		Cx.setEtat(C.getEtat());
		
		Coupon updateCoupon= couponService.updateCoupon(Cx);
		return ResponseEntity.ok(updateCoupon);
		}
}
