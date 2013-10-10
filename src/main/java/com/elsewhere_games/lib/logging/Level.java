package com.elsewhere_games.lib.logging;

/**
 * <p>These are the different levels a log message can assume.</p>
 */
public enum Level {

	/**
	 * <p>Dummy value for testing.</p>
	 */
	NONE,

	/**
	 * <p>Severe degradation of user experience.</p>
	 */
	ERROR,

	/**
	 * <p>Used to provide a notification of problems which may become more
	 * catastrophic if allowed to persist.</p>
	 */
	WARN,

	/**
	 * <p>To track the state of an application in the logs.</p>
	 */
	INFO,

	/**
	 * <p>Messages which allow problems to be debugged, do not expect to find
	 * these messages in logs from released software.</p>
	 */
	DEBUG

}
