package com.my.FoodTruckBackend.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getListOfCustomers() {
        System.out.println("we are inside the customer controller getListOfCustomers");
        return customerService.getListOfCustomers();
    }

    @PostMapping("/customer")
    public CustomerDto createNewCustomers(@Valid @RequestBody NewCustomerRequestBody newCustomerRequestBody) {
        log.info("We are creating a new customer with the request body: " + newCustomerRequestBody);
        return customerService.createNewCustomers(newCustomerRequestBody);
    }

}
