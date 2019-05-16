package com.sapiens.controller;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapiens.customer.Customer;
import com.sapiens.policy.Policy;
import com.sapiens.service.CustService;




@Controller
//@RequestMapping(value= {"/customer"})
public class CustController {


    @Autowired
	CustService service;
	
	
	@RequestMapping(value= {"/welcome"})
	public String Home()
	{	
		return "welcome.jsp";
	}
	
	@GetMapping(value= {"/checkcust"})
	public String checkCust() {
	    return "CheckCust.jsp";
	}
   
	@PostMapping(value= {"/checkcust"})
	public String checkCust(Customer c) {
		long id=c.getId();
		Optional<Customer> cust=service.getById(id);
		System.out.println(cust);
		if (cust.isPresent())
			return "redirect:/addPolicy";
		else 
		return "welcome.jsp";
	}
	@GetMapping("/list")
	 public ModelAndView list() {
	  ModelAndView model = new ModelAndView("CustList.jsp");
	  List<Customer> customerlist = service.getCustomers();
	  model.addObject("customerlist", customerlist);
	  
	  return model;
	 }
	

	@GetMapping("/customerform")
	 public ModelAndView addCustomer() {
	  ModelAndView model = new ModelAndView();
	  
	  Customer cust = new Customer();
	  model.addObject("customerForm", cust);
	  model.setViewName("CustForm.jsp");
	  
	  return model;
	 }
	
	 @PostMapping("/saveCustomer")
	 public ModelAndView save(@ModelAttribute("customerForm") Customer cust) {
	  service.saveCustomer(cust);
	  
	  return new ModelAndView("redirect:/list");
	 }
	
	@GetMapping("/customers/{id}")
    public Optional<Customer> getById(@PathVariable(required = true) long id) {
        return service.getById(id);
    }
	
	@RequestMapping(value = "/addPolicy", method = RequestMethod.GET)
	 public ModelAndView addPolicy() {
	
	  ModelAndView model = new ModelAndView();
	  
	  Policy policy = new Policy();
	  model.addObject("policyform", policy);
	  model.setViewName("PolicyForm.jsp");
	  
	  return model;
	 }
	

	 @PostMapping("/addPolicy")
	 public String savePolicy(@ModelAttribute("policyform") Policy policy) {
	  service.savePolicy(policy);
	  
	  return "redirect:/list";
	 }
	
}
