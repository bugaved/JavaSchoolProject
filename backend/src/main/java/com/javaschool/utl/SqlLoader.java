package com.javaschool.utl;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

public interface SqlLoader {

    default String load(String path) {
        Resource res = new ClassPathResource(path);
        try(InputStreamReader in = new InputStreamReader(res.getInputStream())) {
            return FileCopyUtils.copyToString(in);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex.getMessage(), ex);
        }
    }
}
