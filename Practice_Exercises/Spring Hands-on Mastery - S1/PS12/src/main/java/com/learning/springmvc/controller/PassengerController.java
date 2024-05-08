package com.learning.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springmvc.domain.Passenger;
import com.learning.springmvc.service.PassengerService;

@Controller("passengerController")
@Scope("request")
public class PassengerController {
	@Autowired
	@Qualifier("passengerService")
	private PassengerService passengerService;
	
	@RequestMapping(value = "/passengerform", method = RequestMethod.GET)
	public String showForm() {
		return "passengerform";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addPassenger(@ModelAttribute("passenger") Passenger passenger) {
		passengerService.insert(passenger);
		return "redirect:/index.jsp";
	}
	@RequestMapping(value = "/passengers", method = RequestMethod.GET)
	public ModelAndView getAllPassengers() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("listPassengers");
		List<Passenger> list= passengerService.getAllPassengers();
		mv.addObject("list",list);
		return mv;
		
	}
	

}
