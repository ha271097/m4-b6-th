package service.typeservice;

import org.springframework.beans.factory.annotation.Autowired;
import repository.ITypeRepo;
import repository.entity.TypeCustomer;
import service.ITypeService;

import java.util.List;

public class TypeService implements ITypeService<TypeCustomer> {
    @Autowired(required = true)
    private ITypeRepo typeService;

    @Override
    public List<TypeCustomer> findAll() {
        return (List<TypeCustomer>) typeService.findAll();
    }

    @Override
    public TypeCustomer findById(Long id) {
        return (TypeCustomer) typeService.findOne(id);
    }

    @Override
    public void saveOrUpdate(TypeCustomer typeCustomer) {
        typeService.save(typeCustomer);
    }

    @Override
    public void remove(Long id) {
        typeService.delete(id);
    }
}
