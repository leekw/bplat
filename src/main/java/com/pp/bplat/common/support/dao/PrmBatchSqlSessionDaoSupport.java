package com.pp.bplat.common.support.dao;

import static org.springframework.util.Assert.notNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DaoSupport;

import com.pp.bplat.common.exception.PartnerException;

/**
 * Prm Batch DaoSupport
 * <pre>
 * com.kt.prm.common.support.dao
 * PrmBatchSqlSessionDaoSupport.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : ags0688
 * @Date    : 2013. 1. 2. 오후 1:10:38
 * @Version : 1.0
 */
public class PrmBatchSqlSessionDaoSupport extends DaoSupport {
	
	private SqlSession sqlSession;
    
    @Autowired @Qualifier("batchSqlSessionFactory")
    public final void setSqlSessionFactory(SqlSessionFactoryBean sqlSessionFactory) {
        try {
            this.sqlSession = new SqlSessionTemplate(sqlSessionFactory.getObject(), ExecutorType.BATCH);
        } catch (Exception e) {
            throw new PartnerException(e);
        }
    }
    
    public final SqlSession getSqlSession() {
        return this.sqlSession;
    }

    @Override
    protected void checkDaoConfig() throws IllegalArgumentException {
        notNull(this.sqlSession, "Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required");
    }

}
