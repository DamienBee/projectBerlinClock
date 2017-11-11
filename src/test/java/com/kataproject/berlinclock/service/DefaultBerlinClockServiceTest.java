package com.kataproject.berlinclock.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kataproject.berlinclock.dto.BerlinClock;
import com.kataproject.berlinclock.exception.BerlinClockException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultBerlinClockServiceTest {

	private final String WRONG_FORMAT_TIME = "25:00:00";
	private final String FIVE_MINUTES_TIME = "00:05:00";
	private final String MAX_MINUTES_TIME = "00:59:00";

	@Autowired
	DefaultBerlinClockService defaultBerlinClockService;

	@Test(expected = BerlinClockException.class)
	public void wrongFormatInputTimeShouldThrowABerlinClockException() throws BerlinClockException {
		defaultBerlinClockService.convertTimeToBerlinClock(WRONG_FORMAT_TIME);
	}

	@Test
	public void minutesShouldBeSplitIn5MinutesBlocks() throws BerlinClockException {
		BerlinClock berlinClockResult = defaultBerlinClockService.convertTimeToBerlinClock(FIVE_MINUTES_TIME);

		assertThat(berlinClockResult.getMinutesBlocks()).isEqualTo(1);
	}

	@Test
	public void max5MinBlocksShouldBe11() throws BerlinClockException {
		BerlinClock berlinClockResult = defaultBerlinClockService.convertTimeToBerlinClock(MAX_MINUTES_TIME);

		assertThat(berlinClockResult.getMinutesBlocks()).isEqualTo(11);
	}

}
