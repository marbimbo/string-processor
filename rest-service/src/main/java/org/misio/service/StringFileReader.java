package org.misio.service;

import org.misio.service.exception.InternalServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

@Component
public class StringFileReader {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private String filename;

    @Value("${filename}")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Cacheable("requestedString")
    public boolean isPresent(String requestedString) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputStream = classloader.getResourceAsStream(filename);
             InputStream gzipStream = new GZIPInputStream(inputStream);
             Reader decoder = new InputStreamReader(gzipStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(decoder)) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                LOG.debug(line);
                if (line.equals(requestedString)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new InternalServerException("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new InternalServerException(e.getLocalizedMessage());
        }

        return false;
    }
}
