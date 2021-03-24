package org.misio.model;

import org.springframework.http.HttpStatus;

public class ClientError implements PairResponse {

    private HttpStatus statusCode;

    public ClientError(HttpStatus statusCode) {
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
        return "ClientError{" +
                "statusCode=" + statusCode +
                '}';
    }
}
