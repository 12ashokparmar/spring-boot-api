package com.ap.api.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class BindingResultHelper {
    public static String /*List<Map<String, Object>>*/ populateJsonValidationErrors(BindingResult bindingResult){
        List<String> errors = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> errorMap = new HashMap<>();
        for (FieldError e : bindingResult.getFieldErrors()){
            errorMap = new HashMap<>();
            errorMap.put("errorType", "field");
            //String fieldName = e.getField().substring(e.getField().indexOf("[") + 1, e.getField().indexOf("]")).replace("_", "-");
            errorMap.put("field", e.getField());
            errorMap.put("message", e.getDefaultMessage());
            errorMap.put("code", e.getCode());

            try {
                String j = mapper.writeValueAsString(errorMap);
                log.info(j);
                errors.add(j);
            } catch (JsonProcessingException ex) {
                log.info("Binding Helper ... "+ex.getMessage());
            }

        }
        for (ObjectError e : bindingResult.getGlobalErrors()) {
            errorMap = new HashMap<>();
            errorMap.put("errorType", "global");
            errorMap.put("code", e.getCode());
            errorMap.put("message",e.getDefaultMessage());
          //  errors.add(errorMap);
            try {
                String j = mapper.writeValueAsString(errorMap);
                log.info(j);
                errors.add(j);
            } catch (JsonProcessingException ex) {
                log.info("Binding Helper ... "+ex.getMessage());
            }
        }

        try {
            return mapper.writeValueAsString(errors);
        } catch (JsonProcessingException e) {
           return "";
        }
    }
}
