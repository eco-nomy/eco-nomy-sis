package com.economy.infrastructure.config;

import fiap.sprint.application.service.ApiKeyValidator;
import fiap.sprint.infrastructure.security.ApiKeyValidatorImpl;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class SecurityConfig {

    @ApplicationScoped
    public ApiKeyValidator apiKeyValidator(@ConfigProperty(name = "api.key") String validApiKey) {
        return new ApiKeyValidatorImpl(validApiKey);
    }

}
