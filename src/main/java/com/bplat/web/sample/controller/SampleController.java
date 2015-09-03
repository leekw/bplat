package com.bplat.web.sample.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bplat.common.annotation.MetadataRequest;
import com.bplat.common.annotation.MetadataResponse;
import com.bplat.common.domain.Common;
import com.bplat.common.domain.Result;

@Controller
public class SampleController {
	
	//http://localhost:8080/bplat/sample/list/get.json
	@MetadataResponse
	@RequestMapping(value = "/sample/list/get.{metadataType}", method = RequestMethod.GET)
	public List<Common> getSampleList(@PathVariable("metadataType") String metadataType) {
		List<Common> result = new ArrayList<Common>();
		Common temp = new Common();
		temp.setMaxRowSize(10);
		
		result.add(temp);
		
		return result;
	}
	
	//http://localhost:8080/bplat/sample/get.json?params={"maxRowSize":1}
	@MetadataResponse
	@RequestMapping(value ="/sample/get.{metadataType}", method = RequestMethod.GET)
	public Common getSample(@MetadataRequest Common param, @PathVariable("metadataType") String metadataType) throws IllegalAccessException, InvocationTargetException {
		
		Common result = new Common();
	
		BeanUtils.copyProperties(result, param);
		
		return result;
	}
	
	//http://localhost:8080/bplat/sample/add.json?params={"maxRowSize":1}
	@RequestMapping(value ="/sample/add.{metadataType}", method = RequestMethod.GET)
	public void add(@MetadataRequest Common param, @PathVariable("metadataType") String metadataType ,HttpServletRequest request) {
		System.out.println("common :" + param);
	}
	//http://localhost:8080/bplat/sample/list/add.json?params=[{"id":"111"}]
	@RequestMapping(value ="/sample/list/add.{metadataType}", method = RequestMethod.GET)
	public void adds(@MetadataRequest(listClass=Result.class) List<Result> param, @PathVariable("metadataType") String metadataType ,HttpServletRequest request) {
		System.out.println("result :" + param);
	}

}
