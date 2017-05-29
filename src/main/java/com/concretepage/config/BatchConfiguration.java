package com.concretepage.config;

import com.concretepage.model.FileConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by Srikanth on 5/26/2017.
 */
@Component
public class BatchConfiguration {
    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public FileConfiguration getFieldConfiguration() throws IOException {
        Resource resource = new ClassPathResource("config.json");
        File file = resource.getFile();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, FileConfiguration.class);
    }
}
