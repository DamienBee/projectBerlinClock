package com.kataproject.berlinclock.dto;

public class BerlinClockBuilder {

	private int hourBlocks;
	private int remainingHours;
	private int minutesBlocks;
	private int remainingMinutes;
	private boolean isSecondActivated;

	public static BerlinClockBuilder aBerlinClock() {
		return new BerlinClockBuilder();
	}

	public BerlinClockBuilder withHourBlocks(int hourBlocks) {
		this.hourBlocks = hourBlocks;
		return this;
	}

	public BerlinClockBuilder withRemainingHours(int remainingHours) {
		this.remainingHours = remainingHours;
		return this;
	}

	public BerlinClockBuilder withMinuteBlocks(int minuteBlocks) {
		this.minutesBlocks = minuteBlocks;
		return this;
	}

	public BerlinClockBuilder withRemainingMinutes(int remainingMinutes) {
		this.remainingMinutes = remainingMinutes;
		return this;
	}

	public BerlinClockBuilder hasSecondActive(boolean secondActivated) {
		this.isSecondActivated = secondActivated;
		return this;
	}

	public BerlinClock build() {
		BerlinClock berlinClock = new BerlinClock();
		berlinClock.setHourBlocks(hourBlocks);
		berlinClock.setRemainingHours(remainingHours);
		berlinClock.setMinutesBlocks(minutesBlocks);
		berlinClock.setRemainingMinutes(remainingMinutes);
		berlinClock.setIsSecondActivated(isSecondActivated);

		return berlinClock;
	}
}
