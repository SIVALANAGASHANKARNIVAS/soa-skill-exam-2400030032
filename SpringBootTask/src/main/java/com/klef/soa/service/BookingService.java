package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Booking;

public interface BookingService 
{
	
	Booking addBooking(Booking booking);
	Booking updateBooking(Booking booking);
	List<Booking> displayAllBookings();
	String deleteBooking(Long id);
	Booking displayById(Long id);
	List<Booking> displayByType(String type);
	List<Booking> displayByName(String name);
	List<Booking> findByStatus(boolean status);
	
	

}
