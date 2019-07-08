package com.biz.sp.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.sp.service.HelloService;

/*
 * 스프링아 지금부터Mycontroller를 네가 관리해 달라고 요청
 */
@Controller
public class Mycontroller {
	/*
	 * bean으로 설정된 클래스(객체)를 사용하도록 해달라
	 * 연결해달라
	 */
	
	@Autowired
	HelloService helloService;
	
	@RequestMapping(value = "aa",method = RequestMethod.GET)
	public String myHome(Model model) {
		LocalDate ld =LocalDate.now();
		LocalTime lt = LocalTime.now();
		model.addAttribute("date",ld.toString());
		model.addAttribute("time",lt.toString());
		String helloMsg =helloService.getHello();
		model.addAttribute("hello",helloMsg);
		return "aaHome";
	}
	/*
	 * /sp/stform으로 요청을 하면
	 * /views/stform를 보여주고
	 */
	@RequestMapping(value = "stform",method = RequestMethod.GET)
	public String st(Model model) {
		
		return"stform";
	}
	/*
	 *  stform 의 input 에 삽을 입력한후 전속을 누르면
	 *   /sp/st 요청에 데이터를 실어서 서버로 전송되면
	 *   각각 데이터를 st_name, st_tel 매개변수에서 받는다
	 */
	@RequestMapping(value = "st",method = RequestMethod.GET)
	public String st(String st_name, String st_tel,Model model) {
		System.out.println("여기는 ght수신하는곳");
		model.addAttribute("name", st_name);
		model.addAttribute("tel", st_tel);
		
		return"strhome";	
	}
	/*
	 *  입력 FORm 에서 method 를 post로 지정하면
	 *  
	 */
	@RequestMapping(value = "st",method = RequestMethod.POST)
	public String st_post(String st_name, String st_tel,Model model) {
		System.out.println("여기는 POST수신하는곳");
		model.addAttribute("name", st_name);
		model.addAttribute("tel", st_tel);
		
		return"strhome";
		
	}
}
