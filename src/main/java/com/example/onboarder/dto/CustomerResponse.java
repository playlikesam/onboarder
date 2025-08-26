package com.example.onboarder.dto;

import com.example.onboarder.model.OnboardingStatus;

import java.time.Instant;

public class CustomerResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private OnboardingStatus status;
    private Instant createdAt;

    public CustomerResponse() {}

    public CustomerResponse(Long id, String name, String email, String phone, OnboardingStatus status, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.createdAt = createdAt;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public OnboardingStatus getStatus() { return status; }
    public void setStatus(OnboardingStatus status) { this.status = status; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
