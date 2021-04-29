package com.CodingDojo.LognadReg.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="occupation")
public class Occupation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="What type of job is being advertised? Please enter a job type.")
	private String type;
	
	@NotEmpty(message="Which company is advertising this position? Please enter a company.")
	private String company;
	
	@NotEmpty(message="Please enter the city for your occupation")
	private String city;
	
	@NotEmpty(message="Please enter the state for your occupation")
	private String state;
	
	@NotEmpty(message="How much will this position get paid? Please enter a salary.")
	private Integer salary;
	
	@Size(min=2, message ="Group name must be at least 2 char")
	private String benefits;
	
	private String shift;
	
	@FutureOrPresent	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date start_date;
	
	@NotEmpty(message="Please enter description of occupation.")
	@Size(min=25, message ="Job Description must be at least 25 characters.")
	private String job_description;
	
	private String education_and_certifications;
	
	@NotEmpty(message="Please enter the skills required to be considered for this occupation.")
	private String required_skills_and_experience;
	
	private String desired_skills_and_experience;
	
	private String soft_skills;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "users_occupations",
		joinColumns = @JoinColumn(name = "occupation_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> joinedUsers;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
    
    @OneToMany(mappedBy="occupation", fetch = FetchType.LAZY)
	private List<RateReview> ratereviews;
    
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	public String getEducation_and_certifications() {
		return education_and_certifications;
	}
	public void setEducation_and_certifications(String education_and_certifications) {
		this.education_and_certifications = education_and_certifications;
	}
	public String getRequired_skills_and_experience() {
		return required_skills_and_experience;
	}
	public void setRequired_skills_and_experience(String required_skills_and_experience) {
		this.required_skills_and_experience = required_skills_and_experience;
	}
	public String getDesired_skills_and_experience() {
		return desired_skills_and_experience;
	}
	public void setDesired_skills_and_experience(String desired_skills_and_experience) {
		this.desired_skills_and_experience = desired_skills_and_experience;
	}
	public String getSoft_skills() {
		return soft_skills;
	}
	public void setSoft_skills(String soft_skills) {
		this.soft_skills = soft_skills;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<User> getJoinedUsers() {
		return joinedUsers;
	}
	public void setJoinedUsers(List<User> joinedUsers) {
		this.joinedUsers = joinedUsers;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<RateReview> getRatereviews() {
		return ratereviews;
	}
	public void setRatereviews(List<RateReview> ratereviews) {
		this.ratereviews = ratereviews;
	}
	
}
