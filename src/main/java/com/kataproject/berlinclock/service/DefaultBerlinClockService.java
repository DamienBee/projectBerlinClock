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
		berlinClock.setRemainingHours(convertRemainingHours(timeToConvert.getHour()));
		berlinClock.setMinutesBlocks(convertMinuteBlocks(timeToConvert.getMinute()));
		berlinClock.setRemainingMinutes(convertRemainingMinutes(timeToConvert.getMinute()));
		berlinClock.setIsSecondActivated(convertSeconds(timeToConvert.getSecond()));

		return berlinClock;
	}

	private int convertHoursBlocks(int hoursToConvert) {
		return hoursToConvert / BerlinClockConfiguration.NUMBER_HOUR_IN_BLOCKS;
	}

	private int convertRemainingHours(int hoursToConvert) {
		return hoursToConvert % BerlinClockConfiguration.NUMBER_HOUR_IN_BLOCKS;
	}

	private int convertMinuteBlocks(int minutesToConvert) {
		return minutesToConvert / BerlinClockConfiguration.NUMBER_MINUTE_IN_BLOCKS;
	}

	private int convertRemainingMinutes(int minutesToConvert) {
		return minutesToConvert % BerlinClockConfiguration.NUMBER_MINUTE_IN_BLOCKS;
	}

	private boolean convertSeconds(int secondsToConvert) {
		// No remainder means that seconds are activated
		return secondsToConvert % BerlinClockConfiguration.NUMBER_OF_SECONDS_FOR_ACTIVATION == 0;
	}

	private LocalTime convertTimeFormatToLocalTime(String standardTime) throws BerlinClockException {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(HH_MM_SS_FORMAT);
		LocalTime timeToConvert;

		try {
			timeToConvert = LocalTime.parse(standardTime,
											dateTimeFormatter);
		} catch (DateTimeParseException e) {
			throw new BerlinClockException(e);
		}

		return timeToConvert;
	}

}
