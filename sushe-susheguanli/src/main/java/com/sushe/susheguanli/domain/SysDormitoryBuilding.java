package com.sushe.susheguanli.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.sushe.common.annotation.Excel;
import com.sushe.common.core.domain.BaseEntity;

/**
 * 宿舍楼管理对象 my_dormitory_building
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public class SysDormitoryBuilding extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 宿舍楼ID */
    private Long buildingId;

    /** 宿舍楼名称 */
    @Excel(name = "宿舍楼名称")
    private String buildingName;

    /** 楼栋类型 */
    @Excel(name = "楼栋类型")
    private String buildingType;

    /** 楼层数 */
    @Excel(name = "楼层数")
    private Long floorCount;

    /** 房间数 */
    @Excel(name = "房间数")
    private Long roomCount;

    /** 宿舍楼状态（0正常 1停用） */
    @Excel(name = "宿舍楼状态", readConverterExp = "0=正常,1=停用")
    private String buildingStatus;

    public void setBuildingId(Long buildingId) 
    {
        this.buildingId = buildingId;
    }

    public Long getBuildingId() 
    {
        return buildingId;
    }

    public void setBuildingName(String buildingName) 
    {
        this.buildingName = buildingName;
    }

    public String getBuildingName() 
    {
        return buildingName;
    }

    public void setBuildingType(String buildingType) 
    {
        this.buildingType = buildingType;
    }

    public String getBuildingType() 
    {
        return buildingType;
    }

    public void setFloorCount(Long floorCount) 
    {
        this.floorCount = floorCount;
    }

    public Long getFloorCount() 
    {
        return floorCount;
    }

    public void setRoomCount(Long roomCount) 
    {
        this.roomCount = roomCount;
    }

    public Long getRoomCount() 
    {
        return roomCount;
    }

    public void setBuildingStatus(String buildingStatus) 
    {
        this.buildingStatus = buildingStatus;
    }

    public String getBuildingStatus() 
    {
        return buildingStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("buildingId", getBuildingId())
            .append("buildingName", getBuildingName())
            .append("buildingType", getBuildingType())
            .append("floorCount", getFloorCount())
            .append("roomCount", getRoomCount())
            .append("buildingStatus", getBuildingStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
