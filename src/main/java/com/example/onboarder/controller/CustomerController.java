package com.example.onboarder.controller;

import com.example.onboarder.dto.CustomerResponse;
import com.example.onboarder.dto.RegisterCustomerRequest;
import com.example.onboarder.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService svc;

    public CustomerController(CustomerService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> register(@Valid @RequestBody RegisterCustomerRequest req) {
        CustomerResponse added = svc.register(req);
        URI location = URI.create("/api/customers/" + added.getId());
        return ResponseEntity.created(location).body(added);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> list() {
        return ResponseEntity.ok(svc.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(svc.getById(id));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<CustomerResponse> approve(@PathVariable Long id) {
        return ResponseEntity.ok(svc.approve(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    svc.delete(id);
    return ResponseEntity.noContent().build(); // HTTP 204
}
}
