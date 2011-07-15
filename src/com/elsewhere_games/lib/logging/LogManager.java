package com.elsewhere_games.lib.logging;

// Container Imports
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Logging Imports
import com.elsewhere_games.lib.logging.Appender;
import com.elsewhere_games.lib.logging.Level;
import com.elsewhere_games.lib.logging.Log;

public class LogManager {

	/*
	 * Singleton Pattern
	 */
	
	private static LogManager instance;
	
	/**
	 * <p>Class constructor.</p>
	 */
	private LogManager() {
		this.logs = new HashMap<String, Log>();
		
		this.cachedAppenders = new ArrayList<Appender>();
		this.cachedLevel = Level.WARN;
	}
	
	/**
	 * <p>Gets a reference to the single instance of the log manager.</p>
	 * 
	 * @return A reference to the single instance of the log manager.
	 */
	public static LogManager getInstance() {
		// Only create one instance, if necessary:
		if (LogManager.instance == null) {
			LogManager.instance = new LogManager();
		}
		
		return LogManager.instance;
	}
	
	/*
	 * Logs
	 */
	
	private Map<String, Log> logs;
	
	/**
	 * <p>Gets a reference to the log with the specified <code>logName</code>. 
	 * If a log with that name does not already exist, a new log is created.</p>
	 * 
	 * @param logName The name of the log to get a reference to.
	 * @return A log with the specified name.
	 */
	public Log getLog(final String logName) {
		// Add the log if it does not exits already:
		if (!this.logs.containsKey(logName)) {
			Log log = new Log(logName);
			
			// Add existing appenders:
			for (Appender appender : this.cachedAppenders) {
				log.addAppender(appender);
			}
			
			// Set to existing level:
			log.setLevel(this.cachedLevel);
			
			this.logs.put(logName, log);
		}
		
		return this.logs.get(logName);
	}
	
	/*
	 * Convenience Methods
	 */
	
	private List<Appender> cachedAppenders;
	
	/**
	 * <p>Adds the specified <code>appender</code> to all existing as well as
	 * future logs.</p>
	 * 
	 * @param appender The appender to add to existing and future logs.
	 */
	public void addAppender(final Appender appender) {
		// Add to current logs:
		for (Log log : this.logs.values()) {
			log.addAppender(appender);
		}
		
		// Save for future logs:
		this.cachedAppenders.add(appender);
	}
	
	/**
	 * <p>Removes all appenders from all logs. Also causes newly created logs to
	 * not have any appenders until a new one is added to this manager.</p>
	 */
	public void clearAppenders() {
		for (Log log : this.logs.values()) {
			log.clearAppenders();
		}
		
		this.cachedAppenders.clear();
	}
	
	private Level cachedLevel;
	
	/**
	 * <p>Sets the <code>level</code> for all existing as well as future logs.</p>
	 * 
	 * @param level The level to set for logs.
	 */
	public void setLevel(final Level level) {
		// Apply to current logs:
		for (Log log : this.logs.values()) {
			log.setLevel(level);
		}
		
		// Save for future logs:
		this.cachedLevel = level;
	}
}
