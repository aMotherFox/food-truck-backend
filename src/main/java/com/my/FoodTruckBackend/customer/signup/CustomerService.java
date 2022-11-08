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
        if (!newCustomerRequestBody.getPassword().equals(newCustomerRequestBody.getConfirmPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "passwords do not match");
        }

        return customerRepository.createNewCustomers(newCustomerRequestBody);
    }
}
