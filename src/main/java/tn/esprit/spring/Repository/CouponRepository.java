package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.esprit.spring.Entity.Coupon;

public interface CouponRepository  extends JpaRepository<Coupon, Long> {

}