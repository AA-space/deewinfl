package com.business.service;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public interface RelationService extends BaseService  {
	public JSONArray listAllRelations() throws Exception;

	String getRelationMapTree() throws Exception;

	public JSONObject saveMapItem(String relationId,String mapId,String newMapName,String leftItemIds,String rightItemIds) throws Exception;

	public String getItems(String mapId);
	
	public void saveRelation(Map<String, String> model) throws Exception;
	
	public void saveMap(Map<String, String> model) throws Exception;
	
	public void removeRelation(String id,String type) throws Exception;
}
