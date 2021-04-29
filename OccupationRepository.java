package com.CodingDojo.LognadReg.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.LognadReg.Models.Occupation;

@Repository
public interface OccupationRepository extends CrudRepository <Occupation, Long>{

}
