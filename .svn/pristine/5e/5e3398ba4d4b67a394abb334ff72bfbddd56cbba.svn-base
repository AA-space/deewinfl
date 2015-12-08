
 /**
 * 项目名称：    系统名称
 * 包名：              com.business.email
 * 文件名：         EmailBase.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-12-2-上午11:52:27
 * Copyright：2013XX公司-版权所有
 **/

package com.business.entity.email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kernal.annotation.FieldName;


 /**
 * 类名称：     EmailBase
 * 类描述：     
 * 创建人：     Administrator
 * 修改人：     Administrator
 * 修改时间：2013-12-2 上午11:52:27
 * 修改备注：
 * @version 1.0.0
 **/
@FieldName(name="邮箱主机信息")
@Entity
@Table(name="T_EMAIL_CONFIG")
public class EmailConfig {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32,name="ID_")
    private String id ;
	@FieldName(name="邮箱主机")
	@Column(name="HOST_",nullable=false)
	private String  host;
	@FieldName(name="邮箱端口号")
	@Column(name="PORT_",nullable=false)
	private Integer port;
	@FieldName(name="邮箱发送者")
	@Column(name="FROM_USER_",nullable=false)
	private String  fromUser;
	@FieldName(name="邮箱发送者密码")
	@Column(name="FROM_USER_PASSWORD_",nullable=false)
	private String  fromUserPassword;
	@FieldName(name="邮箱发送者邮件地址")
	@Column(name="FROM_USER_EMAIL_ADDRESS_",nullable=false)
	private String  fromUserEmailAddress;
	@FieldName(name="邮箱发送者真实身份")
	@Column(name="FROM_USER_REAL_NAME_")
	private String  fromUserRealName;
	
	public String getId() {
		return id;
	}
	public String getHost() {
		return host;
	}
	public Integer getPort() {
		return port;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getFromUser() {
		return fromUser;
	}
	public String getFromUserPassword() {
		return fromUserPassword;
	}
	public String getFromUserEmailAddress() {
		return fromUserEmailAddress;
	}
	public String getFromUserRealName() {
		return fromUserRealName;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public void setFromUserPassword(String fromUserPassword) {
		this.fromUserPassword = fromUserPassword;
	}
	public void setFromUserEmailAddress(String fromUserEmailAddress) {
		this.fromUserEmailAddress = fromUserEmailAddress;
	}
	public void setFromUserRealName(String fromUserRealName) {
		this.fromUserRealName = fromUserRealName;
	}
}
