package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Booking;
import com.klef.soa.repository.BookingRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookingRepositoryTest
{
    @Autowired
    private BookingRepository repository;
        
    @Test
    void testFindAllBookings()
    {
        List<Booking> bookings =repository.findAll();
        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());
        System.out.println("Total Bookings:"+bookings.size());
    }

    @Test
    void testFindBookingById()
    {
        Optional<Booking> booking = repository.findById(1L);
        assertTrue(booking.isPresent());
        assertEquals(1L, booking.get().getId());
        System.out.println("Booking ID:"+booking.get().getId());
        System.out.println("Name:"+booking.get().getName());
    }

    @Test
    void testFindBookingByStatus()
    {
        List<Booking> booking=repository.findByStatus(true);
        assertFalse(booking.isEmpty());
        System.out.println("Contact: "+booking.size());
    }

    @Test
    void testFindBookingByName()
    {
        List<Booking> booking=repository.findByName("nivas");
        assertNotNull(booking);
    }

    @Test
    void testBookingDetails()
    {
        Optional<Booking> booking = repository.findById(1L);
        assertTrue(booking.isPresent());
        Booking B = booking.get();
        assertNotNull(B.getName());
        assertNotNull(B.getType());
        assertNotNull(B.getContact());
        assertNotNull(B.getLocation());
        System.out.println("Name:"+B.getName());
        System.out.println("Type:"+B.getType());
        System.out.println("Contact:"+B.getContact());
        System.out.println("Location: " +B.getLocation());
        System.out.println("Status: " + B.isStatus());
    }

  
    @Test
    void testTotalBookingCount()
    {
        long count = repository.count();
        assertTrue(count >= 0);
    }

    @Test
    void testFindBookingsByType()
    {
        List<Booking> bookings = repository.findByType("Online");
        assertNotNull(bookings);
        System.out.println("Bookings by Type: " + bookings.size());
    }
}
