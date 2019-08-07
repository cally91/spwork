package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.bbs.model.FileVO;
import com.biz.bbs.service.AjaxFileService;

@RestController
@RequestMapping(value = "/ajax_file")
public class AjexController {

	@Autowired
	AjaxFileService aFService;
	
	@RequestMapping(value = "/files_up", method = RequestMethod.POST)
	public List<FileVO> files_up(MultipartHttpServletRequest files) {

		
		List<FileVO> fileVOList = aFService.uploads(files);
		
		return fileVOList;

	}
}
