package repository;

import repository.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo<T> extends CrudRepository<Customer, Long> {

}
