package com.kataproject.berlinclock.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Component;

import com.kataproject.berlinclock.constant.BerlinClockConfiguration;
import com.kataproject.berlinclock.dto.BerlinClock;
import com.kataproject.berlinclock.exception.BerlinClockException;

@Component
public class DefaultBerlinClockService implements BerlinClockService {

	private static final String HH_MM_SS_FORMAT = "HH:mm:ss";

	@Override
	public BerlinClock convertTimeToBerlinClock(String standardTime) throws BerlinClockException {
		LocalTime timeToConvert = convertTimeFormatToLocalTime(standardTime);
		BerlinClock berlinClock = new BerlinClock();

		berlinClock.setHourBlocks(convertHoursBlocks(timeToConvert.getHour()));
		berlinClock.setLastHours(convertLastHours(timeToConvert.getHour()));
		berlinClock.setMinutesBlocks(convertMinuteBlocks(timeToConvert.getMinute()));
		berlinClock.setLastMinutes(convertLastMinutes(timeToConvert.getMinute()));
		berlinClock.setIsSecondActivated(convertSeconds(timeToConvert.getSecond()));

		return berlinClock;
	}

	private int convertHoursBlocks(int hoursToConvert) {
		return 0;
	}

	private int convertLastHours(int hoursToConvert) {
		return 0;
	}

	private int convertMinuteBlocks(int minutesToConvert) {
		return minutesToConvert / BerlinClockConfiguration.NUMBER_MINUTE_BLOCKS;
	}

	private int convertLastMinutes(int minutesToConvert) {
		return 0;
	}

	private boolean convertSeconds(int secondsToConvert) {
		return false;
	}

	private LocalTime convertTimeFormatToLocalTime(String standardTime) throws BerlinClockException {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(HH_MM_SS_FORMAT);
		LocalTime timeToConvert;

		try {
			timeToConvert = LocalTime.parse(standardTime, dateTimeFormatter);
		} catch (DateTimeParseException e) {
			throw new BerlinClockException(e);
		}

		return timeToConvert;
	}

}
