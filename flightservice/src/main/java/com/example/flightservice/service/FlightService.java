package com.example.flightservice.service;

import com.example.flightservice.client.UserClient;
import com.example.flightservice.dto.UserDTO;
import com.example.flightservice.entity.Flight;
import com.example.flightservice.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final UserClient userClient;

    public FlightService(FlightRepository flightRepository, UserClient userClient) {
        this.flightRepository = flightRepository;
        this.userClient = userClient;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public UserDTO getUserDetails(String username) {
        return userClient.getUserByUsername(username);
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }
}
