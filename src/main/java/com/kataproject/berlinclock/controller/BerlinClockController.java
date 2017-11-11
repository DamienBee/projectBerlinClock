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
@RequestMapping(value = "/berlinclock")
public class BerlinClockController {

	@Autowired
	BerlinClockService berlinClockService;

	@RequestMapping(value = "/minute-blocks/{time}", method = RequestMethod.GET)
	@ResponseBody
	public String getMinuteBlocks(@PathVariable String time) throws BerlinClockException {

		BerlinClock berlinClock = berlinClockService.convertTimeToBerlinClock(time);

		return berlinClock.minuteBlocksToString();
	}
}
