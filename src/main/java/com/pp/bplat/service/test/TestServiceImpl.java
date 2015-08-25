package com.pp.bplat.service.test;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.bplat.dao.TestDao;

@Service("testService")
public class TestServiceImpl implements TestService {

	
	@Autowired
	TestDao testDao;
	
	@Override
	public List<HashMap<String, Object>> getJobParma() {
		// TODO Auto-generated method stub
		return testDao.selectTestTable();
	}

}
