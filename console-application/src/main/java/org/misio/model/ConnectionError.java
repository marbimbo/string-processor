package org.misio.model;

public class ConnectionError implements PairResponse {

    private String message;

    public ConnectionError(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ConnectionError{" +
                "message='" + message + '\'' +
                '}';
    }
}
