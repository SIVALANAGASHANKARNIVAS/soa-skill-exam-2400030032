package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Booking;
import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>
{
	List<Booking> findByType(String type);
	List<Booking> findByName(String name);
	
	List<Booking> findByStatus(boolean status);

}
