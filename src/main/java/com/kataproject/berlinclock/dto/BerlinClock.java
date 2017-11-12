package com.kataproject.berlinclock.dto;

import java.io.Serializable;

import com.kataproject.berlinclock.constant.BerlinClockConfiguration;
import com.kataproject.berlinclock.constant.BerlinClockSign;

public class BerlinClock implements Serializable {

	private static final long serialVersionUID = 6606286414839175891L;

	private int		hourBlocks;
	private int		remainingHours;
	private int		minuteBlocks;
	private int		remainingMinutes;
	private boolean	isSecondActivated;

	public int getHourBlocks() {
		return hourBlocks;
	}

	public void setHourBlocks(int hourBlocks) {
		this.hourBlocks = hourBlocks;
	}

	public int getRemainingHours() {
		return remainingHours;
	}

	public void setRemainingHours(int remainingHours) {
		this.remainingHours = remainingHours;
	}

	public int getMinuteBlocks() {
		return minuteBlocks;
	}

	public void setMinutesBlocks(int minuteBlocks) {
		this.minuteBlocks = minuteBlocks;
	}

	public int getRemainingMinutes() {
		return remainingMinutes;
	}

	public void setRemainingMinutes(int remainingMinutes) {
		this.remainingMinutes = remainingMinutes;
	}

	public boolean isSecondActivated() {
		return isSecondActivated;
	}

	public void setIsSecondActivated(boolean isSecondActivated) {
		this.isSecondActivated = isSecondActivated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder convertedBerlinClock = new StringBuilder();
		convertedBerlinClock.append(secondsToString());
		convertedBerlinClock.append(hourBlocksToString());
		convertedBerlinClock.append(remainingHoursToString());
		convertedBerlinClock.append(minuteBlocksToString());
		convertedBerlinClock.append(remainingMinutesToString());

		return convertedBerlinClock.toString();
	}

	public String hourBlocksToString() {
		StringBuilder convertedBerlinClock = new StringBuilder();

		for (int i = 0; i < BerlinClockConfiguration.MAX_HOUR_BLOCKS; i++) {
			if (i < getHourBlocks()) {
				convertedBerlinClock.append(BerlinClockSign.ALTERNATIVE_ACTIVE_SIGN.getValue());
			} else {
				convertedBerlinClock.append(BerlinClockSign.INACTIVE_SIGN.getValue());
			}
		}

		return convertedBerlinClock.toString();
	}

	public String remainingHoursToString() {
		StringBuilder convertedBerlinClock = new StringBuilder();

		for (int i = 0; i < BerlinClockConfiguration.MAX_REMAINING_HOURS; i++) {
			if (i < getRemainingHours()) {
				convertedBerlinClock.append(BerlinClockSign.ALTERNATIVE_ACTIVE_SIGN.getValue());
			} else {
				convertedBerlinClock.append(BerlinClockSign.INACTIVE_SIGN.getValue());
			}
		}

		return convertedBerlinClock.toString();
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

	public String remainingMinutesToString() {
		StringBuilder convertedBerlinClock = new StringBuilder();

		for (int i = 0; i < BerlinClockConfiguration.MAX_REMAINING_MINUTES; i++) {
			if (i < getRemainingMinutes()) {
				convertedBerlinClock.append(BerlinClockSign.ACTIVE_SIGN.getValue());
			} else {
				convertedBerlinClock.append(BerlinClockSign.INACTIVE_SIGN.getValue());
			}
		}

		return convertedBerlinClock.toString();
	}

	public String secondsToString() {
		if (isSecondActivated) {
			return Character.toString(BerlinClockSign.ACTIVE_SIGN.getValue());
		} else {
			return Character.toString(BerlinClockSign.INACTIVE_SIGN.getValue());
		}
	}

	private boolean minuteBlockIsAlternativeSign(int i) {
		return i % 3 == 2;
	}
}
