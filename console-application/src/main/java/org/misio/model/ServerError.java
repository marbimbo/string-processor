package org.misio.model;

import org.springframework.http.HttpStatus;

public class ServerError implements PairResponse {

    private HttpStatus statusCode;

    public ServerError(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ServerError{" +
                "statusCode=" + statusCode +
                '}';
    }
}
