package domain;

import base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Ticket.TICKETTABLE)
@Setter
@Getter
@NoArgsConstructor
public class Ticket extends BaseEntity<Long> {
    public static final String TICKETTABLE = "ticket_table";
    private static final String ORIGIN = "origin";
    private static final String DESTINATION = "destination";
    private static final String DEPARTUREDATE = "departure_date";
    private static final String RETURNDATE = "return_date";
    private static final String NUMBEROFPASSENGERS = "number_of_passngers";
    private static final String AMOUNT = "amount";
    private static final String CUSTOMER = "customer";
    private static final String COMPANY = "company";

    @JoinColumn(name = ORIGIN)
    private String origin;

    @JoinColumn(name = DESTINATION)
    private String destination;

    @JoinColumn(name = DEPARTUREDATE)
    private LocalDateTime departureDate;

    @JoinColumn(name = RETURNDATE)
    private LocalDateTime returnDate;

    @JoinColumn(name = NUMBEROFPASSENGERS)
    private int numberOfPassengers;

    @JoinColumn(name = AMOUNT)
    private Double amount;

    @ManyToMany
    @JoinColumn(name = CUSTOMER)
    private List<Customer> customer = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = COMPANY)
    private Company company;

    public Ticket(String origin, String destination, LocalDateTime departureDate, LocalDateTime returnDate, int numberOfPassengers, Double amount) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfPassengers = numberOfPassengers;
        this.amount = amount;
    }
}
