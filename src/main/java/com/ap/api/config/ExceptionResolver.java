package com.ap.api.config;

import com.ap.api.utils.DateUtils;
import com.ap.api.utils.GlobalConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Slf4j
@RestControllerAdvice
public class ExceptionResolver {
    @ExceptionHandler({NullPointerException.class, ArrayIndexOutOfBoundsException.class, NumberFormatException.class})
    public HashMap<String, String> handleException(HttpServletRequest request, Exception e) {

        log.error(" *** ExceptionResolver Exception "+e.getMessage());
       // e.printStackTrace();
        HashMap<String, String> response = new HashMap<>();
        response.put("error", e.getMessage());
        response.put("dateTime", DateUtils.getCurrentDateTime());
        response.put("status", GlobalConstants.FAIL_STATUS);
        return response;


    }

    @ExceptionHandler(RuntimeException.class)
    public HashMap<String, String> handleRuntimeException(HttpServletRequest request, RuntimeException e) {
        log.error(" *** RuntimeException "+e.getMessage());
        HashMap<String, String> response = new HashMap<>();
        response.put("error", e.getMessage());
        response.put("dateTime",DateUtils.getCurrentDateTime());
        response.put("status",GlobalConstants.FAIL_STATUS);
        return response;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public HashMap<String, String> handleNotFoundResourceException(HttpServletRequest request, NoHandlerFoundException e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Requested resource wasn't found on the server");
        return response;
    }
}
