package com.CodingDojo.LognadReg.Service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.CodingDojo.LognadReg.Models.Occupation;
import com.CodingDojo.LognadReg.Models.RateReview;
import com.CodingDojo.LognadReg.Models.User;
import com.CodingDojo.LognadReg.Repositories.OccupationRepository;
import com.CodingDojo.LognadReg.Repositories.RateReviewRepository;
import com.CodingDojo.LognadReg.Repositories.UserOccupationRepository;
import com.CodingDojo.LognadReg.Repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final OccupationRepository occupationRepository;
    private final UserOccupationRepository useroccupationRepository;
    private final RateReviewRepository ratereviewRepository;
    
    public UserService(UserRepository userRepository, OccupationRepository occupationRepository, UserOccupationRepository useroccupationRepository, RateReviewRepository ratereviewRepository) {
        this.userRepository = userRepository;
        this.occupationRepository = occupationRepository;
        this.useroccupationRepository = useroccupationRepository;
        this.ratereviewRepository = ratereviewRepository;
    }
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()); //static line of code 
        user.setPassword(hashed);
        user.setEmail(user.getEmail().toLowerCase());
        return userRepository.save(user);

    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	return userRepository.findById(id).orElse(null);
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public void updateUser(User user) {
    	userRepository.save(user);
    }
    
    public void deleteOccupation(Long id) {
    	occupationRepository.deleteById(id);
	}
    
    public List<Occupation> allOccupations() {
    	return (List<Occupation>) occupationRepository.findAll();
    }
    
    public Occupation addOccupation(Occupation occupation) {
		return occupationRepository.save(occupation);
	}
    
    public RateReview addRateReview(RateReview ratereview) {
		return ratereviewRepository.save(ratereview);
	}
    
    public Occupation findOccupationById(Long id) {
    	Optional<Occupation> o = occupationRepository.findById(id);
    	if(o.isPresent()) {
            return o.get();
    	}
    	else {
    	    return null;
    	}
    }
    
    public void updateOccupation(Occupation occupation) {
    	occupationRepository.save(occupation);
    }
    
    public void updateRateReview(RateReview ratereview) {
    	ratereviewRepository.save(ratereview);
    }
    
    public void newRateReview(RateReview ratereview) {
    	ratereviewRepository.save(ratereview);
    }

	public UserOccupationRepository getUseroccupationRepository() {
		return useroccupationRepository;
	}
}

