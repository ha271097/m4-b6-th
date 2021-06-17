package service;

import IGeneralRepository.CustomerRepository.ICustomerRepository;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService<Customer>{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        customerRepository.save(customer);
        System.out.println("luu thanh cong");
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }

}
