package com.my.FoodTruckBackend.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;


    public List<Customer> getListOfCustomers() {
        return customerRepository.getListOfCustomers();
    }

    public CustomerDto createNewCustomers(NewCustomerRequestBody newCustomerRequestBody) {
        Customer newCustomer = customerRepository.createNewCustomers(newCustomerRequestBody);

        //get password from newCustomerRequestBody
        //get confirmPassword from newCustomerRequestBody
        // password MUST == confirmPassword
        //if != then throw 400

        return new CustomerDto(
            newCustomer.getId(),
            newCustomerRequestBody.getFirstName(),
            newCustomerRequestBody.getLastName(),
            newCustomerRequestBody.getEmail()
        );
    }
}
