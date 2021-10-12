package com.mymvcapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mymvcapp.entity.Customer;
import com.mymvcapp.exception.ResourceNotFoundException;
import com.mymvcapp.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/home")
	public String welcome() {
		System.out.println("list?");
		return "hello.jsp";
	}
	
//	@GetMapping("/home")
//	public ModelAndView welcome() {
//		System.out.println("list 1");
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("list-customers.jsp");
//		System.out.println("list 2");
//		return mv;
//	}


	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		System.out.println("1 controller");
		List<Customer> theCustomers = customerService.getCustomers();
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel)
			throws ResourceNotFoundException {
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) throws ResourceNotFoundException {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
