package com.ops.delt;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(path = "/delt")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping(path = "/add")
    public Customer addNewCustomer(@RequestParam String name, @RequestParam String email,
                                   @RequestParam String githubUrl, @RequestParam String twitterUrl) {
        Customer springCustomer = new Customer();
        springCustomer.setName(name);
        springCustomer.setEmail(email);
        springCustomer.setGithubUrl(githubUrl);
        springCustomer.setTwitterUrl(twitterUrl);
        customerRepository.save(springCustomer);
        return springCustomer;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
