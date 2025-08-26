package com.example.onboarder.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterCustomerRequest {

    @NotBlank(message = "name is required")
    @Size(max = 120)
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "must be a valid email")
    private String email;

    // optional phone; if present must be reasonable length and characters
    @Pattern(regexp = "^$|^\\+?[0-9 .\\-()]{7,20}$", message = "invalid phone")
    private String phone = "";

    public RegisterCustomerRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
