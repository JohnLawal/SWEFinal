package com.jlawal.finalexam.mainpackage.utility;

import java.util.HashMap;
import java.util.Map;

public class AppHelper {
   public static final Map<String, String> pageLinks = new HashMap<String, String>() {
        {
            put("siteRoot", '/' + AppValues.SITE_NAME.val(AppValues.SITE_ROOT.val()));
            put("viewCitizens", '/' + AppValues.SITE_NAME.val(AppValues.VIEW_CITIZENS_PAGE.val()));
            put("registerCitizen", '/' + AppValues.SITE_NAME.val(AppValues.NEW_CITIZEN_PAGE.val()));
        }
    };

}
