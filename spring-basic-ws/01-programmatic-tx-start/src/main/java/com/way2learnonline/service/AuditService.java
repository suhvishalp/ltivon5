package com.way2learnonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class AuditService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PlatformTransactionManager txManager;
		
	
	public void writeAuditLog(String message){
		
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus status =  txManager.getTransaction(definition);
		
		System.out.println("in writeAudiglog() = is new transaction = " + status.isNewTransaction());

			try {
			
				String query="insert into auditlogs(logmessage) values(?) ";			
				jdbcTemplate.update(query,message);
				txManager.commit(status);
			}catch (Exception e) {
				// TODO: handle exception
				txManager.rollback(status);
			}
			
		
	}

}
