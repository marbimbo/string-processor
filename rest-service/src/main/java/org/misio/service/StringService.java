package org.misio.service;

import org.misio.model.StringIntegerPair;
import org.misio.repository.PairRepository;
import org.misio.service.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Optional;

@Service
public class StringService {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final PairRepository pairRepository;
    private final StringFileReader stringFileReader;
    private final NumberAssigner numberAssigner;

    @Autowired
    public StringService(final PairRepository pairRepository, StringFileReader stringFileReader, NumberAssigner numberAssigner) {
        this.pairRepository = pairRepository;
        this.stringFileReader = stringFileReader;
        this.numberAssigner = numberAssigner;
    }

    public Integer assignInteger(final String requestedString) throws IOException {
        Optional<StringIntegerPair> foundInteger = pairRepository.findById(requestedString);
        if (foundInteger.isPresent()) {
            LOG.info("Found {} in database", requestedString);
            return foundInteger.get().getValue();
        } else {
            if (stringFileReader.isPresent(requestedString)) {
                LOG.info("Found {} in file", requestedString);
                Integer value = numberAssigner.assignInteger(requestedString);
                return pairRepository.save(StringIntegerPair.of(requestedString, value)).getValue();
            } else {
                LOG.warn("String {} not found", requestedString);
                throw new NotFoundException("String not found");
            }
        }
    }
}
