package com.my.FoodTruckBackend.customer;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getListOfCustomers() {
        return customerRepository.getListOfCustomers();
    }

    public CustomerDto createNewCustomers(NewCustomerRequestBody newCustomerRequestBody) {
        if (newCustomerRequestBody.getPassword().equals(newCustomerRequestBody.getConfirmPassword())) {
            log.info("Passwords match");
        } else {
            log.error("Passwords do not match");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "passwords do not match");
        }

        customerRepository.createNewCustomers(newCustomerRequestBody);

        return new CustomerDto(
            newCustomerRequestBody.getFirstName(),
            newCustomerRequestBody.getLastName(),
            newCustomerRequestBody.getEmail()
        );
    }
}
