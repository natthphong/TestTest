package com.auth2.azuread.controller.rest.cache;


import com.auth2.azuread.CustomerRepository;
import com.auth2.azuread.controller.rest.CustomerEntity;
import com.auth2.azuread.controller.rest.CustomerModel;
import com.auth2.azuread.controller.rest.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;


    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Cacheable(value = "customer" , key = "#root.methodName", unless = "#result == null")
    public ResponseModel<List<CustomerModel>> getAllDataCustomer() {
        ResponseModel<List<CustomerModel>> responseModel = new ResponseModel<>();
        responseModel.setCode("0000");
        responseModel.setDescription("ok");
        try {

            List<CustomerEntity> customerEntityList = getListCustomerModel();

            List<CustomerModel> result = listCustomerModelToListCustomerEntity(customerEntityList);
            responseModel.setBody(result);

        } catch (Exception ex) {
            ex.printStackTrace();
            responseModel.setCode("9999");
            responseModel.setDescription(ex.getMessage());
        }

        return responseModel;
    }


    @Cacheable(value = "customer" , key = "#id", unless = "#result == null")
    public ResponseModel<CustomerEntity> getById(Long id) {
        ResponseModel<CustomerEntity> responseModel = new ResponseModel<>();
        responseModel.setCode("0000");
        responseModel.setDescription("ok");
        try {

            var customerEntityList = this.customerRepository.findById(id).orElseThrow(RuntimeException::new);

            responseModel.setBody(customerEntityList);

        } catch (Exception ex) {
            ex.printStackTrace();
            responseModel.setCode("9999");
            responseModel.setDescription(ex.getMessage());
        }

        return responseModel;
    }
    public List<CustomerModel> listCustomerModelToListCustomerEntity(List<CustomerEntity> customerEntityList) {
        List<CustomerModel> list = new ArrayList<>();
        for (CustomerEntity c : customerEntityList) {
            CustomerModel customerModel = new CustomerModel();
            customerModel.setAge(c.getAge());
            customerModel.setUsername(c.getUsername());
            customerModel.setEmail(c.getEmail());
            list.add(customerModel);
        }

        return list;
    }



    @Cacheable(value = "listCustomer" , key = "#root.methodName", unless = "#result == null")
    public List<CustomerEntity> getListCustomerModel() {

        log.info("get all in repository {}");
        return this.customerRepository.findAll();
    }

    public ResponseModel<String> init() {

        ResponseModel<String> responseModel = new ResponseModel<>();
        responseModel.setCode("0000");
        responseModel.setDescription("ok");
        List<CustomerEntity> customerEntityList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setAge(i);
            customerEntity.setUsername("Test Tar : " + i);
            customerEntity.setPassword(this.passwordEncoder.encode("123456" + i));
            customerEntity.setEmail("taza" + i + "a@hotmail.com");
            customerEntityList.add(customerEntity);
        }
        this.customerRepository.saveAll(customerEntityList);
        responseModel.setBody("success");
        return responseModel;
    }
}
