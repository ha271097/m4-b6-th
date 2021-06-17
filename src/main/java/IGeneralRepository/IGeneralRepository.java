package IGeneralRepository;

public interface IGeneralRepository<T> {

    T findById(Long id);

    void save(T t);

    void remove(Long id);
}
