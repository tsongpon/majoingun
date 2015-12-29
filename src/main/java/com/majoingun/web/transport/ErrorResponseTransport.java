package com.majoingun.web.transport;

import lombok.Data;

@Data
public class ErrorResponseTransport {
    private String error;
    private int status;
}
