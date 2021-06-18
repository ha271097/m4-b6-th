package service;

import java.util.List;

public interface ITypeService <T>{

        List<T> findAll();

        T findById(Long id);

        void saveOrUpdate(T t);


        void remove(Long id);
}
