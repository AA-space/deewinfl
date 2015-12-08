package com.tenwa.report;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entity")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLEntity {
	@XmlID
	private String id;
	
	@XmlElement(name="parent")
	@XmlIDREF
	private XMLEntity parentEntity;
	
	@XmlIDREF
	@XmlElementWrapper(name="children")
	@XmlElement(name="child")
	private Set<XMLEntity> children;

	public XMLEntity getParentEntity() {
		return parentEntity;
	}

	public void setParentEntity(XMLEntity parentEntity) {
		this.parentEntity = parentEntity;
	}

	public Set<XMLEntity> getChildren() {
		return children;
	}

	public void setChildren(Set<XMLEntity> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
