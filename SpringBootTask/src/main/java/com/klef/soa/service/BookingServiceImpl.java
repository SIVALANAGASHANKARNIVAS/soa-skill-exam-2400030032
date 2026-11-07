package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Booking;
import com.klef.soa.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService
{
	@Autowired
	private BookingRepository repository;

	@Override
	public Booking addBooking(Booking booking) 
	{
		return repository.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) 
	{
		Optional<Booking>  optional = repository.findById(booking.getId());
		if(optional.isPresent())
		{
			Booking b = optional.get();
			
			b.setName(booking.getName());
			b.setLocation(booking.getLocation());
			b.setStatus(booking.isStatus());
			b.setType(booking.getType());
			
			return repository.save(b);
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public List<Booking> displayAllBookings() 
	{
		
		return repository.findAll();
	}

	@Override
	public String deleteBooking(Long id) 
	{
		Optional<Booking> optional = repository.findById(id);
		
		if(optional.isPresent())
		{
			repository.deleteById(id);
			return "Booking Cancelled";
		}
		else
		{
			return "Id Not Found";
		}
		
		
	}

	@Override
	public Booking displayById(Long id) 
	{			
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Booking> displayByType(String type) 
	{
		
		return repository.findByType(type);
	}

	@Override
	public List<Booking> displayByName(String name) 
	{
	
		return repository.findByName(name);
	}

	@Override
	public List<Booking> findByStatus(boolean status) {
		
		return repository.findByStatus(status);
	}

}
