package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Booking;
import com.klef.soa.service.BookingServiceImpl;

@RestController
public class BookingController 
{
	@Autowired
	private BookingServiceImpl service;
	

	@GetMapping("/")
	public String home()
	{
		return "Welcome to Booking Details";
	}
	
	@PostMapping("/add")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking)
	{
		Booking b = service.addBooking(booking);
		return ResponseEntity.ok(b);
	}
	
	@GetMapping("/displayallbookings")
	public ResponseEntity<List<Booking>> displayAllBookings()
	{
		List<Booking> bookings = service.displayAllBookings();
		return ResponseEntity.ok(bookings);
	}
	
	@PutMapping("/updatebooking")
	public ResponseEntity<?> updateBooking(@RequestBody Booking booking)
	{
		Booking b = service.updateBooking(booking);
		if(b!=null)
		{
			return ResponseEntity.ok(b);
		}
		else
		{
			return ResponseEntity.status(404).body("Id Not Found");
		}
	}
	
	@GetMapping("/displaybyname")
	public ResponseEntity<?> displayByName(@RequestParam String name)
	{
		List<Booking> b = service.displayByName(name);
		
		if(!b.isEmpty())
		{
			return ResponseEntity.ok(b);
		}
		else
		{
			return ResponseEntity.status(404).body("Name Not Found");
		}
	}
	
	@GetMapping("/displaybytype/{type}")
	public ResponseEntity<?> displayByType(@PathVariable String type)
	{
		List<Booking> b =service.displayByType(type);
		if(!b.isEmpty())
		{
			return ResponseEntity.ok(b);
		}
		else
		{
			return ResponseEntity.status(404).body("Not Found");
		}
	}
	
	@GetMapping("/displaybyid")
	public ResponseEntity<?> displayById(@RequestParam Long id)
	{
		Booking booking = service.displayById(id);
		
		if(booking!=null)
		{
			return ResponseEntity.ok(booking);
		}
		else
		{
			return ResponseEntity.status(404).body("Id Not Found");
		}
	}
	
	@DeleteMapping("/deletebooking/{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable Long id)
	{
		String b = service.deleteBooking(id);
		
		return ResponseEntity.ok(b);
	}
	
	@GetMapping("getByStatus")
	public List<Booking> displayByStatus(@RequestParam boolean status)
	{
		return service.findByStatus(status);
	}
	
}
