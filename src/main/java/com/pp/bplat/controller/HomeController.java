package com.pp.bplat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pp.bplat.common.annotation.Command;
import com.pp.bplat.common.domain.Common;
import com.pp.bplat.common.support.util.Constant;
import com.pp.bplat.service.test.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/index.json", method = RequestMethod.GET)
	public ModelAndView getOrgFactorValueList(
			@Command(key = "params") Common param,
			@PathVariable("metadataType") String metadataType,
			ModelAndView modelAndView, HttpServletRequest request) {
		
		List<Common> result = new ArrayList<Common>();
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("results", result);
		modelAndView.addObject(Constant.RequestKey.PARAM_KEY.getValue(), data);
		return modelAndView;
	}
	
}
