package com.example.bookingservice.service;

import com.example.bookingservice.dto.FlightDTO;
import com.example.bookingservice.dto.UserDTO;
import com.example.bookingservice.entity.Booking;
import com.example.bookingservice.feign.FlightClient;
import com.example.bookingservice.feign.UserClient;
import com.example.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    
    private final BookingRepository bookingRepository;
    private final UserClient userClient;
    private final FlightClient flightClient;

    public BookingService(BookingRepository bookingRepository, UserClient userClient, FlightClient flightClient) {
        this.bookingRepository = bookingRepository;
        this.userClient = userClient;
        this.flightClient = flightClient;
    }

    public Booking bookFlight(String username, Long flightId) {
        UserDTO user = userClient.getUserByUsername(username);
        FlightDTO flight = flightClient.getFlightById(flightId);

        Booking booking = new Booking(user.getId(), flight.getId(), 500.0, "CONFIRMED");
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    public Booking cancelBooking(Long bookingId) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setStatus("CANCELLED");
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Booking not found!");
    }
}
