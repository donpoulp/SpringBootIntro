package com.example.springbootintro.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.io.Serializable;


@Getter @Setter @NoArgsConstructor
public class User implements Serializable {
    @NotNull
    private int id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Date birthDate;

    @NotNull
    @Size(min = 9, max = 9)
    private String code;


    public User(int id, String firstName, String lastName, String code, int years, int months, int days) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = new Date(years, months, days);
        this.code = code;
    }
}
