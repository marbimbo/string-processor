package org.misio;

import org.misio.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final RestClient restClient;

    @Autowired
    public ConsoleApplication(final RestClient restClient) {
        this.restClient = restClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOG.info("Running");
        LOG.info("Enter string:");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            LOG.info(restClient.getPairResponse(scanner.nextLine()).toString());
            LOG.info("Enter string:");
        }
    }
}
