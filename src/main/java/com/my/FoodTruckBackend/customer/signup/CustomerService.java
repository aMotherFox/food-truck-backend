package com.my.FoodTruckBackend.customer.signup;

import com.my.FoodTruckBackend.customer.CustomerDto;
import com.my.FoodTruckBackend.customer.signup.CustomerRepository;
import com.my.FoodTruckBackend.customer.signup.NewCustomerRequestBody;
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

    public List<CustomerDto> getListOfCustomers() {
        return customerRepository.getListOfCustomers();
    }

    public CustomerDto createNewCustomers(NewCustomerRequestBody newCustomerRequestBody) {
        if (newCustomerRequestBody.getPassword().equals(newCustomerRequestBody.getConfirmPassword())) {
            log.info("Passwords match");
        } else {
            log.error("Passwords do not match");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "passwords do not match");
        }
        if (newCustomerRequestBody.getFirstName().length() < 2 || newCustomerRequestBody.getFirstName().length() > 50) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Please enter your first name, between 2-50 characters"
            );
        }
        if (newCustomerRequestBody.getLastName().length() < 2 || newCustomerRequestBody.getLastName().length() > 50) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Please enter your last name, between 2-50 characters"
            );
        }
        if (newCustomerRequestBody.getPassword().length() < 8 || newCustomerRequestBody.getPassword().length() > 50) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Please enter a unique password, between 8-50 characters"
            );
        }
        if (
            newCustomerRequestBody.getConfirmPassword().length() < 8 ||
            newCustomerRequestBody.getConfirmPassword().length() > 50
        ) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Please re-enter your unique password, between 8-50 characters"
            );
        }
        return customerRepository.createNewCustomers(newCustomerRequestBody);
    }
}
