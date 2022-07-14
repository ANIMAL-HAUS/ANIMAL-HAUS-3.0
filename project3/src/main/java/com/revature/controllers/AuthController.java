package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.models.Days;
import com.revature.models.Product;
import com.revature.models.TimeofDay;
import com.revature.models.UserRole;
import com.revature.models.Users;
import com.revature.repository.UserDAO;
import com.revature.services.AuthenticationServices;
import com.revature.services.ProductServices;
import com.revature.services.UserServices;


@Controller
@RequestMapping(value="/authcontroller")
@CrossOrigin
public class AuthController {
	private AuthenticationServices as;
	
	@Autowired
	public AuthController(AuthenticationServices service) {
		this.as = service;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Users> getAllHouses(){
		return UserServices.getAllUsers();
	}
	
	
	@PostMapping
	public ResponseEntity<Users> insertUser(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setRole(UserRole.Customer);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}
		
		
	}
	@PostMapping("/contractormorningweekends")
	public ResponseEntity<Users> insertUserContractorMorningWeekends(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.Weekends);
			user.setTime(TimeofDay.Morning);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}
		
		
	}
	@PostMapping("/contractorafternoonweekends")
	public ResponseEntity<Users> insertUserContractorAfternoonWeekends(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.Weekends);
			user.setTime(TimeofDay.Afternoon);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}	
	}
	@PostMapping("/contractornightweekends")
	public ResponseEntity<Users> insertUserContractorNightWeekends(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.Weekends);
			user.setTime(TimeofDay.night);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}	
		}
	@PostMapping("/contractoranytimeweekends")
	public ResponseEntity<Users> insertUserContractorAnytimeWeekends(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.Weekends);
			user.setTime(TimeofDay.Anytime);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}	
		}
	@PostMapping("/contractormorningweekdays")
	public ResponseEntity<Users> insertUserContractorMorningWeekdays(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.WeekDays);
			user.setTime(TimeofDay.Morning);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}	
		}
	@PostMapping("/contractorafternoonweekdays")
	public ResponseEntity<Users> insertUserContractorAfternooonWeekdays(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.WeekDays);
			user.setTime(TimeofDay.Afternoon);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}	
		}
	@PostMapping("/contractornightweekdays")
	public ResponseEntity<Users> insertUserContractorNightWeekdays(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.WeekDays);
			user.setTime(TimeofDay.night);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}	
		}
	@PostMapping("/contractoranytimeweekdays")
	public ResponseEntity<Users> insertUserContractorAnytimeWeekdays(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.WeekDays);
			user.setTime(TimeofDay.Anytime);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}	
		}
	@PostMapping("/contractormorninganyday")
	public ResponseEntity<Users> insertUserContractorMorningAnyday(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.AnyDay);
			user.setTime(TimeofDay.Morning);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}	
		}
	@PostMapping("/contractorafternoonanyday")
	public ResponseEntity<Users> insertUserContractorAfternoonAnyday(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.AnyDay);
			user.setTime(TimeofDay.Afternoon);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}	
		}
	@PostMapping("/contractornightanyday")
	public ResponseEntity<Users> insertUserContractornightAnyday(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.AnyDay);
			user.setTime(TimeofDay.night);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}	
		}
	@PostMapping("/contractoranytimeanyday")
	public ResponseEntity<Users> insertUserContractoranytimeAnyday(@RequestBody Users user){
		System.out.println(user.getPassword());
		
		if(user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			user.setDay(Days.AnyDay);
			user.setTime(TimeofDay.Anytime);
			user.setRole(UserRole.Contractor);
			as.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}	
		}
	@PostMapping("/login")
	public ResponseEntity<Users> login(@RequestBody Users user){
		if (user.getUserName() == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}
		else if(as.login(user.getUserName(), user.getPassword())!= null)  {
			user = as.login(user.getUserName(), user.getPassword());
			
		
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}else {
		return null;
	}
	}
		
	}
	
	
	


	
	
