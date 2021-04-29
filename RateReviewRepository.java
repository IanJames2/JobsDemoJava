package com.CodingDojo.LognadReg.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.LognadReg.Models.RateReview;

@Repository
public interface RateReviewRepository extends CrudRepository <RateReview, Long>{

}
