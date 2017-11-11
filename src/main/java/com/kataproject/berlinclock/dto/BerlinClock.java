package com.kataproject.berlinclock.dto;

import java.io.Serializable;

public class BerlinClock implements Serializable {

	private static final long serialVersionUID = 6606286414839175891L;

	private int hourBlocks;
	private int lastHours;
	private int minutesBlocks;
	private int lastMinutes;
	private boolean isSecondActivated;

	public int getHourBlocks() {
		return hourBlocks;
	}

	public void setHourBlocks(int hourBlocks) {
		this.hourBlocks = hourBlocks;
	}

	public int getLastHours() {
		return lastHours;
	}

	public void setLastHours(int lastHours) {
		this.lastHours = lastHours;
	}

	public int getMinutesBlocks() {
		return minutesBlocks;
	}

	public void setMinutesBlocks(int minutesBlocks) {
		this.minutesBlocks = minutesBlocks;
	}

	public int getLastMinutes() {
		return lastMinutes;
	}

	public void setLastMinutes(int lastMinutes) {
		this.lastMinutes = lastMinutes;
	}

	public boolean isSecondActivated() {
		return isSecondActivated;
	}

	public void setIsSecondActivated(boolean isSecondActivated) {
		this.isSecondActivated = isSecondActivated;
	}
}
