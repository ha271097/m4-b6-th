package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.entity.TypeCustomer;
import service.ITypeService;

import java.util.List;

@Controller
@RequestMapping("/api/type")
@RestController
public class TypeCustomerController {
    @Autowired
    private ITypeService typeService;

    @ModelAttribute("type")
    public TypeCustomer typeCustomer(){
        return new TypeCustomer();
    }

    @GetMapping
    public ResponseEntity<Iterable<TypeCustomer>> findALl(){
        List<TypeCustomer> listType = typeService.findAll();
        if(listType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listType,HttpStatus.OK);
    }

    @GetMapping("/home")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("/homeType");
        List<TypeCustomer> listType = typeService.findAll();
        mav.addObject("listType", listType);
        return mav;
    }

    @GetMapping("/{id}")
    public ResponseEntity <TypeCustomer> findTypeCustomerById(@PathVariable Long id) {
        TypeCustomer typeCustomer = (TypeCustomer) typeService.findById(id);
        if (typeCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeCustomer, HttpStatus.OK);
    }

    @PostMapping("/home")
    public ResponseEntity<TypeCustomer> saveTypeCustomer(@RequestBody TypeCustomer typeCustomer) {
        typeService.saveOrUpdate(typeCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
        }

    @PutMapping("/{id}")
    public ResponseEntity<TypeCustomer> updateTypeCustomer(@PathVariable Long id, @RequestBody TypeCustomer typeCustomer) {
        typeCustomer.setId(id);
        typeService.saveOrUpdate(typeCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeCustomer> deleteTypeCustomer(@PathVariable Long id) {
        TypeCustomer typeCustomer = (TypeCustomer) typeService.findById(id);
        if (typeCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
