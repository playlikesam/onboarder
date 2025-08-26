package com.example.onboarder.service;

import com.example.onboarder.dto.CustomerResponse;
import com.example.onboarder.dto.RegisterCustomerRequest;
import com.example.onboarder.exception.ResourceAlreadyExistsException;
import com.example.onboarder.exception.ResourceNotFoundException;
import com.example.onboarder.model.Customer;
import com.example.onboarder.model.OnboardingStatus;
import com.example.onboarder.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public CustomerResponse register(RegisterCustomerRequest req) {
        repo.findByEmail(req.getEmail()).ifPresent(c -> {
            throw new ResourceAlreadyExistsException("email already registered");
        });

        Customer c = new Customer(req.getName(), req.getEmail(), req.getPhone());
        c.setStatus(OnboardingStatus.PENDING);
        Customer saved = repo.save(c);
        return toResponse(saved);
    }

    public List<CustomerResponse> getAll() {
        return repo.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public CustomerResponse getById(Long id) {
        Customer c = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("customer not found"));
        return toResponse(c);
    }

    @Transactional
    public CustomerResponse approve(Long id) {
        Customer c = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("customer not found"));
        c.setStatus(OnboardingStatus.APPROVED);
        return toResponse(repo.save(c));
    }

    // ✅ NEW DELETE METHOD
    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("customer not found with id " + id);
        }
        repo.deleteById(id);
    }

    private CustomerResponse toResponse(Customer c) {
        return new CustomerResponse(
                c.getId(),
                c.getName(),
                c.getEmail(),
                c.getPhone(),
                c.getStatus(),
                c.getCreatedAt()
        );
    }
}
