package com.ap.api.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonCommonResponse implements Serializable {
    private static final long serialVersionUID = -4697882415613913505L;
	public Object uniqueId;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    public String status;
    public String error;
    public String exception;
   // List<Map<String, Object>> errors;
    String errors;
    public String message;
    public String path;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    public String dateTime;
    public Object details;


    public PageSettings pages;
}
