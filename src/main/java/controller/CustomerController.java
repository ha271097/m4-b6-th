package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/home")
    public ModelAndView showAll(){
        ModelAndView mav = new ModelAndView("/home");
        mav.addObject("c", customerService.findAll());
        return mav;
    }
    @GetMapping("/create")
    public ModelAndView showFromCreate(){
        ModelAndView mav = new ModelAndView("/create");
        mav.addObject("c", new Customer());
        return mav;
    }
    @PostMapping("/create")
    public String save(Customer customer){
        customerService.saveOrUpdate(customer);
        return "redirect:/customer/home";
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
}
