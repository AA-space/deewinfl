package com.business.controller.vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.ProjVote;
import com.business.service.BaseService;
import com.kernal.utils.DateUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * @author 徐云龙
 * @date 2013-4-11上午10:55:13
 * @info 投票处理的Action
 * @Copyright 
 * Tenwa
 */
@Controller(value="VoteController")
@RequestMapping(value="/**/leasing")
public class VoteController {
	
	@Resource(name = "baseService")
	private BaseService baseService;
	
	
	@RequestMapping(value="/vote/getCurrentCustVote.action")
	@ResponseBody
	public String getCurrentCustVote(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);//把请求数据转成map
	    String currentTaskId=modelData.get("currentTaskId");
	    User user   =  (User)SecurityUtil.getPrincipal();
	    List<ProjVote> vote=new ArrayList<ProjVote>();
	    Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("workFLowUnid", currentTaskId); 
		queryMainObjectMap.put("creator", user); 
	    vote=baseService.findEntityByProperties(ProjVote.class, queryMainObjectMap);
	    ProjVote v;
	    if(vote.size()>0){
	    	v=vote.get(0);
	    	String vStr="";
	    	vStr="{id:'"+v.getId()+"',voteCommonent:'"+v.getVoteCommonent()+"',voteGrade:'"+v.getVoteGrade()+"',voteTypeid:'"+v.getVoteType().getId()+"',voteTypename:'"+v.getVoteType().getName()+"'}";
	    	return vStr;
	    }
	    else{
	    	return "";
	    }
	}
	@RequestMapping(value="/vote/saveOrUpdateVote.action")
	@ResponseBody
    public String saveOrUpVotegetCurrentCustVote(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);//把请求数据转成map
    	ProjVote vo;
    	DictionaryData dictd;
    	ProjInfo projInfo;
    	HashMap<String,Object>propertiesMap=new HashMap<String,Object>();
    	User user    =  (User)SecurityUtil.getPrincipal();
    	propertiesMap.put("projId", modelData.get("projid"));
    	projInfo=(ProjInfo)this.baseService.findEntityByProperties(ProjInfo.class, propertiesMap).get(0);
    	dictd=(DictionaryData)baseService.findEntityByID(DictionaryData.class, modelData.get("vtypeid"));
    	String voteid="";
    	if(modelData.containsKey("id")){
    		if(modelData.get("id")!=null){voteid=modelData.get("id");}
    	}
	    if("".equals(voteid) || "null".equals(voteid)){
	    	 
	    	vo=new ProjVote();
	    	vo.setProjId(projInfo);
	    	vo.setFlowName(modelData.get("flowName"));
	    	vo.setWorkFLowUnid(modelData.get("taskId"));
	    	vo.setVoteCommonent(modelData.get("commtent"));
	    	vo.setVoteGrade(modelData.get("grade"));
	    	vo.setVoteType(dictd);
	    	vo.setCreator(user);
	    	vo.setCreateDate(DateUtil.getSystemDateTime());
	    	this.baseService.saveEntity(vo);
	    }
	    else{
	    	 
	    	vo=(ProjVote)baseService.findEntityByID(ProjVote.class, modelData.get("id"));
	    	vo.setVoteCommonent(modelData.get("commtent"));
	    	vo.setVoteGrade(modelData.get("grade"));
	    	vo.setVoteType(dictd);
	    	vo.setModificator(user);
	    	vo.setModifyDate(DateUtil.getSystemDateTime());
	    	this.baseService.updateEntity(dictd);
	    }
	    return null;
	}
    
	@RequestMapping(value="/vote/getAllVote.action")
	@ResponseBody
   public String getVoteStatistics(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);//把请求数据转成map
	    String currentTaskId=modelData.get("currentTaskId");
	    List<ProjVote> vote=new ArrayList<ProjVote>();
	    Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("workFLowUnid", currentTaskId); 
	    vote=baseService.findEntityByProperties(ProjVote.class, queryMainObjectMap);
	    ProjVote v;
	    List vStr=new ArrayList<String>();
	    String temp="";
	    if(vote.size()>0){
	    	for(int i=0;i<vote.size();i++){
	           v=vote.get(i);
	           temp="{id:'"+v.getId()+"',voteCommonent:'"+v.getVoteCommonent()+"',voteGrade:'"+v.getVoteGrade()+"',voteTypeid:'"+v.getVoteType().getId()+"',voteTypename:'"+v.getVoteType().getName()+"',creator:'"+v.getCreator().getRealname()+"'}";
	           vStr.add(temp);
	    	}
	    	return vStr.toString();
	    }
	    else{
	    	return "";
	    }
   }   
	
	@RequestMapping(value="/vote/getAllVoteByProjId.action")
	@ResponseBody
   public String getAllVoteByProjId(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);//把请求数据转成map
	    String proj_id=modelData.get("projId");
	    String flow_name=modelData.get("flowName");
	    List<ProjInfo> Proj=new ArrayList<ProjInfo>();
	    Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("projId", proj_id); 
		Proj=this.baseService.findEntityByProperties(ProjInfo.class, queryMainObjectMap);
		queryMainObjectMap.clear();
		queryMainObjectMap.put("projId", Proj.get(0));
		queryMainObjectMap.put("flowName", flow_name);
		List<ProjVote> vote=new ArrayList<ProjVote>();
		vote=this.baseService.findEntityByProperties(ProjVote.class, queryMainObjectMap);
	    ProjVote v;
	    List vStr=new ArrayList<String>();
	    String temp="";
	    if(vote.size()>0){
	    	for(int i=0;i<vote.size();i++){
	           v=vote.get(i);
	           temp="{id:'"+v.getId()+"',voteCommonent:'"+v.getVoteCommonent()+"',voteGrade:'"+v.getVoteGrade()+"',voteTypeid:'"+v.getVoteType().getId()+"',voteTypename:'"+v.getVoteType().getName()+"',creator:'"+v.getCreator().getRealname()+"'}";
	           vStr.add(temp);
	    	}
	    	return vStr.toString();
	    }
	    else{
	    	return "";
	    }
   }   
}
