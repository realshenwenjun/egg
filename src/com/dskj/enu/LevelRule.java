package com.dskj.enu;

/*
 * 用户登录升级规则
 */
public enum LevelRule {
	LEVERAGE;
	private static int days = 30;

	public static int getLevel(int days){
		return days/LevelRule.days + 1;
	}
}
