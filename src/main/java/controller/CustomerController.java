package controller;

import aop.Logger;
import org.springframework.core.env.Environment;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import repository.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import repository.entity.CustomerUpload;
import repository.entity.TypeCustomer;
import service.ICustomerService;
import service.ITypeService;
import service.ex.HandleEx;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    Environment environment;

    @Autowired
    private ICustomerService customerService;

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private ITypeService typeService;

    @ModelAttribute("types")
    public List<TypeCustomer> typeCustomer(){
        return typeService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView showAll(){
        ModelAndView mav = new ModelAndView("/home");
        mav.addObject("c", customerService.findAll());
        mav.addObject("i", fileUpload);
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView showFromCreate(){
        ModelAndView mav = new ModelAndView("/create");
        mav.addObject("c", new CustomerUpload());
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView save(@Validated @ModelAttribute("c") CustomerUpload customerUpload, BindingResult bindingResult)  {
        if (!bindingResult.hasFieldErrors()) {
            MultipartFile multipartFile = customerUpload.getImg();
            String fileName = multipartFile.getOriginalFilename();
            try {
                FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Customer customer = new Customer();
            customer.setImg(fileName);
            customer.setFirstName(customerUpload.getFirstName());
            customer.setLastName(customerUpload.getLastName());
            customer.setType(customerUpload.getType());
            customerService.saveOrUpdate(customer);
            return new ModelAndView("/home");
        }
        return new ModelAndView("/create");
    }


    @GetMapping("/edit")
    public ModelAndView showFromEdit(){
        ModelAndView mav = new ModelAndView("/edit");
        mav.addObject("c",new Customer());

        return mav;
    }
    @PostMapping("/edit")
    public String update(Customer customer){
        customerService.saveOrUpdate(customer);
        return "redirect:/customer/home";
    }
    @GetMapping("/remove")
        public String remove(Long id){
        customerService.remove(id);
        return "redirect:/customer/home";
    }

    @GetMapping("/find")
    public ModelAndView findCustomer(String id) throws HandleEx {

            ModelAndView mav = new ModelAndView("/info_customer");
            mav.addObject("c", customerService.findById(Long.parseLong(id)));
            return mav;

    }

    @ExceptionHandler(HandleEx.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/error");
    }
}
