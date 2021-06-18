package service.CustomerService;

import repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import repository.entity.Customer;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService<Customer> {
    @Autowired(required = true)
    private ICustomerRepo repository;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        repository.findOne(id);
        return null;
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void remove(Long id) {
        repository.delete(id);
    }
}
