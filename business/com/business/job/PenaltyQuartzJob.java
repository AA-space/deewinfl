
 /**
 * 项目名称：    系统名称
 * 包名：              com.business.job
 * 文件名：         QuartzJobTest.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-2-21-上午11:00:16
 * Copyright：2013XX公司-版权所有
 **/

package com.business.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.business.service.penalty.PenaltyService;
import com.kernal.annotation.QuartzJob;
import com.kernal.utils.WebUtil;


 /**
 * 类名称：     QuartzJobTest
 * 类描述：     每天0:10执行，计算整体系统罚息
 * 创建人：     Administrator
 * 修改人：     Administrator
 * 修改时间：2013-2-21 上午11:00:16
 * 修改备注：
 * @version 1.0.0
 **/
@QuartzJob(description="罚息日处理")
public class PenaltyQuartzJob implements Job {

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		PenaltyService penaltyService = ((PenaltyService)WebUtil.getApplicationContext().getBean("penaltyService"));
		try {
			penaltyService.updatePenalty();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
