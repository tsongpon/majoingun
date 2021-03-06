package com.abctechthailand.majoingun.web.admin;

import com.abctechthailand.majoingun.web.transport.ErrorResponseTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice(annotations = RestController.class)
public class ErrorController {
    private static Logger log = LoggerFactory.getLogger(ErrorController.class);

    /**
     *
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public String handleBadRequestFromSpring(HttpServletResponse response,
                                                             HttpMessageNotReadableException ex) throws IOException {
        log.error("Got exception bad request", ex);
        ErrorResponseTransport errorResponseTransport = new ErrorResponseTransport();
        //errorResponseTransport.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponseTransport.setError("All fields are required");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return "All fields are required";
    }

    @ExceptionHandler(MappingException.class)
    @ResponseBody
    public ErrorResponseTransport handleMappingException(HttpServletResponse response,
                                                             MappingException ex) throws IOException {
        log.error("Got exception bad request", ex);
        ErrorResponseTransport errorResponseTransport = new ErrorResponseTransport();
        //errorResponseTransport.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponseTransport.setError("error");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return errorResponseTransport;
    }

    @ExceptionHandler(MailSendException.class)
    @ResponseBody
    public ErrorResponseTransport handleMailSendException(HttpServletResponse response,
                                                            MailSendException ex) throws IOException {
        log.error("Got exception internal server error", ex);
        ErrorResponseTransport errorResponseTransport = new ErrorResponseTransport();
        //errorResponseTransport.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponseTransport.setError("error");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        return errorResponseTransport;
    }
}
