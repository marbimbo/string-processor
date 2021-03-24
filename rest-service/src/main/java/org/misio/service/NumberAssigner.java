package org.misio.service;

import org.springframework.stereotype.Component;

@Component
public class NumberAssigner {
    public Integer assignInteger(String requestedString) {
        return requestedString.hashCode();
    }
}
