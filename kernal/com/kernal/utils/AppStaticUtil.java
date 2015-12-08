package com.kernal.utils;

/**
 * 常量字典
 * @author Jason
 * 2013-1-16
 */
public class AppStaticUtil {
	
	/**项目立项 */
	public static final Integer PROJ_APPROVAL =  1;
	/**项目信审 */
	public static final Integer PROJ_CREDIT = 11;
	/**项目复议 */
	public static final Integer PROJ_REPEAT = 12;
	/**项目信审通过(且有一个以上的有效下属合同)<BR>有效合同是指下属合同层中有合同状态为20到100之间的合同 */
	public static final Integer PROJ_TO_CONTRACT = 19;
	/** 项目撤销 */
	public static final Integer PROJ_CANCEL = 101;
	/** 项目否决 */
	public static final Integer PROJ_DENY = 102;
	
	
	/**合同审批第一步 */
	public static final Integer CONTRACT_APPROVAL_01 = 16;
	/**合同审批 */
	public static final Integer CONTRACT_APPROVAL = 21;
	/**合同设备验收 */
	public static final Integer CONTRACT_EQUIP_ACCEPTANCE = 22;
	/**合同起租 */
	public static final Integer CONTRACT_START = 31;
	/**合同结束 */
	public static final Integer CONTRACT_END = 201;
	/**合同撤销 */
	public static final Integer CONTRACT_CANCEL = 111;
	
	/** 流程完毕 */
	public static final Integer WORKFLOW_OFF = 0;
	/** 流程进行中 */
	public static final Integer WORKFLOW_ON = 1;
	
}
