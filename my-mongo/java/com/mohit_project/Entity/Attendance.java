package com.mohit_project.Entity;

import java.time.Duration;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
//    @JsonBackReference
    private Employee employee;
    private LocalDateTime punchIn;
    private LocalDateTime punchOut;
    private int timer;
    public Duration getDuration() {
        if (punchIn != null && punchOut != null) {
            return Duration.between(punchIn, punchOut);
        }
        return Duration.ZERO;
    }
}
