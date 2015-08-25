package com.pp.bplat.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("TestDao")
public class TestDaoImpl extends SqlSessionDaoSupport implements TestDao {

	@Override
	public List<HashMap<String, Object>> selectTestTable() {
	
			// TODO Auto-generated method stub
			List<HashMap<String, Object>> testTableList = new ArrayList<HashMap<String, Object>>();
			List<String> dd = getSqlSession().selectList("test.selectTestTable");
//			String dd = getSqlSession().selectOne("test.selectTestTable");

//			try{
//				getSqlSession().selectList("test.selectTestTable");
//				
//			}catch(Exception e){
//				logger.debug(e.getMessage());
//			}
			
			
			
			return testTableList;
		}

}
