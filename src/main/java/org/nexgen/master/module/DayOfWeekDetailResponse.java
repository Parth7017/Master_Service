package org.nexgen.master.module;

public class DayOfWeekDetailResponse {
    private String dayName;
    private String dayShortName;

    public DayOfWeekDetailResponse(String dayName, String dayShortName) {
        this.dayName = dayName;
        this.dayShortName = dayShortName;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDayShortName() {
        return dayShortName;
    }

    public void setDayShortName(String dayShortName) {
        this.dayShortName = dayShortName;
    }
}
