package com.example.bookingservice.dto;

public class FlightDTO {
    private Long id;
    private String flightNumber;
    private String departure;
    private String arrival;
    private String flightDate;

    public FlightDTO() {}

    public FlightDTO(Long id, String flightNumber, String departure, String arrival, String flightDate) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.flightDate = flightDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getDeparture() { return departure; }
    public void setDeparture(String departure) { this.departure = departure; }

    public String getArrival() { return arrival; }
    public void setArrival(String arrival) { this.arrival = arrival; }

    public String getFlightDate() { return flightDate; }
    public void setFlightDate(String flightDate) { this.flightDate = flightDate; }
}
