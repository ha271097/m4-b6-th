package service;

import service.ex.HandleEx;

import java.util.List;

public interface ICustomerService<T> {
    List<T> findAll();

    T findById(Long id) throws HandleEx;

    void saveOrUpdate(T t);


    void remove(Long id);
}
