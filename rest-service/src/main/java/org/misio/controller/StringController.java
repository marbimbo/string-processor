package org.misio.controller;

import org.misio.model.StringIntegerPair;
import org.misio.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class StringController {

    private final StringService stringService;

    @Autowired
    public StringController(final StringService stringService) {
        this.stringService = stringService;
    }

    @GetMapping
    public StringIntegerPair getStringIntegerPair(@RequestParam("s") final String requestedString) throws IOException {
        return StringIntegerPair.of(requestedString, stringService.assignInteger(requestedString));
    }

}
