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

    public CustomerDto createNewCustomer(NewCustomerRequestBody newCustomerRequestBody) {
        Customer newCustomer = customerRepository.createNewCustomer(newCustomerRequestBody);
        return new CustomerDto(
            newCustomer.getId(),
            newCustomerRequestBody.getFirstName()
        );
    }
}
