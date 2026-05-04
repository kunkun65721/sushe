package com.sushe.susheguanli.service;

import java.util.List;
import com.sushe.susheguanli.domain.SysDormitoryRoom;

/**
 * 宿舍房间Service接口
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public interface ISysDormitoryRoomService 
{
    /**
     * 查询宿舍房间
     * 
     * @param roomId 宿舍房间主键
     * @return 宿舍房间
     */
    public SysDormitoryRoom selectSysDormitoryRoomByRoomId(Long roomId);

    /**
     * 查询宿舍房间列表
     * 
     * @param sysDormitoryRoom 宿舍房间
     * @return 宿舍房间集合
     */
    public List<SysDormitoryRoom> selectSysDormitoryRoomList(SysDormitoryRoom sysDormitoryRoom);

    /**
     * 新增宿舍房间
     * 
     * @param sysDormitoryRoom 宿舍房间
     * @return 结果
     */
    public int insertSysDormitoryRoom(SysDormitoryRoom sysDormitoryRoom);

    /**
     * 修改宿舍房间
     * 
     * @param sysDormitoryRoom 宿舍房间
     * @return 结果
     */
    public int updateSysDormitoryRoom(SysDormitoryRoom sysDormitoryRoom);

    /**
     * 批量删除宿舍房间
     * 
     * @param roomIds 需要删除的宿舍房间主键集合
     * @return 结果
     */
    public int deleteSysDormitoryRoomByRoomIds(Long[] roomIds);

    /**
     * 删除宿舍房间信息
     * 
     * @param roomId 宿舍房间主键
     * @return 结果
     */
    public int deleteSysDormitoryRoomByRoomId(Long roomId);
}
