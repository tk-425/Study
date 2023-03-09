package com.springdemo.library.config;

import com.springdemo.library.model.Book;
import com.springdemo.library.model.Message;
import com.springdemo.library.model.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
    HttpMethod[] theUnsupportedActions = {
        HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH
    };

    // expose primary key ID
    config.exposeIdsFor(Book.class);
    config.exposeIdsFor(Review.class);
    config.exposeIdsFor(Message.class);

    disableHttpMethods(Book.class, config, theUnsupportedActions);
    disableHttpMethods(Review.class, config, theUnsupportedActions);
    disableHttpMethods(Message.class, config, theUnsupportedActions);

    // Configure CORS Mapping
    String theAllowedOrigins = "http://localhost:3000";
    cors.addMapping(config.getBasePath() + "/**")
        .allowedOrigins(theAllowedOrigins);
  }

  private void disableHttpMethods(Class<?> bookClass,
                                  RepositoryRestConfiguration config,
                                  HttpMethod[] theUnsupportedActions)
  {
    config.getExposureConfiguration()
        .forDomainType(bookClass)
        .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
        .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));
  }
}
