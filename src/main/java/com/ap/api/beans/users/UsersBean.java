package com.ap.api.beans.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersBean implements Serializable {

    private int user_ID;
    private String full_name;
    private String title;
    private String f_name;
    private String m_name;
    private String l_name;
    private String user_Name;
    private String user_Type;
    private String password;
    private String created_Date;
    private String availability;
    private String status;
    private Integer doctorId;
    private String last_loged_in_date_time;
    private String last_loged_out_date_time;
    private String current_loged_in_date_time;
    private String current_loged_out_date_time;
    private String softwareUsed;
    private int	dcTypeMasterID;
    private String  mulSelunit;
    private String  doctorTypeIdList;
    private String  mulDeptid; //@Name: Sagar Kadam @date:07/07/-2017 @reason: dept master
    private String  mulServiceid;  //@Name: Sagar Kadam @date:07/07/-2017 @reason: dept master
    private String empIdhr;
    private String logedInStatus;
    private Integer createdBy;
    private Integer updatedBy;
    private Date createdDate;
    private Date updatedDate;
    private String deleted="N";
    private Integer deletedBy;
    private Date deletedDate;
    private Integer unitId;
    private String sign_one;
    private String sign_one_doctor;
    private String sign_two;
    private String sign_two_doctor;
    private String allServicesFlag;
    private String addUserSign;
    private Integer distric_id;
	private String distname;
	private String unitName;
	private String specializationName;
	private String dashboardAllCountFlag;
	

}
