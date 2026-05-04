package com.sushe.susheguanli.mapper;

import java.util.List;
import com.sushe.susheguanli.domain.SysDormitoryBuilding;

/**
 * 宿舍楼管理Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public interface SysDormitoryBuildingMapper 
{
    /**
     * 查询宿舍楼管理
     * 
     * @param buildingId 宿舍楼管理主键
     * @return 宿舍楼管理
     */
    public SysDormitoryBuilding selectSysDormitoryBuildingByBuildingId(Long buildingId);

    /**
     * 查询宿舍楼管理列表
     * 
     * @param sysDormitoryBuilding 宿舍楼管理
     * @return 宿舍楼管理集合
     */
    public List<SysDormitoryBuilding> selectSysDormitoryBuildingList(SysDormitoryBuilding sysDormitoryBuilding);

    /**
     * 新增宿舍楼管理
     * 
     * @param sysDormitoryBuilding 宿舍楼管理
     * @return 结果
     */
    public int insertSysDormitoryBuilding(SysDormitoryBuilding sysDormitoryBuilding);

    /**
     * 修改宿舍楼管理
     * 
     * @param sysDormitoryBuilding 宿舍楼管理
     * @return 结果
     */
    public int updateSysDormitoryBuilding(SysDormitoryBuilding sysDormitoryBuilding);

    /**
     * 删除宿舍楼管理
     * 
     * @param buildingId 宿舍楼管理主键
     * @return 结果
     */
    public int deleteSysDormitoryBuildingByBuildingId(Long buildingId);

    /**
     * 批量删除宿舍楼管理
     * 
     * @param buildingIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysDormitoryBuildingByBuildingIds(Long[] buildingIds);
}
