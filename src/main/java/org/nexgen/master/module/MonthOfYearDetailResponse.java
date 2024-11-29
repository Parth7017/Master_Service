package org.nexgen.master.module;

public class MonthOfYearDetailResponse {
    private String monthName;
    private String monthShortName;

    public MonthOfYearDetailResponse(String monthName, String monthShortName) {
        this.monthName = monthName;
        this.monthShortName = monthShortName;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getMonthShortName() {
        return monthShortName;
    }

    public void setMonthShortName(String monthShortName) {
        this.monthShortName = monthShortName;
    }
}
