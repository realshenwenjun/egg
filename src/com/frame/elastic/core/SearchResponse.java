package com.frame.elastic.core;

import java.io.Serializable;

public class SearchResponse<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4464997394085741384L;
	private long took;
	private boolean time_out;
	private Shards _shards;
	private Hits<T> hits;
	public long getTook() {
		return took;
	}
	public void setTook(long took) {
		this.took = took;
	}
	public boolean isTime_out() {
		return time_out;
	}
	public void setTime_out(boolean time_out) {
		this.time_out = time_out;
	}
	public Shards get_shards() {
		return _shards;
	}
	public void set_shards(Shards _shards) {
		this._shards = _shards;
	}
	public Hits<T> getHits() {
		return hits;
	}
	public void setHits(Hits<T> hits) {
		this.hits = hits;
	}
	
}
