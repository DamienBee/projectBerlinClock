package com.kataproject.berlinclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kataproject.berlinclock.dto.BerlinClock;
import com.kataproject.berlinclock.exception.BerlinClockException;
import com.kataproject.berlinclock.service.BerlinClockService;

@RestController
@RequestMapping(value = "/berlin-clock")
public class BerlinClockController {

	@Autowired
	BerlinClockService berlinClockService;

	@RequestMapping(value = "/full-clock/{time}", method = RequestMethod.GET)
	@ResponseBody
	public String getBerlinClock(@PathVariable String time) throws BerlinClockException {
		BerlinClock berlinClock = berlinClockService.convertTimeToBerlinClock(time);

		return berlinClock.toString();
	}

	@RequestMapping(value = "/hour-blocks/{time}", method = RequestMethod.GET)
	@ResponseBody
	public String getHourBlocks(@PathVariable String time) throws BerlinClockException {
		BerlinClock berlinClock = berlinClockService.convertTimeToBerlinClock(time);

		return berlinClock.hourBlocksToString();
	}

	@RequestMapping(value = "/remaining-hours/{time}", method = RequestMethod.GET)
	@ResponseBody
	public String getRemainingHours(@PathVariable String time) throws BerlinClockException {
		BerlinClock berlinClock = berlinClockService.convertTimeToBerlinClock(time);

		return berlinClock.remainingHoursToString();
	}

	@RequestMapping(value = "/minute-blocks/{time}", method = RequestMethod.GET)
	@ResponseBody
	public String getMinuteBlocks(@PathVariable String time) throws BerlinClockException {
		BerlinClock berlinClock = berlinClockService.convertTimeToBerlinClock(time);

		return berlinClock.minuteBlocksToString();
	}

	@RequestMapping(value = "/remaining-minutes/{time}", method = RequestMethod.GET)
	@ResponseBody
	public String getRemainingMinutes(@PathVariable String time) throws BerlinClockException {
		BerlinClock berlinClock = berlinClockService.convertTimeToBerlinClock(time);

		return berlinClock.remainingMinutesToString();
	}

	@RequestMapping(value = "/seconds/{time}", method = RequestMethod.GET)
	@ResponseBody
	public String getSeconds(@PathVariable String time) throws BerlinClockException {
		BerlinClock berlinClock = berlinClockService.convertTimeToBerlinClock(time);

		return berlinClock.secondsToString();
	}
}
