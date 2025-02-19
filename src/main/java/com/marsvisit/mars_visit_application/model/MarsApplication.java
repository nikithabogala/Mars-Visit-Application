package com.marsvisit.mars_visit_application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.marsvisit.mars_visit_application.validation.Stage1;
import com.marsvisit.mars_visit_application.validation.Stage2;
import com.marsvisit.mars_visit_application.validation.Stage3;

@Data
@NoArgsConstructor
@Entity
@Table(name = "mars_applications")
public class MarsApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Stage 1: Personal Information ---
    @NotBlank(message = "Full name is required", groups = Stage1.class)
    private String fullName;

    @NotNull(message = "Date of birth is required", groups = Stage1.class)
    @Past(message = "Date of birth must be in the past", groups = Stage1.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Nationality is required", groups = Stage1.class)
    private String nationality;

    @NotBlank(message = "Email is required", groups = Stage1.class)
    @Email(message = "Invalid email format", groups = Stage1.class)
    private String email;

    @NotBlank(message = "Phone number is required", groups = Stage1.class)
    private String phone;

    // --- Stage 2: Travel Preferences ---
    @NotNull(message = "Departure date is required", groups = Stage2.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @NotNull(message = "Return date is required", groups = Stage2.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    @NotBlank(message = "Accommodation preference is required", groups = Stage2.class)
    private String accommodationPreference;

    // Optional
    private String specialRequests;

    // --- Stage 3: Health and Safety ---
    @AssertTrue(message = "You must declare your health status", groups = Stage3.class)
    private Boolean healthDeclaration;

    @NotBlank(message = "Emergency contact is required", groups = Stage3.class)
    private String emergencyContact;

    // Optional
    private String medicalConditions;
}
