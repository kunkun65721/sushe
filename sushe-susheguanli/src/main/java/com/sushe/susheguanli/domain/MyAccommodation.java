package com.sushe.susheguanli.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.sushe.common.annotation.Excel;
import com.sushe.common.core.domain.BaseEntity;

/**
 * 住宿记录对象 my_accommodation
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public class MyAccommodation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 住宿ID */
    private Long accommodationId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long studentId;

    /** 房间ID */
    @Excel(name = "房间ID")
    private Long roomId;

    /** 床位号 */
    @Excel(name = "床位号")
    private Long bedNumber;

    /** 入住日期 */
    private Date checkInDate;

    /** 退宿日期 */
    private Date checkOutDate;

    /** 状态 */
    private String status;

    public void setAccommodationId(Long accommodationId) 
    {
        this.accommodationId = accommodationId;
    }

    public Long getAccommodationId() 
    {
        return accommodationId;
    }

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }

    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }

    public void setBedNumber(Long bedNumber) 
    {
        this.bedNumber = bedNumber;
    }

    public Long getBedNumber() 
    {
        return bedNumber;
    }

    public void setCheckInDate(Date checkInDate) 
    {
        this.checkInDate = checkInDate;
    }

    public Date getCheckInDate() 
    {
        return checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) 
    {
        this.checkOutDate = checkOutDate;
    }

    public Date getCheckOutDate() 
    {
        return checkOutDate;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("accommodationId", getAccommodationId())
            .append("studentId", getStudentId())
            .append("roomId", getRoomId())
            .append("bedNumber", getBedNumber())
            .append("checkInDate", getCheckInDate())
            .append("checkOutDate", getCheckOutDate())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
