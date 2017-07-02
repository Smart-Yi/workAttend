package com.program.attend.vo;

import com.program.common.page.PageQueryBean;

/**
 * Created by 匡小菜 on 2017/6/29.
 */
public class    QueryCondition extends PageQueryBean{

    private String startDate ;

    private String endDate   ;

    private Long userId ;

    private String rangeDate;

    private Byte attendStatus;

    public String getRangeDate() {
        return rangeDate;
    }

    public void setRangeDate(String rangeDate) {
        this.rangeDate = rangeDate;
    }

    public Byte getAttendStatus() {
        return attendStatus;
    }

    public void setAttendStatus(Byte attendStatus) {
        this.attendStatus = attendStatus;
    }



    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
