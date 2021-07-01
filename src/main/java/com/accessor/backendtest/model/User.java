package com.accessor.backendtest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Ein Nachname ist erforderlich")
    @NotNull(message = "Ein Nachname ist erforderlich")
    private String lastName;
    @NotBlank(message = "Ein Vorname ist erforderlich")
    @NotNull(message = "Ein Vorname ist erforderlich")
    private String firstName;
    private String address;
    private String color;
    private Date time;
}
