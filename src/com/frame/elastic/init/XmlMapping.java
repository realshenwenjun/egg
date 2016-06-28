package com.frame.elastic.init;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlMapping")
public class XmlMapping implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4936050393316985454L;
	private String index;
	private String type;

	private String mappings;
	
	@XmlAttribute(name = "index")
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@XmlAttribute(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "mappings")
	public String getMappings() {
		return mappings;
	}

	public void setMappings(String mappings) {
		this.mappings = mappings;
	}

}
