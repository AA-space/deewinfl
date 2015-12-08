package com.business.service.ebank;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.business.entity.asset.FundEbankData;
import com.business.entity.base.BaseFile;

public interface EbankService {
     public String addEbank(Map<String,String> model) throws Exception;
     public String addEbankLog(Map<String,String> model) throws Exception;
     public String updateEbank(Map<String,String> model) throws Exception;
     public String removeEbank(Map<String,String> model) throws Exception;
     public String checkLoadEbank(String ebankInfo,Map<String,String> model) throws Exception;
     public List<FundEbankData> uploadEbankFromFile(String ebankInfo,Map<String,String> model,BaseFile bf) throws Exception;
     public String insertEbankFromLoadFile(MultipartFile  multipartFile,Map<String,String> model)throws Exception;
     public String updateCancalEbank(Map<String,String> model)throws Exception;
	 //public String updateCustEbankData(String ebankId)throws Exception;
	 public String updateCustEbankData(String ebankId, Integer ebank_flag) throws Exception;
}
