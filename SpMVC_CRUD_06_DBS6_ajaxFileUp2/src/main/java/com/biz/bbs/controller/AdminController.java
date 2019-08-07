package com.biz.bbs.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@RequestMapping(value = "/system",method = RequestMethod.GET)
	public String admin_system(){
		
		return "home";
	}
	@RequestMapping(value = "/member",method = RequestMethod.GET)
	public String admin_member(){
		
		return "home";
	}
	@RequestMapping(value = "/bbs",method = RequestMethod.GET)
	public String admin_bbs(){
		
		return "home";
	}
}
