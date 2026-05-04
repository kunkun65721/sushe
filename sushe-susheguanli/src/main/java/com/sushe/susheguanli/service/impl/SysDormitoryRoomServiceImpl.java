package com.sushe.susheguanli.service.impl;

import java.util.List;
import com.sushe.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sushe.susheguanli.mapper.SysDormitoryRoomMapper;
import com.sushe.susheguanli.domain.SysDormitoryRoom;
import com.sushe.susheguanli.service.ISysDormitoryRoomService;

/**
 * 宿舍房间Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@Service
public class SysDormitoryRoomServiceImpl implements ISysDormitoryRoomService 
{
    @Autowired
    private SysDormitoryRoomMapper sysDormitoryRoomMapper;

    /**
     * 查询宿舍房间
     * 
     * @param roomId 宿舍房间主键
     * @return 宿舍房间
     */
    @Override
    public SysDormitoryRoom selectSysDormitoryRoomByRoomId(Long roomId)
    {
        return sysDormitoryRoomMapper.selectSysDormitoryRoomByRoomId(roomId);
    }

    /**
     * 查询宿舍房间列表
     * 
     * @param sysDormitoryRoom 宿舍房间
     * @return 宿舍房间
     */
    @Override
    public List<SysDormitoryRoom> selectSysDormitoryRoomList(SysDormitoryRoom sysDormitoryRoom)
    {
        return sysDormitoryRoomMapper.selectSysDormitoryRoomList(sysDormitoryRoom);
    }

    /**
     * 新增宿舍房间
     * 
     * @param sysDormitoryRoom 宿舍房间
     * @return 结果
     */
    @Override
    public int insertSysDormitoryRoom(SysDormitoryRoom sysDormitoryRoom)
    {
        sysDormitoryRoom.setCreateTime(DateUtils.getNowDate());
        return sysDormitoryRoomMapper.insertSysDormitoryRoom(sysDormitoryRoom);
    }

    /**
     * 修改宿舍房间
     * 
     * @param sysDormitoryRoom 宿舍房间
     * @return 结果
     */
    @Override
    public int updateSysDormitoryRoom(SysDormitoryRoom sysDormitoryRoom)
    {
        sysDormitoryRoom.setUpdateTime(DateUtils.getNowDate());
        return sysDormitoryRoomMapper.updateSysDormitoryRoom(sysDormitoryRoom);
    }

    /**
     * 批量删除宿舍房间
     * 
     * @param roomIds 需要删除的宿舍房间主键
     * @return 结果
     */
    @Override
    public int deleteSysDormitoryRoomByRoomIds(Long[] roomIds)
    {
        return sysDormitoryRoomMapper.deleteSysDormitoryRoomByRoomIds(roomIds);
    }

    /**
     * 删除宿舍房间信息
     * 
     * @param roomId 宿舍房间主键
     * @return 结果
     */
    @Override
    public int deleteSysDormitoryRoomByRoomId(Long roomId)
    {
        return sysDormitoryRoomMapper.deleteSysDormitoryRoomByRoomId(roomId);
    }
}
