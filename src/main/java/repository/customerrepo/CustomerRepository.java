//package IGeneralRepository.CustomerRepository;
//
//import repository.entity.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import java.util.List;
//
//@Transactional
//public class CustomerRepository implements ICustomerRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//    @Override
//    public List<Customer> findAll() {
////        TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
//        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public Customer findById(Long id) {
//        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c where c.id=:id", Customer.class );
//        query.setParameter("id", id);
//        try {
//            return query.getSingleResult();
//        }catch (Exception ex){
//            return null;
//        }
//    }
//
//    @Override
//    public void save(Customer customer) {
//        if (customer.getId() != null) {
//            entityManager.merge(customer);
//        } else {
//            entityManager.persist(customer);
//        }
//    }
//
//
//    @Override
//    public void remove(Long id) {
//        Customer customer = findById(id);
//        if(customer != null)
//        entityManager.remove(customer);
//    }
//}
