package com.ap.api.helper;

import com.ap.api.beans.PageSettings;

public class PaginationHelper {

//    public static PageSettings getPageSettings(PageSettings pageSettings){
//        if(pageSettings.getTotalPage() == null || pageSettings.getTotalPage() == 0) {
//            pageSettings.setIsLatPage(false);
//            pageSettings.setCurrentRow(0);
//            pageSettings.setCurrentPage(1);
//            int lastPageNumber = (int) (Math.ceil(pageSettings.getTotalElements() / pageSettings.getPageSize()));
//            if(lastPageNumber % 2 == 0) {
//                //pageSettings.setTotalPage(lastPageNumber - 1); // as per the web data table
//                pageSettings.setTotalPage(lastPageNumber + 1); // as per the web data table
//            }else {
//                pageSettings.setTotalPage(lastPageNumber);
//            }
//
//        }else{
//            /*if((pageSettings.getCurrentRow() + pageSettings.getPageSize() ) >= pageSettings.getTotalElements()){
//                pageSettings.setIsLatPage(true);
//            }*/
//
//            int currRow = (pageSettings.getCurrentPage() * pageSettings.getPageSize() ) + 1;// pageSettings.getCurrentRow() + 1; //(pageSettings.getCurrentRow() * pageSettings.getPageSize() + 1);
//            pageSettings.setCurrentRow(currRow);
//        }
//        return pageSettings;
//    }
    public static PageSettings getPageSettings(PageSettings pageSettings){
        if(pageSettings.getTotalPage() == null || pageSettings.getTotalPage() == 0) {
            pageSettings.setIsLatPage(false);
            pageSettings.setCurrentRow(0);

            pageSettings.setCurrentPage(1);
           // int lastPageNumber = (int) (Math.ceil(pageSettings.getTotalElements() / pageSettings.getPageSize()));
            double lastPageNumber = (double)pageSettings.getTotalElements() / (double) pageSettings.getPageSize();


            if(lastPageNumber % 2 != 0) {
                //pageSettings.setTotalPage(lastPageNumber - 1); // as per the web data table
                pageSettings.setTotalPage((int)lastPageNumber + 1); // as per the web data table
            }else {
                pageSettings.setTotalPage((int)lastPageNumber);
            }
            // SET LASST PAGE
            int currRow = (pageSettings.getCurrentPage() * pageSettings.getPageSize());

            int totEle = pageSettings.getTotalElements().intValue();
            int fVal = totEle - (currRow+pageSettings.getPageSize());
            if(fVal <=0){
                pageSettings.setIsLatPage(true);
            }else {
                pageSettings.setIsLatPage(false);
            }
        }else{
          //  pageSettings.setCurrentPage(pageSettings.getCurrentPage() - 1);
            pageSettings.setCurrentPage(pageSettings.getCurrentPage());

            double lastPageNumber = (double)pageSettings.getTotalElements() / (double) pageSettings.getPageSize();

            if(lastPageNumber % 2 != 0) {
                //pageSettings.setTotalPage(lastPageNumber - 1); // as per the web data table
                pageSettings.setTotalPage( (int)lastPageNumber + 1); // as per the web data table
            }else {
                pageSettings.setTotalPage( (int)lastPageNumber);
            }

            // SET LASST PAGE
           // System.out.println("---- "+pageSettings.getCurrentPage());
           // System.out.println("---- "+pageSettings.getTotalPage());
          //  int o = pageSettings.getTotalPage() - pageSettings.getCurrentPage();
           // System.out.println("---- dif "+o);
           /* if(o == 1) {
                pageSettings.setIsLatPage(true);
            }else{
                pageSettings.setIsLatPage(false);
            }*/

          // POSTGRESQL INTERNALLY HANDEL IT
             int currRow = (pageSettings.getCurrentPage() * pageSettings.getPageSize() ) + 1;// pageSettings.getCurrentRow() + 1; //(pageSettings.getCurrentRow() * pageSettings.getPageSize() + 1);
            // int currRow = (pageSettings.getCurrentPage() * pageSettings.getPageSize());
            pageSettings.setCurrentRow(currRow);

            int totEle = pageSettings.getTotalElements().intValue();
            int fVal = totEle - (currRow+pageSettings.getPageSize());
            if(fVal <=0){
                pageSettings.setIsLatPage(true);
            }else {
                pageSettings.setIsLatPage(false);
            }

        }
        return pageSettings;
    }
}
