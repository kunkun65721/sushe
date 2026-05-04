package com.sushe.susheguanli.service.impl;

import java.util.List;
import com.sushe.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sushe.susheguanli.mapper.SysDormitoryBuildingMapper;
import com.sushe.susheguanli.domain.SysDormitoryBuilding;
import com.sushe.susheguanli.service.ISysDormitoryBuildingService;

/**
 * 宿舍楼管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@Service
public class SysDormitoryBuildingServiceImpl implements ISysDormitoryBuildingService 
{
    @Autowired
    private SysDormitoryBuildingMapper sysDormitoryBuildingMapper;

    /**
     * 查询宿舍楼管理
     * 
     * @param buildingId 宿舍楼管理主键
     * @return 宿舍楼管理
     */
    @Override
    public SysDormitoryBuilding selectSysDormitoryBuildingByBuildingId(Long buildingId)
    {
        return sysDormitoryBuildingMapper.selectSysDormitoryBuildingByBuildingId(buildingId);
    }

    /**
     * 查询宿舍楼管理列表
     * 
     * @param sysDormitoryBuilding 宿舍楼管理
     * @return 宿舍楼管理
     */
    @Override
    public List<SysDormitoryBuilding> selectSysDormitoryBuildingList(SysDormitoryBuilding sysDormitoryBuilding)
    {
        return sysDormitoryBuildingMapper.selectSysDormitoryBuildingList(sysDormitoryBuilding);
    }

    /**
     * 新增宿舍楼管理
     * 
     * @param sysDormitoryBuilding 宿舍楼管理
     * @return 结果
     */
    @Override
    public int insertSysDormitoryBuilding(SysDormitoryBuilding sysDormitoryBuilding)
    {
        sysDormitoryBuilding.setCreateTime(DateUtils.getNowDate());
        return sysDormitoryBuildingMapper.insertSysDormitoryBuilding(sysDormitoryBuilding);
    }

    /**
     * 修改宿舍楼管理
     * 
     * @param sysDormitoryBuilding 宿舍楼管理
     * @return 结果
     */
    @Override
    public int updateSysDormitoryBuilding(SysDormitoryBuilding sysDormitoryBuilding)
    {
        sysDormitoryBuilding.setUpdateTime(DateUtils.getNowDate());
        return sysDormitoryBuildingMapper.updateSysDormitoryBuilding(sysDormitoryBuilding);
    }

    /**
     * 批量删除宿舍楼管理
     * 
     * @param buildingIds 需要删除的宿舍楼管理主键
     * @return 结果
     */
    @Override
    public int deleteSysDormitoryBuildingByBuildingIds(Long[] buildingIds)
    {
        return sysDormitoryBuildingMapper.deleteSysDormitoryBuildingByBuildingIds(buildingIds);
    }

    /**
     * 删除宿舍楼管理信息
     * 
     * @param buildingId 宿舍楼管理主键
     * @return 结果
     */
    @Override
    public int deleteSysDormitoryBuildingByBuildingId(Long buildingId)
    {
        return sysDormitoryBuildingMapper.deleteSysDormitoryBuildingByBuildingId(buildingId);
    }
}
