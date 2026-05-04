package com.sushe.susheguanli.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.sushe.common.annotation.Excel;
import com.sushe.common.core.domain.BaseEntity;

/**
 * 卫生检查记录对象 my_dormitory_inspection
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public class MyDormitoryInspection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 检查ID */
    private Long inspectionId;

    /** 房间ID */
    @Excel(name = "房间ID")
    private Long roomId;

    /** 检查人 */
    @Excel(name = "检查人")
    private String inspector;

    /** 检查日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "检查日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inspectionDate;

    /** 评分（0-100） */
    @Excel(name = "评分", readConverterExp = "0=-100")
    private Long score;

    public void setInspectionId(Long inspectionId) 
    {
        this.inspectionId = inspectionId;
    }

    public Long getInspectionId() 
    {
        return inspectionId;
    }

    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }

    public void setInspector(String inspector) 
    {
        this.inspector = inspector;
    }

    public String getInspector() 
    {
        return inspector;
    }

    public void setInspectionDate(Date inspectionDate) 
    {
        this.inspectionDate = inspectionDate;
    }

    public Date getInspectionDate() 
    {
        return inspectionDate;
    }

    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inspectionId", getInspectionId())
            .append("roomId", getRoomId())
            .append("inspector", getInspector())
            .append("inspectionDate", getInspectionDate())
            .append("score", getScore())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
