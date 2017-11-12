package com.kataproject.berlinclock.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.kataproject.berlinclock.constant.BerlinClockConfiguration;
import com.kataproject.berlinclock.constant.BerlinClockSign;

public class BerlinClockTest {

	@Test
	public void timeShouldBeConvertedToCompleteBerlinClock() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.hasSecondActive(false)
													.withHourBlocks(1)
													.withRemainingHours(1)
													.withMinuteBlocks(1)
													.withRemainingMinutes(1)
													.build();

		char[] fullBerlinClockConversion = berlinClock	.toString()
														.toCharArray();

		assertThat(fullBerlinClockConversion.length).as("Berlin Clock length")
													.isEqualTo(1	+ BerlinClockConfiguration.MAX_HOUR_BLOCKS
																+ BerlinClockConfiguration.MAX_REMAINING_HOURS
																+ BerlinClockConfiguration.MAX_MINUTE_BLOCKS
																+ BerlinClockConfiguration.MAX_REMAINING_MINUTES);
		assertThat(fullBerlinClockConversion[0]).isEqualTo(BerlinClockSign.INACTIVE_SIGN.getValue());
		assertThat(fullBerlinClockConversion[1]).isEqualTo(BerlinClockSign.ALTERNATIVE_ACTIVE_SIGN.getValue());
		assertThat(fullBerlinClockConversion[5]).isEqualTo(BerlinClockSign.ALTERNATIVE_ACTIVE_SIGN.getValue());
		assertThat(fullBerlinClockConversion[9]).isEqualTo(BerlinClockSign.ACTIVE_SIGN.getValue());
		assertThat(fullBerlinClockConversion[20]).isEqualTo(BerlinClockSign.ACTIVE_SIGN.getValue());
	}

	@Test
	public void passedHourBlocksShouldBeConvertedToAlternativeActivatedSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withHourBlocks(1)
													.build();

		char[] hourBlocksConversion = berlinClock	.hourBlocksToString()
													.toCharArray();

		assertThat(hourBlocksConversion.length).isEqualTo(BerlinClockConfiguration.MAX_HOUR_BLOCKS);
		assertThat(hourBlocksConversion[0]).isEqualTo(BerlinClockSign.ALTERNATIVE_ACTIVE_SIGN.getValue());
	}

	@Test
	public void notPassedHourBlocksShouldBeConvertedToInactiveSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withHourBlocks(0)
													.build();

		char[] hourBlocksConversion = berlinClock	.hourBlocksToString()
													.toCharArray();

		assertThat(hourBlocksConversion.length).isEqualTo(BerlinClockConfiguration.MAX_HOUR_BLOCKS);
		assertThat(hourBlocksConversion[0]).isEqualTo(BerlinClockSign.INACTIVE_SIGN.getValue());
	}

	@Test
	public void passedRemainingHoursShouldBeConvertedToActiveSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withRemainingHours(1)
													.build();

		char[] remainingHoursConversion = berlinClock	.remainingHoursToString()
														.toCharArray();

		assertThat(remainingHoursConversion.length).isEqualTo(BerlinClockConfiguration.MAX_REMAINING_HOURS);
		assertThat(remainingHoursConversion[0]).isEqualTo(BerlinClockSign.ALTERNATIVE_ACTIVE_SIGN.getValue());
	}

	@Test
	public void notPassedRemainingHoursShouldBeConvertedToInactiveSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withRemainingHours(0)
													.build();

		char[] remainingHoursConversion = berlinClock	.remainingHoursToString()
														.toCharArray();

		assertThat(remainingHoursConversion.length).isEqualTo(BerlinClockConfiguration.MAX_REMAINING_HOURS);
		assertThat(remainingHoursConversion[0]).isEqualTo(BerlinClockSign.INACTIVE_SIGN.getValue());

	}

	@Test
	public void passedAndNotThirdMinuteBlocksShouldBeConvertedToAlternativeActivatedSign() {

		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withMinuteBlocks(1)
													.build();

		char[] minuteBlocksConversion = berlinClock	.minuteBlocksToString()
													.toCharArray();

		assertThat(minuteBlocksConversion.length).isEqualTo(BerlinClockConfiguration.MAX_MINUTE_BLOCKS);
		assertThat(minuteBlocksConversion[0]).isEqualTo(BerlinClockSign.ACTIVE_SIGN.getValue());
	}

	@Test
	public void passedThirdMinuteBlocksShouldBeConvertedToActivatedSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withMinuteBlocks(3)
													.build();

		char[] minuteBlocksConversion = berlinClock	.minuteBlocksToString()
													.toCharArray();

		assertThat(minuteBlocksConversion.length).isEqualTo(BerlinClockConfiguration.MAX_MINUTE_BLOCKS);
		assertThat(minuteBlocksConversion[2]).isEqualTo(BerlinClockSign.ALTERNATIVE_ACTIVE_SIGN.getValue());
	}

	@Test
	public void notPassedMinuteBlocksShouldBeConvertedToInactiveSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withMinuteBlocks(0)
													.build();

		char[] minuteBlocksConversion = berlinClock	.minuteBlocksToString()
													.toCharArray();

		assertThat(minuteBlocksConversion.length).isEqualTo(BerlinClockConfiguration.MAX_MINUTE_BLOCKS);
		assertThat(minuteBlocksConversion[10]).isEqualTo(BerlinClockSign.INACTIVE_SIGN.getValue());
	}

	@Test
	public void passedRemainingMinutesShouldBeConvertedToActiveSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withRemainingMinutes(1)
													.build();

		char[] remainingMinutesConversion = berlinClock	.remainingMinutesToString()
														.toCharArray();

		assertThat(remainingMinutesConversion.length).isEqualTo(BerlinClockConfiguration.MAX_REMAINING_MINUTES);
		assertThat(remainingMinutesConversion[0]).isEqualTo(BerlinClockSign.ACTIVE_SIGN.getValue());
	}

	@Test
	public void notPassedRemainingMinutesShouldBeConvertedToInactiveSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withRemainingMinutes(0)
													.build();

		char[] remainingMinutesConversion = berlinClock	.remainingMinutesToString()
														.toCharArray();

		assertThat(remainingMinutesConversion.length).isEqualTo(BerlinClockConfiguration.MAX_REMAINING_MINUTES);
		assertThat(remainingMinutesConversion[0]).isEqualTo(BerlinClockSign.INACTIVE_SIGN.getValue());

	}

	@Test
	public void secondActivatedShouldBeConvertedToActiveSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.hasSecondActive(true)
													.build();

		char[] secondConversion = berlinClock	.secondsToString()
												.toCharArray();

		assertThat(secondConversion.length).isEqualTo(1);
		assertThat(secondConversion[0]).isEqualTo(BerlinClockSign.ACTIVE_SIGN.getValue());
	}

	@Test
	public void secondInactiveShouldBeConvertedToInactiveSign() {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.hasSecondActive(false)
													.build();

		char[] secondConversion = berlinClock	.secondsToString()
												.toCharArray();

		assertThat(secondConversion.length).isEqualTo(1);
		assertThat(secondConversion[0]).isEqualTo(BerlinClockSign.INACTIVE_SIGN.getValue());

	}

}
