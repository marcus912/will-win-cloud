package org.will.win.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * admin-service and authorization-service uses a different package structure. This class helps to setup the right JPA scanning.
 */
@Configuration
@EntityScan("org.will.win.persistence.entity")
@EnableJpaRepositories("org.will.win.persistence.repository")
public class PersistenceConfig {
}
