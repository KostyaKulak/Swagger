package com.kulak.swagger.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtils {
    public static <T> T fetchObject(final String relativePath, final Class<T> tClass) {
        ClassPathResource res = new ClassPathResource(relativePath);
        try {
            return new ObjectMapper().readValue(res.getFile(), tClass);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}