package com.business.service.cardhire;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.entity.base.BaseFile;
import com.business.entity.contract.reckon.fund.ContractFundRentInComeTemp;
import com.business.entity.contract.rent.ContractCardRentIncome;

public interface ContractCardHireService {
	/**
	 * 初始化实体和检查实体
	 * @param rentIncomeInfo  json数据集合
	 * @param uploadId 上传ID
	 * @return
	 * @throws Exception
	 */
     public List<ContractCardRentIncome> initCardHire(List<ContractCardRentIncome> card,Map<String,String> model) throws Exception;
     
     /**
      * 保存上传数据
      * @param incomeInfo
      * @return
      * @throws Exception
      */
     public boolean saveCardHireFile(List<ContractCardRentIncome> incomeInfo) throws Exception;
     
     /**
      * 根据上传的一条卡扣数据进行核销
      * @param ccri 一条卡扣到账数据
      * @param incomeList 根据卡扣到账数据生成回笼的数据用于传出
      * @param docId 流程实例ID
      * @return  如果核销中发生业务异常就返回消息
      * @throws Exception
      */
     public String addCardHireToIncome(ContractCardRentIncome ccri,List<ContractFundRentInComeTemp> incomeList,String docId,BaseFile baseFile)throws Exception;
     
     /**
      * 根据上传的一条卡扣数据进行核销
      * @param ccriList 一批卡扣到账数据
      * @param incomeList 根据卡扣到账数据生成回笼的数据用于传出
      * @param docId 流程实例ID
      * @return  如果核销中发生业务异常就返回消息
      * @throws Exception
      */
     public String addCardHireToIncomeByList(List<ContractCardRentIncome> ccriList,List<ContractFundRentInComeTemp> incomeList,String docId,BaseFile baseFile)throws Exception;
     
     /**
      * 删除一次卡扣核销的数据
      * @param cfrit
      * @return
      * @throws Exception
      */
     public String deleteCardHireToIncome(ContractFundRentInComeTemp cfrit)throws Exception;
     
     /**
      * 删除多条卡扣核销的数据
      * @param cfritList
      * @return
      * @throws Exception
      */
     public String deleteCardHireToIncomeByList(List<ContractFundRentInComeTemp> cfritList)throws Exception;
     
     /**
      * 保存核销数据
      * @param cfritList
      * @throws Exception
      */
     public void saveIncomeList(List<ContractFundRentInComeTemp> cfritList)throws Exception;

     /**
      * 卡扣数据上传Control
      * @param cfritList
      * @throws Exception
      */
     public String addUploadCardHire(HttpServletRequest request,HttpServletResponse response)throws Exception;
     
     public String addCardHireToIncome(Map<String,String> modeldata)throws Exception;
     
     public String deleteCardHireToIncomeControl(Map<String,String> modeldata)throws Exception;
}
