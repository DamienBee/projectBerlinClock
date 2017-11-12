package com.kataproject.berlinclock.constant;

/**
 * Signs used in the textual equivalent of the Berlin Clock
 */
public enum BerlinClockSign {

	ACTIVE_SIGN('Y'),
	ALTERNATIVE_ACTIVE_SIGN('R'),
	INACTIVE_SIGN('O');

	private final char sign;

	BerlinClockSign(char sign) {
		this.sign = sign;
	}

	public char getValue() {
		return this.sign;
	}

}
