package com.dskj.enu;

public enum BusinessFileType {
	PHOTO("photo"), LOGO("logo"), COVER("cover"), CAROUSEL("carousel"), PROPAGATE(
			"propagate"), ANNOUNCEMENT("announcement"),CHILDACTIVITY("childActivity"), INFOBACK("infoback");
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private BusinessFileType(String type) {
		this.type = type;
	}

}
