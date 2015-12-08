/**
 * 项目名称：    系统名称
 * 包名：              com.business.job
 * 文件名：         QuartzJobTest.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-2-21-上午11:00:16
 * Copyright：2013XX公司-版权所有
 **/

package com.business.job;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.business.service.vouchersFactory.ContractOnHireService;
import com.business.serviceImpl.fileTemplate.FileTemplateServiceImp;
import com.kernal.annotation.QuartzJob;
import com.kernal.utils.DateUtil;
import com.kernal.utils.WebUtil;

/**
 * 类名称： QuartzJobTest 类描述： 创建人： Administrator 修改人： Administrator 修改时间：2013-2-21 上午11:00:16 修改备注：
 * 
 * @version 1.0.0
 **/
@QuartzJob(description = "指定日期导出卡扣数据")
@Transactional
public class CardHireInTime implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) WebUtil.getApplicationContext().getBean("transactionManager");

		DefaultTransactionDefinition def = new DefaultTransactionDefinition(); // new 一个事务
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED); // 初始化事务,参数定义事务的传播类型;
		TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
		try {
			System.out.println("开始");
			FileTemplateServiceImp fileTemplateService = (FileTemplateServiceImp) WebUtil.getApplicationContext().getBean("fileTemplateService");
			ContractOnHireService contractOnHireService = (ContractOnHireService) WebUtil.getApplicationContext().getBean("contractOnHireService");
			Map<String,String> model = new java.util.HashMap<String,String>();
			
			
/*			CONTRACT_STATUS_GreaterThan	30
CONTRACT_STATUS_LessThan	100
blankname	"card_hire_bank_construction"
dateInitMethod	"cardHire"
modelname	"wordtempletypetwo20"
rangeValue	"50000"
returnType	"list"
splitField	"ovrent"
sqlDataCallback	"cardDataCallback"
title	"建行卡扣"
twoClassify	"wordtempletypetwo20"*/
			model.put("CONTRACT_STATUS_GreaterThan", "30");
			model.put("CONTRACT_STATUS_LessThan", "100");
			model.put("modelname", "wordtempletypetwo20");
			model.put("dateInitMethod", "cardHire");
			model.put("rangeValue", "rangeValue");
			model.put("splitField", "ovrent");
			model.put("sqlDataCallback", "cardDataCallback");
			model.put("twoClassify", "wordtempletypetwo20");
			model.put("returnType", "file");
			model.put("plandate_end", DateUtil.getSystemDate());

			
			// 使用springAOP事物管理的service做一些事情
			try {
				
				//建行
				model.put("blankname", "card_hire_bank_construction");
				fileTemplateService.createFileByTemplateClass(model);
				
				//农行
				model.put("blankname", "card_hire_bank_agricultural");
				fileTemplateService.createFileByTemplateClass(model);
				
				
				
				transactionManager.commit(status); // 提交事务;
			} catch (Exception e) {
				transactionManager.rollback(status); // 回滚事务;
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
