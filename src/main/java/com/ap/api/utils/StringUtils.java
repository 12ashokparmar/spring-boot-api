package com.ap.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class StringUtils {

    public static Character getStringToChar(String strVal) {

        try {
            return strVal.trim().charAt(0);
        } catch (Exception e) {
            return '-';
        }
    }

    public static String isNullString(Object obj) {

        try {
            return obj.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static Long isNullLong(Object object) {
        try {
            if (object == null) {
                return 0l;
            } else {
                return (long) object;
            }
        } catch (NullPointerException n) {
            return 0l;
        }
    }

    public static Integer isNullInt(Object object) {
        try {
            if (object == null) {
                return 0;
            } else {
                return (Integer) object;
            }
        } catch (NullPointerException n) {
            return 0;
        }
    }

    public static Date isNullDate(Object object) {
        try {

            if (object == null) {
                return new Date();
            } else {
                return (Date) object;
            }
        } catch (NullPointerException n) {
            return new Date();
        }
    }

    public static BigDecimal isNullBigDecimal(Object object) {
        try {
            if (object == null) {
                return new BigDecimal(0);
            } else {
                return (BigDecimal) object;
            }
        } catch (NullPointerException n) {
            return new BigDecimal(0);
        }
    }

    public static char isNullChar(Object object) {
        try {
            if (object == null) {
                return 'N';
            } else {
                return (char) object;
            }
        } catch (NullPointerException n) {
            return 'N';
        }
    }

    public static Double isNullDouble(Object object) {
        try {
            if (object == null) {
                return 0D;
            } else {
                return (Double) object;
            }
        } catch (NullPointerException n) {
            return 0D;
        }
    }

    public static Short isNullShort(Object object) {
        try {
            if (object == null) {
                return 0;
            } else {
                return (Short) object;
            }
        } catch (NullPointerException n) {
            return 0;
        }
    }


    public static BigInteger isNullBigInteger(Object object) {
        try {
            if (object == null) {
                return BigInteger.ZERO;
            } else {
                return new BigInteger(object.toString());
            }
        } catch (NullPointerException n) {
            return BigInteger.ZERO;
        }
    }

    public static String getJsonData(Object dataList){
        ObjectMapper mapp = new ObjectMapper();
        String json = null;
        try {
            json = mapp.writeValueAsString(dataList);
            return json;
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
