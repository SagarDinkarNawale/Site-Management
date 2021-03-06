package com.enginnerapp.engineerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.enginnerapp.engineerservice.dao.util.CommonMethods;
import com.enginnerapp.engineerservice.model.AccountDetails;
import com.enginnerapp.engineerservice.model.Address;
import com.enginnerapp.engineerservice.model.Branch;
import com.enginnerapp.engineerservice.model.PersonInfo;
import com.enginnerapp.engineerservice.service.ManagerService;

@Controller
@RefreshScope

public class EngineerResource {
	@Value("${spring.application.name}")

	String appName;

	@Autowired
	ManagerService managerService;
	
	  @GetMapping 
	     public String login(Model model) {
	        return "login";
	     }

	
	@PostMapping("/home")
	public String performHome(
			@RequestParam("email") String email,
			 @RequestParam("pass") String pass,
			 @RequestParam("p_type") String p_type
		 
	) {
		System.out.println("----------Email : "+email);
		System.out.println("----------pass : "+pass);
		System.out.println("----------p_type : "+p_type);
		switch(p_type)
		{
		case "ENGINEER":

			if (email.equals("sagarnawale1000@gmail.com")&&pass.equals("12345")) 
			{
				System.out.println("=====Engineer Account Login success...===");
				return "engineer/index";
			}
			
			break;
		case "CUSTOMER":
			if (email.equals("sagarnawale1000@gmail.com")&&pass.equals("12345")) 
			{
				System.out.println("=====CUSTOMER Account Login success...===");
				return "customer/index";
			}
			break;
		case "ADMIN":
			if (email.equals("sagarnawale1000@gmail.com")&&pass.equals("12345")) 
			{
				System.out.println("=====Admin Account Login success...===");
				return "admin/index";
			}
			break;
		default :
			return "login";
		}
		return "login";
	}
	// Engineer all controller
	
	@RequestMapping("/addCustomer")
	public String engineerAddCustomer(Model model) {
		
		 String[] plans = {
		          "p1", "p2", "p3", "p4", 
		          "p5", "p6", "p7"
		        };
		        
	 	 model.addAttribute("k", "Sagar Nawale");
		 model.addAttribute("plans", plans);
		return "engineer/addCustomer";
		
		//return "engineer/test";
	}
	
	@PostMapping("/addCustomer")
	public String PerformEngineerAddCustomer(
			@RequestParam("fname") String fname,
			 @RequestParam("mobile") String mobile,
			 @RequestParam("address") String address,
			 @RequestParam("pincode") String pincode,
			 @RequestParam("eotp") String eotp,
			 @RequestParam("motp") String motp,
			 @RequestParam("textAreaPlans") String Plans,
			 
			 @RequestParam("email") String email
		 
	) {
		System.out.println("----------fname : "+fname);
		System.out.println("----------mobile : "+mobile);
		System.out.println("----------address : "+address);
		System.out.println("----------Email : "+email);
		System.out.println("----------pincode : "+pincode);
		System.out.println("----------Plans : "+Plans);
		
		System.out.println("----------Email OTP : "+eotp);
		System.out.println("----------Mobile OTP : "+motp);
		
		
		return "engineer/addCustomer";
	}
	
	@RequestMapping("/index")
	public String engineerHome() {
		return "engineer/index";
	}
	@RequestMapping("/profile")
	public String engineerProfile() {
		return "engineer/profile";
	}
	@RequestMapping("/viewCustomers")
	public String engineerViewCustomers() {
		return "engineer/viewCustomers";
	}
	@RequestMapping("/addPlan")
	public String engineerAddPlan() {
		return "engineer/addPlan";
	}
	@RequestMapping("/viewPlans")
	public String engineerViewPlans() {
		return "engineer/viewPlans";
	}
	@RequestMapping("/changePassword")
	public String engineerChangePassword() {
		return "engineer/changePassword";
	}
	@RequestMapping("/report")
	public String engineerReport() {
		return "engineer/report";
	}
	@RequestMapping("/support")
	public String engineerSupport() {
		return "engineer/support";
	}
	
	@RequestMapping("/help")
	public String engineerHelp() {
		return "engineer/help";
	}
	
