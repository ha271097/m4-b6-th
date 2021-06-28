package service.customerService;

import repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import repository.entity.Customer;
import service.ICustomerService;
import service.ex.HandleEx;

import java.util.List;

public class CustomerService implements ICustomerService<Customer> {
    @Autowired(required = true)
    private ICustomerRepo repository;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    @Override
    public Customer findById(Long id) throws HandleEx {
        Customer customer = (Customer) repository.findOne(id);
        if(customer==null){
            throw new HandleEx();
        }
        return customer;
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
