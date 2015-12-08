package com.business.relationship.parse;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.business.entity.RelationMap;
import com.business.entity.Relationship;
import com.business.entity.User;
import com.business.service.BaseService;
import com.business.service.RelationService;
import com.kernal.utils.WebUtil;

public class RelationParserFactory {
	private static final Logger log = LoggerFactory.getLogger(RelationParserFactory.class);

	public static List<User> parser(User currentUser, String[] relationIds, BaseService baseService) {
		List<User> actorList = new ArrayList<User>();
		if(relationIds == null || relationIds.length ==0){
			return actorList;
		}
		RelationService relationService = WebUtil.getApplicationContext().getBean(RelationService.class);
		for(String relationId: relationIds){
			try {
				Relationship relation = relationService.findEntityByID(Relationship.class, relationId);
				if(relation.getRelationMaps() != null && relation.getRelationMaps().size() > 0){
					for(RelationMap rmap : relation.getRelationMaps()){
						RelationParser rp = null;
						switch(rmap.getParserClass()){
						case ADDRESS_PARSER:
							rp = new AddressRelationParser(baseService);
						default:
							break;
						
						}
						if(rp != null){
							actorList.addAll(rp.parser(currentUser,rmap));
						}
					}
				}
			} catch (DataAccessException e) {
				log.error("",e);
			} catch (Exception e) {
				log.error("",e);
			}
		}
		
		
		return actorList;
	}
}