	@RequestMapping("/terms")
	public String engineerTerms() {
		return "engineer/terms";
	}
	@RequestMapping("/privacy")
	public String engineerPrivacy() {
		return "engineer/privacy";
	}
	
	
	
	/*

//	@RequestMapping
//	public String index(Model model) {
//		return "index";
//	}

	 
	  @GetMapping("/greeting") public String greetingForm(Model model) {
	   model.addAttribute("greeting", new Greeting()); return "greeting"; }
	 

   

	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
		model.addAttribute("greeting", greeting);
		return "result";
	}

//        @PostMapping("/home")
//        public String loginSubmit(@ModelAttribute ManagerAuth login, Model model) {
//        	if(login.getUserName().equals("admin")&&login.getPass().equals("123"))
//        		{
//        		//insert into userlogin tables
//        		   System.out.println("==========Login success...================");
//        		   return "home";
//        		}
//        	else
//        	{
//        		
//        		 System.out.println("<<<<<<<<----------Login Fails-------->>>>>>>>>>");
//        		 model.addAttribute("Loing Fails", login);
//        		 return "home";
//        	}
//
////         
//        }

//        @GetMapping("/managerHome")
//        public String managerHome1(Model model) {
//         
//            return "managerHome";
//        }

	@GetMapping("/managerHome")
	public String managerHome(Model model) {
		return "managerHome";
	}
	
	@GetMapping("/addBranch")
	public String addBranch(Model model) {
		model.addAttribute("branch", new Branch());

		return "addBranch";
	}
//	@PostMapping("/addBranch")
//	public String addNewBranch(@RequestBody Branch branch) {
//		 	 
//		System.out.println("<<BRANCH====="+branch);
//			managerService.addNewBranch(branch);
//			System.out.println("==========Branch Added success...================");
//
//			return "addBranch";
//	 
//		 
//	}
	

	 @PostMapping("/addBranch")
	public String addBranchPerform(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam("branchId") String branchId, @RequestParam("branchName") String branchName,
			@RequestParam("ifscCode") String ifscCode, @RequestParam("micrCode") String micrCode

	) {

		if (userName.equals("admin") && password.equals("admin")) {
			Branch branchObj = new Branch();
			branchObj.setBranchId(Integer.parseInt(branchId));
			branchObj.setBranchName(branchName);
			branchObj.setIfscCode(ifscCode);
			branchObj.setMicrCode(micrCode);

			managerService.addNewBranch(branchObj);
			System.out.println("==========Branch Added success...================");

			return "addBranch";
		} else {

			System.out.println("<<<<<<<<----------Admin Login Fails-------->>>>>>>>>>");

			return "addBranch";
		}

	} 
//	person_id, personName, gender, dob, phone_number, address_id, person_type

	@PostMapping("/addCustomer")
	public String addCustomerPerform(@RequestParam("userId") String userId,

			@RequestParam("personName") String personName, @RequestParam("dateOfBirth") String dateOfBirth,
			@RequestParam("mobile") String mobile, @RequestParam("doorNo") int doorNo,
			@RequestParam("city") String city, @RequestParam("area") String area, @RequestParam("state") String state,
			@RequestParam("pinCode") String pinCode, @RequestParam("branchId") int branchId,
			@RequestParam("gender") String gender, @RequestParam("personType") String personType

	) {

		// get login user ID method
		if (userId.equals("1")) {

			Address address = new Address(doorNo, city, area, state, pinCode.toString(), personType, branchId);

 PersonInfo personInfo = new PersonInfo(branchId, personName, gender, dateOfBirth, mobile, address, personType, personType);
 			managerService.addNewPerson(personInfo);
			System.out.println("==========Customer Added success...================");

			return "addCustomer";
		} else {

			System.out.println("<<<<<<<<----------Admin Login Fails-------->>>>>>>>>>");

			return "addCustomer";
		}

	}

	@PostMapping("/updateCustomer")
	public String updateCustomerPerform(@RequestParam("userName") String userId,

			@RequestParam("personName") String personName, @RequestParam("dateOfBirth") String dateOfBirth,
			@RequestParam("mobile") String mobile, @RequestParam("customerId") int customerId

	) {

		if (userId.equals("1")) {
			PersonInfo personInfo = new PersonInfo();
			personInfo.setPersonName(personName);
			;
			personInfo.setDob(dateOfBirth);
			personInfo.setMobNumber(mobile);
			personInfo.setPersonType("MANAGER");
			;
			managerService.updateCustomer(customerId, personInfo);
			System.out.println("==========Customer Updated success...================");

			return "updateCustomer";
		} else {

			System.out.println("<<<<<<<<----------Admin Login Fails-------->>>>>>>>>>");

			return "updateCustomer";
		}

	}

	@PostMapping("/deleteCustomer")
	public String deleteCustomerPerform(@RequestParam("userName") String userId,
			@RequestParam("customerId") int customerId

	) {

		if (userId.equals("1")) {

			managerService.deleteCustomer(customerId);
			System.out.println("==========Customer Deleted success...================");

			return "deleteCustomer";
		} else {

			System.out.println("<<<<<<<<----------Admin Login Fails-------->>>>>>>>>>");

			return "deleteCustomer";
		}

	}

	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {
		return "addCustomer";
	}

	@GetMapping("/updateCustomer")
	public String updateCustomer(Model model) {
		return "updateCustomer";
	}

	@GetMapping("/addAccount")
	public String addAccount(Model model) {
		return "addAccount";
	}

	@PostMapping("/addAccount")
	public String addAccountPerform(@RequestParam("userId") String userId,
			@RequestParam("customerId") int customerId,
			@RequestParam("balance") int balance,
			@RequestParam("branchId") int branchId,
			@RequestParam("accountType") String accountType

	) {

		if (userId.equals("1")) {
			int accountTypeId;
			if(accountType.equals("SAVING"))
				accountTypeId=1;
			else
				accountTypeId=2;
			
			 
			  managerService.addAccount(accountType,CommonMethods.getAccountId(), balance, customerId,1,accountTypeId,branchId);
					  
		//	managerService.addAccount(customerId, balance, branchId, accountType);
			// managerService.deleteCustomer(customerId);
			System.out.println("========== Account Added success...================");

			return "addAccount";
		} else {

			System.out.println("<<<<<<<<----------Admin Login Fails-------->>>>>>>>>>");

			return "addAccount";
		}

	}

	@GetMapping("/editAccount")
	public String editAccount(Model model) {
		return "editAccount";
	}

	@PostMapping("/editAccount")
	public String editAccountPerform(
			@RequestParam("userId") String userId,
			@RequestParam("customerId") int customerId, @RequestParam("accountNumber") int accountNumber,
			@RequestParam("balance") int balance, @RequestParam("accountType") String accountType

	) {
		//get manager ID here
		if (userId.equals("1")) {
			managerService.updateAccount(customerId, accountNumber, accountType, balance);
			System.out.println("==========Customer Account updated success...================");

			return "editAccount";
		}
		
		return "editAccount";
		
	

	}
	
	

	@GetMapping("/deleteAccount")
	public String deleteAccount(Model model) {
		return "deleteAccount";
	}

	@PostMapping("/deleteAccount")
	public String deleteAccountPerform(
			@RequestParam("userName") String userId,
			  @RequestParam("accountNumber") int accountNumber,
			@RequestParam("accountType") String accountType

	) {
		//get manager ID here
		if (userId.equals("1")) {
			managerService.deleteAccount(0, accountNumber, accountType);
			System.out.println("==========Account DELETED success...================");

			return "deleteAccount";
		}
		
		return "deleteAccount";
		
	

	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(Model model) {
		return "deleteCustomer";
	}

	@GetMapping("/viewCustomerList")
	public String viewCustomerList(Model model) {
		return "viewCustomerList";
	}

	@GetMapping("/transaction")
	public String transaction(Model model) {
		return "transaction";
	}

//        
//        @GetMapping("/error")
//        public String error(Model model) {
//        
//            return "error";
//        }

	@GetMapping("/customerHome")
	public String customerHome(Model model) {

		return "customerHome";
	}
	@GetMapping("/findAccountDetails") // manager method
	public List<AccountDetails> findAccountDetails(){
	//	System.out.println(managerService.findAccountDetails());
		return managerService.findAccountDetails();
	}
	
*/
}