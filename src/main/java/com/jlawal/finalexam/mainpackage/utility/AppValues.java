package com.jlawal.finalexam.mainpackage.utility;

public enum AppValues {
    HOME_PAGE("home/index"), VIEW_CITIZENS_PAGE("citizens/list"), NEW_CITIZEN_PAGE("citizens/new"),
    SITE_ROOT("home"), CITIZEN_SORT_BY("lastName"),
    STATE_SORT_BY("stateName"), ENTRIES_PER_PAGE(5), SITE_NAME("wakanda"),
    REDIRECT("redirect:");

    private String val;
    private int iVal;

    AppValues(String string) {
        this.val = string;
    }

    AppValues(int iVal) {
        this.iVal = iVal;
    }

    public String val(String... appendable) {
        StringBuilder value = new StringBuilder(this.val);
        for (String string : appendable) {
            value.append("/").append(string);
        }
        return value.toString();
    }

    public int iVal() {
        return this.iVal;
    }
}
