
 /**
 * 项目名称：    系统名称
 * 包名：              com.business.job
 * 文件名：         QuartzJobTest.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-2-21-上午11:00:16
 * Copyright：2013XX公司-版权所有
 **/

package com.business.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.business.entity.notice.SmsNotice;
import com.business.service.TableService;
import com.kernal.annotation.QuartzJob;
import com.kernal.utils.WebUtil;
import com.message.SendMessageUtil;


 /**
 * 类名称：     SMSSendJob
 * 类描述：     
 * 创建人：     mhy
 * 修改人：     mhy
 * 修改时间：2013-12-20 上午11:00:16
 * 修改备注：
 * @version 1.0.0
 **/
@QuartzJob(description="定时短信发送")
public class SMSSendJob implements Job {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private Log logger = LogFactory.getLog(this.getClass()); 
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		TableService tableService = (TableService)WebUtil.getApplicationContext().getBean("tableService");
		try {
			String hql = "from SmsNotice sms where noticeTime is not null and to_date(noticeTime,'yyyy-MM-dd HH24:mi:ss')<=sysdate and sendFlag=0";
			List<SmsNotice> smsNotices = tableService.findResultsByHSQL(hql);
			if(smsNotices != null && smsNotices.size() > 0){
				for(SmsNotice sms :smsNotices){
					String result = null;
					try {
						result = SendMessageUtil.sendMessage(sms.getPhoneNumber(), sms.getSmsContent());
					} catch (Exception e) {
						logger.error("短信发送任务执行失败。", e);
						result = "发送失败，发送遇到异常：" + e.getMessage();
					}
					sms.setSendResult(result);
					sms.setSendTime(sdf.format(new Date()));
					sms.setSendFlag(1);
					tableService.updateEntity(sms);
				}
			}
		} catch (Exception e) {
			logger.error("短信定时发送任务执行失败。", e);
		}
	}
}
