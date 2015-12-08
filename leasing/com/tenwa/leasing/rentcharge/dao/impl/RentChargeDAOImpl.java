package com.tenwa.leasing.rentcharge.dao.impl;

import org.apache.log4j.Logger;

import com.kernal.utils.UUIDUtil;
import com.tenwa.leasing.bean.AdjustBean;
import com.tenwa.leasing.dao.Conn;
import com.tenwa.leasing.rentcharge.dao.RentChargeDAO;
import com.tenwa.leasing.util.DateTools;
import com.tenwa.leasing.util.NumTools;

public class RentChargeDAOImpl implements RentChargeDAO {

	static Logger	logger	= Logger.getLogger(RentChargeDAOImpl.class);
	public int addAjust(AdjustBean adb) throws Exception{
		Conn conn = new Conn();
		String sql = " INSERT INTO "+adb.getTable_name()+" ";
		sql += "   (id," + adb.getPk_clum1() + " ";
		sql += "," + adb.getPk_clum2() + " ";
		sql +=",onhire_id";
		sql +=",adjust_type";
		sql +=",start_list";
		sql +=",payday_adjust";
		sql +=",handling_charge";
		sql += ",income_number_year";
		sql +=",adjust_list";
		sql +=",year_rate";
		sql +=",interest_handling_charge";
		sql +=",corpus_overage";
		sql +=",dun_rent";
		sql +=",dun_penalty";
		sql +=",agreed_penalty";
		sql +=",other_out";
		sql +=",other_in";
		sql +=",asset_ownership";
		sql +=",contract_total";
		sql +=",creator_";
		sql +=",agreed_interest";
		sql +=",create_date";
		sql +=",modificator_";
		sql +=",modify_date";
		sql += ") ";
		sql += "VALUES('"+UUIDUtil.getUUID()+"',";
		sql += "'" + adb.getPk_clum_v1() + "',";
		sql += "'" + adb.getPk_clum_v2() + "',";
		if(adb.getOnHireId()==null||adb.getOnHireId().equals("")){
			sql +="NULL,";
		}else{
			sql += "'" + adb.getOnHireId() + "',";
		}
		if(adb.getAdjustType()==null){
			sql +="NULL,";
		}else{
			sql += "'" + adb.getAdjustType() + "',";
		}
		if(adb.getStartList()==null){
			sql +="NULL,";
		}else{
			sql += "'" + adb.getStartList() + "',";
		}
		if(adb.getPaydayAdjust()==null){
			sql +="NULL,";
		}else{
			sql += "'" + adb.getPaydayAdjust() + "',";
		}
		if(adb.getHandlingCharge()==null){
			sql +="NULL,";
		}else{
			sql += "'" + adb.getHandlingCharge() + "',";
		}
		if(adb.getIncomeNumberYear()==null){
			sql +="NULL,";
		}else{
			sql += "'" + adb.getIncomeNumberYear() + "',";
		}
		if(adb.getAdjustList()==null){
			sql +="NULL,";
		}else{
			sql += "'" + adb.getAdjustList() + "',";
		}
		if(adb.getYearRate()==null){
			sql +="NULL,";
		}else{
			sql += "'" + adb.getYearRate() + "',";
		}
		if(adb.getInterestHandlingCharge()==null){
			sql +="NULL,";
		}else{
			sql += "'" + NumTools.formatNumberDoubleScale(adb.getInterestHandlingCharge().toString(),2) + "',";
		}
		if(adb.getCorpusOverage()==null){
			sql +="NULL,";
		}else{
			sql += "'" + NumTools.formatNumberDoubleScale(adb.getCorpusOverage().toString(),2) + "',";
		}
		if(adb.getDunRent()==null){
			sql +="NULL,";
		}else{
			sql += "'" + NumTools.formatNumberDoubleScale(adb.getDunRent().toString() ,2)+ "',";
		}
		if(adb.getDunPenalty()==null){
			sql +="NULL,";
		}else{
			sql += "'" + NumTools.formatNumberDoubleScale(adb.getDunPenalty().toString(),2) + "',";
		}
		if(adb.getAgreedPenalty()==null){
			sql +="NULL,";
		}else{
			sql += "'" + NumTools.formatNumberDoubleScale(adb.getAgreedPenalty().toString(),2)+ "',";
		}
		if(adb.getOtherOut()==null){
			sql +="NULL,";
		}else{
			sql += "'" +NumTools.formatNumberDoubleScale( adb.getOtherOut().toString() ,2)+ "',";
		}
		if(adb.getOtherIn()==null){
			sql +="NULL,";
		}else{
			sql += "'" + NumTools.formatNumberDoubleScale(adb.getOtherIn().toString() ,2)+ "',";
		}
		if(adb.getAssetOwnership()==null){
			sql +="NULL,";
		}else{
			sql += "'" + adb.getAssetOwnership() + "',";
		}
		if(adb.getContractTotal()==null){
			sql +="NULL,";
		}else{
			sql += "'" + NumTools.formatNumberDoubleScale(adb.getContractTotal().toString(),2) + "',";
		}		
		if(adb.getCreator()==null){
			sql +="NULL,";
		}else{
			sql += "'" + adb.getCreator() + "',";
		}
		
		if(adb.getAgreedInterest()==null){
			sql +="NULL,";
		}else{
			sql += "'" + NumTools.formatNumberDoubleScale(adb.getAgreedInterest().toString(),2)+ "',";
		}
		
		sql += DateTools.getSystemDate(1)+",";
		if(adb.getModificator()==null){
			sql +="NULL,";
		}else{
			sql += "'" + adb.getModificator() + "',";
		}
		if(adb.getModificator()==null){
			sql +="NULL";
		}else{
			sql += DateTools.getSystemDate(1);
		}
		sql += ")";
		int ini=0;
		ini=conn.executeUpdate(sql,"变更表insert语句:" );
		return ini;
	}

	public void deleteAjust(AdjustBean adb) throws Exception{
		Conn conn = new Conn();
		String sql = " delete "+adb.getTable_name()+" where "+adb.getPk_clum1()+"='"
				+ adb.getPk_clum_v1() + "' and "+adb.getPk_clum2()+"='" + adb.getPk_clum_v2()+ "'";
		if(adb.getOnHireId()!=null&&!adb.getOnHireId().equals("")){
			sql+=" and onHire_id='"+adb.getOnHireId()+"'";
		}
		//logger.info( + sql);
		conn.executeUpdate(sql,"删除"+adb.getTable_name()+"：");
	}

}
