package com.my.FoodTruckBackend.customer.signup;

import com.my.FoodTruckBackend.customer.CustomerDto;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerDto> getListOfCustomers() {
        return customerService.getListOfCustomers();
    }

    @PostMapping("/customers")
    public CustomerDto createNewCustomers(@Valid @RequestBody NewCustomerRequestBody newCustomerRequestBody) {
        return customerService.createNewCustomers(newCustomerRequestBody);
    }
}
