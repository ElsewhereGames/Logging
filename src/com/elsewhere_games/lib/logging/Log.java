package com.elsewhere_games.lib.logging;

import java.util.ArrayList;


public class Log {

	/*
	 * Constructors
	 */
	
	/**
	 * <p>Class constructor.</p>
	 * 
	 * @param name The name with which to identify this log.
	 */
	public Log(final String name) {
		this.name = name;
		
		this.appenders = new ArrayList<Appender>();
		this.level = Level.DEBUG;
	}
	
	/*
	 * Log Messages
	 */
	
	/**
	 * <p>Writes the <code>message</code> to this log at the debug level. If this
	 * log's level is set at the debug level or above, the message will be passed
	 * on to this log's appenders.</p>
	 * 
	 * @param message The message to write to this log.
	 */
	public void debug(final String message) {
		this.write(Level.DEBUG, message);
	}
	
	/**
	 * <p>Writes the <code>message</code> to this log at the debug level. If this
	 * log's level is set at the debug level or above, the message will be passed
	 * on to this log's appenders.</p>
	 * 
	 * @param message The message to write to this log.
	 */
	public void info(final String message) {
		this.write(Level.INFO, message);
	}
	
	/**
	 * <p>Writes the <code>message</code> to this log at the info level. If this
	 * log's level is set at the info level or above, the message will be passed
	 * on to this log's appenders.</p>
	 * 
	 * @param message The message to write to this log.
	 */
	public void warn(final String message) {
		this.write(Level.WARN, message);
	}
	
	/**
	 * <p>Writes the <code>message</code> to this log at the error level. If this
	 * log's level is set at the error level or above, the message will be passed
	 * on to this log's appenders.</p>
	 * 
	 * @param message The message to write to this log.
	 */
	public void error(final String message) {
		this.write(Level.ERROR, message);
	}
	
	private void write(final Level level, final String message) {
		if (level.ordinal() <= this.level.ordinal()) {
			for (Appender appender : this.appenders) {
				appender.write(this, level, message);
			}
		}
	}
	
	/*
	 * Appenders
	 */
	
	private ArrayList<Appender> appenders;
	
	/**
	 * <p>Adds the appender to this log's collection of appenders. Any message 
	 * sent to this log that meets the threshold will be written to the
	 * specified <code>appender</code>.</p>
	 * 
	 * @param appender The appender to add to this log.
	 */
	public void addAppender(final Appender appender) {
		this.appenders.add(appender);
	}
	
	/**
	 * <p>Removes the appender from this log's collection of appenders.</p>
	 * 
	 * @param appender The appender to remove from this log.
	 */
	public void removeAppender(final Appender appender) {
		this.appenders.remove(appender);
	}
	
	/**
	 * <p>Removes all appenders from this log's collection of appenders. In
	 * essence, this means that any message written to this log will not
	 * be routed to an output.</p>
	 */
	public void clearAppenders() {
		this.appenders.clear();
	}
	
	/*
	 * Accessors and Modifiers
	 */
	
	private String name;
	
	/**
	 * <p>Gets the name of this log, used to identify this log.</p>
	 * 
	 * @return The name of this log.
	 */
	public String getName() {
		return this.name;
	}
	
	private Level level;
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(final Level level) {
		this.level = level;
	}
}
