package com.elsewhere_games.lib.logging.mock;

import com.elsewhere_games.lib.logging.Appender;
import com.elsewhere_games.lib.logging.Level;
import com.elsewhere_games.lib.logging.Log;

/**
 *
 */
public class MockAppender implements Appender {

	//// Testing ////

	// Source

	private Log lastSource = null;

	/**
	 * <p>Gets the last log that was presented to this appender.</p>
	 *
	 * @return The log from which the last message written to this appender came.
	 */
	public final Log getLastSource() {
		return this.lastSource;
	}

	// Level

	private Level lastLevel = Level.NONE;

	/**
	 * <p>Gets the last level that was presented to this appender.</p>
	 *
	 * @return The level at which the last message was written to this appender.
	 */
	public final Level getLastLevel() {
		return this.lastLevel;
	}

	// Message

	private String lastMessage = "";

	/**
	 * <p>Gets the last message that was presented to this appender.</p>
	 *
	 * @return The last message written to this appender.
	 */
	public final String getLastMessage() {
		return this.lastMessage;
	}

	/**
	 * <p>Resets the last received components of this appender back to their
	 * defaults.</p>
	 */
	public void reset() {
		this.lastSource = null;
		this.lastLevel = Level.NONE;
		this.lastMessage = "";
	}

	//// Writing ////

	@Override
	public void write(Log source, Level level, String message) {
		this.lastSource = source;
		this.lastLevel = level;
		this.lastMessage = message;
	}
}
