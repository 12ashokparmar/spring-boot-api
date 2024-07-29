package com.ap.api.beans;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageSettings implements Serializable {

    private static final long serialVersionUID = -5397388799758090627L;
	private Integer totalPage;
    private Integer currentPage;
    private Integer currentRow;
    private Long totalElements;
    private Integer pageSize;
    private String direction;
    private String directionField;
    private String columnName;
    private String orderBy;
    private Boolean isLatPage;

}
