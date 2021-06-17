package service;

import java.util.List;

public interface ICustomerService<T> {
    List<T> findAll();

    T findById(Long id);

    void saveOrUpdate(T t);


    void remove(Long id);
}
