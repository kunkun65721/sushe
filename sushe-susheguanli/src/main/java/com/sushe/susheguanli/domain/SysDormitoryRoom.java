package com.sushe.susheguanli.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.sushe.common.annotation.Excel;
import com.sushe.common.core.domain.BaseEntity;

/**
 * 宿舍房间对象 my_dormitory_room
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public class SysDormitoryRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房间ID */
    private Long roomId;

    /** 所属宿舍楼ID */
    @Excel(name = "所属宿舍楼ID")
    private Long buildingId;

    /** 房间号 */
    @Excel(name = "房间号")
    private String roomNumber;

    /** 所在楼层 */
    @Excel(name = "所在楼层")
    private Long floorNumber;

    /** 床位总数 */
    @Excel(name = "床位总数")
    private Long bedCount;

    /** 已占用床位 */
    @Excel(name = "已占用床位")
    private Long bedOccupied;

    /** 房间类型 */
    @Excel(name = "房间类型")
    private String roomType;

    /** 房间状态（0空置 1满员 2维修） */
    @Excel(name = "房间状态", readConverterExp = "0=空置,1=满员,2=维修")
    private String roomStatus;

    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }

    public void setBuildingId(Long buildingId) 
    {
        this.buildingId = buildingId;
    }

    public Long getBuildingId() 
    {
        return buildingId;
    }

    public void setRoomNumber(String roomNumber) 
    {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() 
    {
        return roomNumber;
    }

    public void setFloorNumber(Long floorNumber) 
    {
        this.floorNumber = floorNumber;
    }

    public Long getFloorNumber() 
    {
        return floorNumber;
    }

    public void setBedCount(Long bedCount) 
    {
        this.bedCount = bedCount;
    }

    public Long getBedCount() 
    {
        return bedCount;
    }

    public void setBedOccupied(Long bedOccupied) 
    {
        this.bedOccupied = bedOccupied;
    }

    public Long getBedOccupied() 
    {
        return bedOccupied;
    }

    public void setRoomType(String roomType) 
    {
        this.roomType = roomType;
    }

    public String getRoomType() 
    {
        return roomType;
    }

    public void setRoomStatus(String roomStatus) 
    {
        this.roomStatus = roomStatus;
    }

    public String getRoomStatus() 
    {
        return roomStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roomId", getRoomId())
            .append("buildingId", getBuildingId())
            .append("roomNumber", getRoomNumber())
            .append("floorNumber", getFloorNumber())
            .append("bedCount", getBedCount())
            .append("bedOccupied", getBedOccupied())
            .append("roomType", getRoomType())
            .append("roomStatus", getRoomStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
