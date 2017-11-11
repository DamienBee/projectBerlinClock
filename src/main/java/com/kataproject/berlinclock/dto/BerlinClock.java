package com.kataproject.berlinclock.dto;

import java.io.Serializable;

import com.kataproject.berlinclock.constant.BerlinClockConfiguration;
import com.kataproject.berlinclock.constant.BerlinClockSign;

public class BerlinClock implements Serializable {

	private static final long serialVersionUID = 6606286414839175891L;

	private int		hourBlocks;
	private int		lastHours;
	private int		minuteBlocks;
	private int		lastMinutes;
	private boolean	isSecondActivated;

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

	public int getMinuteBlocks() {
		return minuteBlocks;
	}

	public void setMinutesBlocks(int minuteBlocks) {
		this.minuteBlocks = minuteBlocks;
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

	public String minuteBlocksToString() {
		StringBuilder convertedBerlinClock = new StringBuilder();

		for (int i = 0; i < BerlinClockConfiguration.MAX_MINUTE_BLOCKS; i++) {
			if (i < getMinuteBlocks()) {
				if (minuteBlockIsAlternativeSign(i)) {
					convertedBerlinClock.append(BerlinClockSign.ALTERNATIVE_ACTIVE_SIGN.getValue());
				} else {
					convertedBerlinClock.append(BerlinClockSign.ACTIVE_SIGN.getValue());
				}
			} else {
				convertedBerlinClock.append(BerlinClockSign.INACTIVE_SIGN.getValue());
			}
		}

		return convertedBerlinClock.toString();
	}

	private boolean minuteBlockIsAlternativeSign(int i) {
		return i % 3 == 2;
	}
}
