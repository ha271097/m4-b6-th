package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.entity.TypeCustomer;
import service.ITypeService;

import java.util.List;

@Controller
@RequestMapping("/api/type")
@RestController
public class TypeCustomerController {
    @Autowired
    private ITypeService typeService;

    @GetMapping
    public ResponseEntity<Iterable<TypeCustomer>> findALl(){
        List<TypeCustomer> listType = typeService.findAll();
        if(listType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listType,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <TypeCustomer> findCustomerById(@PathVariable Long id) {
        TypeCustomer typeCustomer = (TypeCustomer) typeService.findById(id);
        if (typeCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeCustomer, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TypeCustomer> saveCustomer(@RequestBody TypeCustomer typeCustomer) {
        typeService.saveOrUpdate(typeCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
        }

    @PutMapping("/{id}")
    public ResponseEntity<TypeCustomer> updateCustomer(@PathVariable Long id, @RequestBody TypeCustomer typeCustomer) {
        typeCustomer.setId(id);
        typeService.saveOrUpdate(typeCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeCustomer> deleteCustomer(@PathVariable Long id) {
        TypeCustomer typeCustomer = (TypeCustomer) typeService.findById(id);
        if (typeCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
