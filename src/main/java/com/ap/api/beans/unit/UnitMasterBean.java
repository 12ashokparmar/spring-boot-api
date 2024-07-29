package com.ap.api.beans.unit;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnitMasterBean implements Serializable {
    private Integer unitId;
    private String unitName;
    private String unitCode;
    private Integer stateId;
    private Integer districtId;
    private String districtName;
    private Integer typeId;
    private String typeName;
    private Integer hospitalId;
    private String hospitalName;
    private Integer yearId;
    private String year;
    private Integer createdBy;
    private Integer updatedBy;
    private Integer deletedBy;
    private String deleted="N";
    private Date createdDate;
    private Date updatedDate;
    private Date deletedDate;
    private String activeFlag="N";
}
