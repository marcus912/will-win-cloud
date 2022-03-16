package org.will.win.common.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * This config enables CORS settings
 */
@Configuration
@ConditionalOnProperty("will.win.cors.enabled")
public class WebCorsConfig extends WebMvcConfigurerAdapter {

  @Value("${will.win.cors.allowed-origins:}")
  private List<String> allowedOrigins;

  @Value("${will.win.cors.enabled:true}")
  private String corsEnabled;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    if (this.corsEnabled != null && !Boolean.parseBoolean(corsEnabled)) {
      logger.info("CORS is disabled");
      return;
    }
    logger.info("CORS is enabled");

    String[] allowed;
    if (allowedOrigins == null) {
      allowed = new String[]{"*"};
    } else {
      // remove blank strings
      allowed = allowedOrigins.stream()
        .filter(StringUtils::isNotBlank)
        // split the value with comma
        .flatMap(s -> Arrays.stream(s.split(",")))
        .toArray(String[]::new);
      if (allowed.length <= 0) {
        allowed = new String[]{"*"};
      }
    }
    registry.addMapping("/**")
      .allowedHeaders("Content-Type", "accept", "Origin",
        "DNT", "Keep-Alive", "User-Agent", "X-Requested-With", "If-Modified-Since",
        "Cache-Control", "Content-Range", "Range",
        "X-Forwarded-For",
        "Authorization",
        "Access-Control-Request-Method",
        "Access-Control-Request-Headers"
      )
      .exposedHeaders("Access-Control-Allow-Origin",
        "Access-Control-Allow-Credentials",
        "Message")
      .allowCredentials(false)
      .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS")
      .allowedOrigins(allowed);
  }

  private static Logger logger = LoggerFactory.getLogger(WebCorsConfig.class.getName());
}
