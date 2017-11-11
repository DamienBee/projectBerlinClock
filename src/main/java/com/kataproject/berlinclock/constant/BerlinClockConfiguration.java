package com.kataproject.berlinclock.constant;

public class BerlinClockConfiguration {

	public static final int	NUMBER_HOUR_BLOCKS					= 4;
	public static final int	NUMBER_MINUTE_BLOCKS				= 5;
	public static final int	NUMBER_OF_SECONDS_FOR_ACTIVATION	= 2;

	public static final int	MAX_HOUR_BLOCKS		= 23 / NUMBER_HOUR_BLOCKS;
	public static final int	MAX_MINUTE_BLOCKS	= 59 / NUMBER_MINUTE_BLOCKS;

	public static final int	MAX_LAST_HOURS		= 23 % NUMBER_HOUR_BLOCKS;
	public static final int	MAX_LAST_MINUTES	= 59 % NUMBER_MINUTE_BLOCKS;
}
