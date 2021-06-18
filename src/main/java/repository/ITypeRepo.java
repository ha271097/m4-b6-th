package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import repository.entity.TypeCustomer;
@Repository
public interface ITypeRepo extends CrudRepository<TypeCustomer, Long> {
}
