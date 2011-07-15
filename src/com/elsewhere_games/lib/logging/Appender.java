package com.elsewhere_games.lib.logging;


/**
 * <p>The appender takes a log message from a log and sends it to its destination,
 * which can be a log file, the console, or any other form displaying or storing
 * log messages.</p>
 * 
 * <p>An appender does not filter logs based on level or source, the log to which
 * this appender is attached is in charge of that.</p>
 * 
 * @author Hans Pragt
 *
 */
public interface Appender {

	/**
	 * <p>Writes the specified <code>message</code> to this appender.</p>
	 * 
	 * @param source The log to which the message was sent.
	 * @param level The level at which the message was sent.
	 * @param message The messag of the log entry.
	 */
	public void write(final Log source, final Level level, final String message);
	
}
