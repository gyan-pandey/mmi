package com.mmi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mmi.bean.EmployeeDetails;
import com.mmi.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "indexjquery";
	}
	
	/*@RequestMapping(value = "addEmployee", method = RequestMethod.GET)
	public String addEmployee() {
		return "empform";
	}*/

/*	@RequestMapping(value = { "save" } , method = RequestMethod.GET)
	public ModelAndView save(@RequestParam int id, @RequestParam String name, @RequestParam float salary,
			@RequestParam String designation) {
		List<EmployeeDetails> employeeDetailsList = new ArrayList<EmployeeDetails>();
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setId(id);
		employeeDetails.setDesignation(designation);
		employeeDetails.setName(name);
		employeeDetails.setSalary(salary);
		employeeService.insertEmployeeDetails(employeeDetails);
		employeeDetailsList.add(employeeDetails);
		ModelAndView mv = new ModelAndView();
		mv.addObject("employeeDetailsList", employeeDetailsList);
		mv.setViewName("viewemp");
		return mv;

	}*/
	
	
	
	
	//jquery and json code to receive form data
 	@ResponseBody
	@RequestMapping (value = "save" , method = RequestMethod.POST )
	public ModelAndView save (@ModelAttribute EmployeeDetails employeeDetails) {
		List<EmployeeDetails> employeeDetailsList = new ArrayList<EmployeeDetails>();	
		
		employeeService.insertEmployeeDetails(employeeDetails);
		employeeDetailsList.add(employeeDetails);
	
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewemp");
		return mv;
		
	}

	
	
	
	
	
	
	
	@RequestMapping(value={"viewemp", "editemp/viewemp"})
	public ModelAndView viewemp() {
		ModelAndView mv = new ModelAndView();
		List<EmployeeDetails> employeeDetailsList = employeeService.getEmployeeDetails();

		mv.addObject("employeeDetailsList", employeeDetailsList);
		mv.setViewName("viewemp");
		return mv;

	}

	@RequestMapping(value = "deleteemp/{id}")
	public ModelAndView delete(@PathVariable int id) {
		employeeService.deleteEmployeeDetails(id);
		ModelAndView mv = new ModelAndView();
		List<EmployeeDetails> employeeDetailsList = employeeService.getEmployeeDetails();

		mv.addObject("employeeDetailsList", employeeDetailsList);
		mv.setViewName("viewemp");
		return mv;

	}

	@RequestMapping(value = "editemp/{id}")
	public ModelAndView edit(@PathVariable int id) {

		ModelAndView mv = new ModelAndView();
		List<EmployeeDetails> employeeDetailsList = employeeService.updateEmployeeDetails(id);

		mv.addObject("employeeDetailsList", employeeDetailsList);
		mv.setViewName("empeditform");
		return mv;

	}
	
/*	@RequestMapping(value = "editemp/save" )
	public ModelAndView edit(@RequestParam int id, @RequestParam String name, @RequestParam float salary,
			@RequestParam String designation) {

		ModelAndView mv = new ModelAndView();
		List<EmployeeDetails> employeeDetailsList = employeeService.updateData(id, name, designation, salary);

		mv.addObject("employeeDetailsList", employeeDetailsList);
		mv.setViewName("viewemp");
		return mv;

	}*/
	
	@RequestMapping(value={"editemp/save"})
	public String editemp(@ModelAttribute() EmployeeDetails employeeDetails )  {
		 
		employeeService.updateData(employeeDetails);
		//addAttribute("employeeDetailsList", employeeDetailsList);
		return "redirect:/viewemp";
	}
	

}
