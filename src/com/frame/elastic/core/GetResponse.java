package com.frame.elastic.core;

import java.io.Serializable;

public class GetResponse<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5203794554183554945L;
	private String _index;
	private String _type;
	private String _id;
	private Integer _version;
	private Double _score;
	private Boolean found;
	private T _source;
	private Boolean created;
	public String get_index() {
		return _index;
	}
	public void set_index(String _index) {
		this._index = _index;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public Integer get_version() {
		return _version;
	}
	public void set_version(Integer _version) {
		this._version = _version;
	}
	public Double get_score() {
		return _score;
	}
	public void set_score(Double _score) {
		this._score = _score;
	}
	public Boolean getFound() {
		return found;
	}
	public void setFound(Boolean found) {
		this.found = found;
	}
	public T get_source() {
		return _source;
	}
	public void set_source(T _source) {
		this._source = _source;
	}
	public Boolean getCreated() {
		return created;
	}
	public void setCreated(Boolean created) {
		this.created = created;
	}
	
	
}
