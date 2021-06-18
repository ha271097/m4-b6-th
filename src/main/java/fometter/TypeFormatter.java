package fometter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import repository.entity.TypeCustomer;
import service.ITypeService;

import java.text.ParseException;
import java.util.Locale;
@Component
public class TypeFormatter implements Formatter<TypeCustomer> {
    @Autowired
    private ITypeService typeService;

    public TypeFormatter(ITypeService typeService) {
        this.typeService = typeService;
    }

    public TypeFormatter() {
    }

    @Override
    public TypeCustomer parse(String text, Locale locale) throws ParseException {
        Long id = Long.parseLong(text);
        TypeCustomer typeCustomer = (TypeCustomer) typeService.findById(id);
        return typeCustomer;
    }

    @Override
    public String print(TypeCustomer object, Locale locale) {
        return null;
    }
}
