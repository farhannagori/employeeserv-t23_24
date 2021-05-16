package com.paypal.bfs.test.employeeserv.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "city", length = 255)
    private String city;

    @Column(name = "state", length = 255)
    private String state;

    @Column(name = "country", length = 255)
    private String country;

    @Column(name = "zip_code", length = 10)
    private Integer zipCode;

    @Column(name = "line1", length = 500)
    private String line1;

    @Column(name = "line2", nullable = true, length = 500)
    private String line2;

}