package org.nexgen.master.module;

public class HolidayCategoryResponse {
    private Integer id;
    private String holidayCategoryName;

    public HolidayCategoryResponse(Integer id, String holidayCategoryName) {
        this.id = id;
        this.holidayCategoryName = holidayCategoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHolidayCategoryName() {
        return holidayCategoryName;
    }

    public void setHolidayCategoryName(String holidayCategoryName) {
        this.holidayCategoryName = holidayCategoryName;
    }
}
