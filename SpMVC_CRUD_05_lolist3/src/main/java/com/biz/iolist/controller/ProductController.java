package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.iolist.Model.ProductVO;
import com.biz.iolist.service.ProduchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProduchService pService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list(@RequestParam String p_name, Model model) {
	
		//List<ProductVO> proList = pService.selectAll();
		
		List<ProductVO> proList =pService.findByName(p_name);
		model.addAttribute("PRO_LIST",proList);
		log.debug("상품리스트");
		return"ajax_body/produst/list";
	}
}
