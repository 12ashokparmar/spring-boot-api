package com.ap.api.helper;

 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ap.api.beans.JsonCommonResponse;
import com.ap.api.beans.PageSettings;
import com.ap.api.utils.DateUtils;
import com.ap.api.utils.GlobalConstants;

import org.springframework.validation.BindingResult;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonCommonResponseHelper {


    public static JsonCommonResponse getJsonMastersResponse(Object object ,String path){

        JsonCommonResponse response = new JsonCommonResponse();
        response.setStatus(GlobalConstants.SUCCESS_STATUS);
        response.setDetails(object);
        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }

    public static JsonCommonResponse getJsonNodataFoundResponse(String path){

        JsonCommonResponse response = new JsonCommonResponse();
        response.setStatus("200");
        response.setDetails(GlobalConstants.FAIL_STATUS);
        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }

    public static JsonCommonResponse getPaginationJsonResponse(String jsonStr,  PageSettings pageSettings , String path){

        JsonCommonResponse response = new JsonCommonResponse();
        ObjectMapper map = new ObjectMapper();
        Map<String, Object> data = new HashMap<String, Object>();

        try {
            JsonNode jsonNode = map.readTree(jsonStr);
            response.setPages(pageSettings);
            response.setDetails(jsonNode);
            response.setMessage(GlobalConstants.DATA_FOUND);
            response.setStatus(GlobalConstants.SUCCESS_STATUS);

        } catch (JsonProcessingException e) {
            response.setDetails("");
            response.setStatus(GlobalConstants.FAIL_STATUS);
            response.setMessage(GlobalConstants.NO_DATA_FOUND);

        } catch (IOException e) {
            response.setDetails("");
            response.setStatus(GlobalConstants.FAIL_STATUS);
            response.setMessage(e.getMessage());
        }

        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }

    public static JsonCommonResponse getSuccessJsonMastersResponse(Integer pkId , String path){

        JsonCommonResponse response = new JsonCommonResponse();
        response.setMessage(GlobalConstants.SUCCESS_SAVE);
        response.setStatus(GlobalConstants.SUCCESS_STATUS);
        response.setUniqueId(pkId);
        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }

    public static JsonCommonResponse getUpdateSuccessJsonMastersResponse(Object pkId , String path){

        JsonCommonResponse response = new JsonCommonResponse();
        response.setMessage(GlobalConstants.SUCCESS_UPDATE);
        response.setStatus(GlobalConstants.SUCCESS_STATUS);
        response.setUniqueId(pkId);
        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }
    public static JsonCommonResponse getSuccessJsonMastersResponse(Object object ,String path){

        JsonCommonResponse response = new JsonCommonResponse();
        response.setMessage(GlobalConstants.SUCCESS_SAVE);
        response.setStatus(GlobalConstants.SUCCESS_STATUS);
        response.setDetails(object);
        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }
    public static JsonCommonResponse getErrorJsonMastersResponse(String path,String errorMsg,String errorStr){

        JsonCommonResponse response = new JsonCommonResponse();
        response.setException(errorStr);
        response.setError(errorMsg);
        response.setStatus(GlobalConstants.FAIL_STATUS);
        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }
    public static JsonCommonResponse getValidationErrorJsonMastersResponse(String path, BindingResult bindingResult){

        JsonCommonResponse response = new JsonCommonResponse();
       // List<> = BindingResultHelper.populateJsonValidationErrors(bindingResult);
        response.setErrors(BindingResultHelper.populateJsonValidationErrors(bindingResult));
        response.setException("InvalidDataException");
        response.setStatus(GlobalConstants.FAIL_STATUS);
        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }

    public static JsonCommonResponse getAutenticationFailedResponse(String path){

        JsonCommonResponse response = new JsonCommonResponse();
        response.setError("Full authentication is required to access this resource");
        response.setException("Unauthorized");
        response.setStatus("401");
        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }
    
    public static JsonCommonResponse getAlreadyExistDataJsonMastersResponse(Object object ,String path){

        JsonCommonResponse response = new JsonCommonResponse();
        response.setMessage(GlobalConstants.ALREADY_EXIST);
        response.setStatus(GlobalConstants.SUCCESS_STATUS);
        response.setDetails(object);
        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }
    
    public static JsonCommonResponse getDeleteSuccessJsonMastersResponse(Object pkId , String path){

        JsonCommonResponse response = new JsonCommonResponse();
        response.setMessage(GlobalConstants.SUCCESS_DELETE);
        response.setStatus(GlobalConstants.SUCCESS_STATUS);
        response.setUniqueId(pkId);
        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }

    public static JsonCommonResponse getDataFoundJsonResponse(String object ,String path){
        ObjectMapper map = new ObjectMapper();
        Map<String, Object> data = new HashMap<String, Object>();
        JsonCommonResponse response = new JsonCommonResponse();
        try {
            JsonNode jsonNode = null;
            jsonNode = map.readTree(object);
            response.setDetails(jsonNode);
        } catch (JsonProcessingException e) {
            response.setDetails("");
        }

        response.setStatus(GlobalConstants.SUCCESS_STATUS);
        response.setPath(path);
        response.setDateTime(DateUtils.getCurrentDateTime());
        return response;
    }
}
