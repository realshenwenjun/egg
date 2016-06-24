package com.frame.elastic.core;

import java.io.Serializable;
import java.util.List;

public class Hits<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6236226096422860469L;
	private int total;
	private float max_score;
	private List<GetResponse<T>> hits;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getMax_score() {
		return max_score;
	}
	public void setMax_score(float max_score) {
		this.max_score = max_score;
	}
	public List<GetResponse<T>> getHits() {
		return hits;
	}
	public void setHits(List<GetResponse<T>> hits) {
		this.hits = hits;
	}
	
}
