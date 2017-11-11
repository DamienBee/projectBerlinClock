package com.kataproject.berlinclock.dto;

public class BerlinClockBuilder {

	private int hourBlocks;
	private int lastHours;
	private int minutesBlocks;
	private int lastMinutes;
	private boolean isSecondActivated;

	public static BerlinClockBuilder aBerlinClock() {
		return new BerlinClockBuilder();
	}

	public BerlinClockBuilder withHourBlocks(int hourBlocks) {
		this.hourBlocks = hourBlocks;
		return this;
	}

	public BerlinClockBuilder withLastHours(int lastHours) {
		this.lastHours = lastHours;
		return this;
	}

	public BerlinClockBuilder withMinuteBlocks(int minuteBlocks) {
		this.minutesBlocks = minuteBlocks;
		return this;
	}

	public BerlinClockBuilder withLastMinutes(int lastMinutes) {
		this.lastMinutes = lastMinutes;
		return this;
	}

	public BerlinClockBuilder hasSecondActivated(boolean secondActivated) {
		this.isSecondActivated = secondActivated;
		return this;
	}

	public BerlinClock build() {
		BerlinClock berlinClock = new BerlinClock();
		berlinClock.setHourBlocks(hourBlocks);
		berlinClock.setLastHours(lastHours);
		berlinClock.setMinutesBlocks(minutesBlocks);
		berlinClock.setLastMinutes(lastMinutes);
		berlinClock.setIsSecondActivated(isSecondActivated);

		return berlinClock;
	}
}
