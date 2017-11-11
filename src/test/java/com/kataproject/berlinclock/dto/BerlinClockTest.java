package com.kataproject.berlinclock.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.kataproject.berlinclock.constant.BerlinClockSign;

public class BerlinClockTest {

	@Test
	public void passedNotThirdMinuteBlocksShouldBeConvertedToAlternativeActivatedSign() {

		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withMinuteBlocks(2)
													.build();

		char[] minuteBlocksConversion = berlinClock	.minuteBlocksToString()
													.toCharArray();

		assertThat(minuteBlocksConversion[0]).isEqualTo(BerlinClockSign.ACTIVE_SIGN.getValue());
		assertThat(minuteBlocksConversion[1]).isEqualTo(BerlinClockSign.ACTIVE_SIGN.getValue());
	}

	@Test
	public void passedThirdMinuteBlocksShouldBeConvertedToActivatedSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withMinuteBlocks(3)
													.build();

		char[] minuteBlocksConversion = berlinClock	.minuteBlocksToString()
													.toCharArray();

		assertThat(minuteBlocksConversion[2]).isEqualTo(BerlinClockSign.ALTERNATIVE_ACTIVE_SIGN.getValue());
	}

	@Test
	public void notPassedMinuteBlocksShouldBeConvertedToInactiveSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withMinuteBlocks(10)
													.build();

		char[] minuteBlocksConversion = berlinClock	.minuteBlocksToString()
													.toCharArray();

		assertThat(minuteBlocksConversion[10]).isEqualTo(BerlinClockSign.INACTIVE_SIGN.getValue());
	}

}
