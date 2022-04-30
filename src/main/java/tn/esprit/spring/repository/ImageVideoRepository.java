package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.ImageVideo;


@Repository
public interface ImageVideoRepository extends JpaRepository<ImageVideo, Long> {

}