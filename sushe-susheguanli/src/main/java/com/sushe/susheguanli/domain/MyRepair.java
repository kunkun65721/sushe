package com.sushe.susheguanli.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.sushe.common.annotation.Excel;
import com.sushe.common.core.domain.BaseEntity;

/**
 * 报修记录对象 my_repair
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public class MyRepair extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报修ID */
    private Long repairId;

    /** 房间ID */
    @Excel(name = "房间ID")
    private Long roomId;

    /** 报修学生ID */
    @Excel(name = "报修学生ID")
    private Long studentId;

    /** 报修类型 */
    @Excel(name = "报修类型")
    private String repairType;

    /** 报修描述 */
    @Excel(name = "报修描述")
    private String description;

    /** 报修图片 */
    @Excel(name = "报修图片")
    private String images;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 处理人 */
    @Excel(name = "处理人")
    private String handler;

    /** 处理结果 */
    @Excel(name = "处理结果")
    private String handleResult;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyDate;

    /** 处理日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handleDate;

    public void setRepairId(Long repairId) 
    {
        this.repairId = repairId;
    }

    public Long getRepairId() 
    {
        return repairId;
    }

    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }

    public void setRepairType(String repairType) 
    {
        this.repairType = repairType;
    }

    public String getRepairType() 
    {
        return repairType;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setImages(String images) 
    {
        this.images = images;
    }

    public String getImages() 
    {
        return images;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setHandler(String handler) 
    {
        this.handler = handler;
    }

    public String getHandler() 
    {
        return handler;
    }

    public void setHandleResult(String handleResult) 
    {
        this.handleResult = handleResult;
    }

    public String getHandleResult() 
    {
        return handleResult;
    }

    public void setApplyDate(Date applyDate) 
    {
        this.applyDate = applyDate;
    }

    public Date getApplyDate() 
    {
        return applyDate;
    }

    public void setHandleDate(Date handleDate) 
    {
        this.handleDate = handleDate;
    }

    public Date getHandleDate() 
    {
        return handleDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("repairId", getRepairId())
            .append("roomId", getRoomId())
            .append("studentId", getStudentId())
            .append("repairType", getRepairType())
            .append("description", getDescription())
            .append("images", getImages())
            .append("status", getStatus())
            .append("handler", getHandler())
            .append("handleResult", getHandleResult())
            .append("applyDate", getApplyDate())
            .append("handleDate", getHandleDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
