package com.kataproject.berlinclock.constant;

public class BerlinClockConfiguration {

	public static final int	NUMBER_HOUR_IN_BLOCKS				= 5;
	public static final int	NUMBER_MINUTE_IN_BLOCKS				= 5;
	public static final int	NUMBER_OF_SECONDS_FOR_ACTIVATION	= 2;

	public static final int	MAX_HOUR_BLOCKS		= 23 / NUMBER_HOUR_IN_BLOCKS;
	public static final int	MAX_MINUTE_BLOCKS	= 59 / NUMBER_MINUTE_IN_BLOCKS;

	public static final int	MAX_REMAINING_HOURS		= Math.max(	0,
																NUMBER_HOUR_IN_BLOCKS - 1);
	public static final int	MAX_REMAINING_MINUTES	= Math.max(	0,
																NUMBER_MINUTE_IN_BLOCKS - 1);
}
