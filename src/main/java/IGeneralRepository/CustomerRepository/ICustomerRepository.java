package IGeneralRepository.CustomerRepository;

import IGeneralRepository.IGeneralRepository;
import model.Customer;

import java.util.List;

public interface ICustomerRepository extends IGeneralRepository<Customer> {
    List<Customer> findAll();

    void save(Customer customer);

}
