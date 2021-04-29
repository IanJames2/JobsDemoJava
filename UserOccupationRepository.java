package com.CodingDojo.LognadReg.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.LognadReg.Models.UserOccupation;

@Repository
public interface UserOccupationRepository extends CrudRepository<UserOccupation, Long>{

}
