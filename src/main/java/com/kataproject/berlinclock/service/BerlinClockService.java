package com.kataproject.berlinclock.service;

import com.kataproject.berlinclock.dto.BerlinClock;
import com.kataproject.berlinclock.exception.BerlinClockException;

/**
 * Converts a time to Berlin Clock
 */
public interface BerlinClockService {

	public BerlinClock convertTimeToBerlinClock(String standardTime) throws BerlinClockException;
}
