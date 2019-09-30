package com.estafet.microservices.scrum.basic.ui.config;

/**
 * Enum defining available service names.
 * @author Dennis Williams, Etsafet Ltd.
 *
 */
public enum ServiceName {

    /**
     * The project service.
     */
	PROJECT_SERVICE("project-api"),

    /**
     * The sprint service.
     */
	SPRINT_SERVICE("sprint-api"),

    /**
     * The story service.
     */
	STORY_SERVICE("story-api"),

    /**
     * The task service.
     */
	TASK_SERVICE("task-api"),

    /**
     * The health service for monitoring.
     */
	HEALTH_SERVICE("health-api");

    /**
     * The name of the service
     */
	private String  serviceName;

	/**
	 * Construct from a service name.
	 *
	 * @param theServiceName
	 *         The name of the service.
	 */
	private ServiceName(final String theServiceName) {
		serviceName = theServiceName;
	}

	/**
	 * @return the name of the service.
	 */
	public String getServiceName() {
		return serviceName;
	}
}
