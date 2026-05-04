package com.sushe.susheguanli.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sushe.common.annotation.Log;
import com.sushe.common.core.controller.BaseController;
import com.sushe.common.core.domain.AjaxResult;
import com.sushe.common.enums.BusinessType;
import com.sushe.susheguanli.domain.SysDormitoryRoom;
import com.sushe.susheguanli.service.ISysDormitoryRoomService;
import com.sushe.common.utils.poi.ExcelUtil;
import com.sushe.common.core.page.TableDataInfo;

/**
 * 宿舍房间Controller
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@RestController
@RequestMapping("/susheguanli/room")
public class SysDormitoryRoomController extends BaseController
{
    @Autowired
    private ISysDormitoryRoomService sysDormitoryRoomService;

    /**
     * 查询宿舍房间列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:room:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDormitoryRoom sysDormitoryRoom)
    {
        startPage();
        List<SysDormitoryRoom> list = sysDormitoryRoomService.selectSysDormitoryRoomList(sysDormitoryRoom);
        return getDataTable(list);
    }

    /**
     * 导出宿舍房间列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:room:export')")
    @Log(title = "宿舍房间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDormitoryRoom sysDormitoryRoom)
    {
        List<SysDormitoryRoom> list = sysDormitoryRoomService.selectSysDormitoryRoomList(sysDormitoryRoom);
        ExcelUtil<SysDormitoryRoom> util = new ExcelUtil<SysDormitoryRoom>(SysDormitoryRoom.class);
        util.exportExcel(response, list, "宿舍房间数据");
    }

    /**
     * 获取宿舍房间详细信息
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:room:query')")
    @GetMapping(value = "/{roomId}")
    public AjaxResult getInfo(@PathVariable("roomId") Long roomId)
    {
        return success(sysDormitoryRoomService.selectSysDormitoryRoomByRoomId(roomId));
    }

    /**
     * 新增宿舍房间
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:room:add')")
    @Log(title = "宿舍房间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDormitoryRoom sysDormitoryRoom)
    {
        return toAjax(sysDormitoryRoomService.insertSysDormitoryRoom(sysDormitoryRoom));
    }

    /**
     * 修改宿舍房间
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:room:edit')")
    @Log(title = "宿舍房间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDormitoryRoom sysDormitoryRoom)
    {
        return toAjax(sysDormitoryRoomService.updateSysDormitoryRoom(sysDormitoryRoom));
    }

    /**
     * 删除宿舍房间
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:room:remove')")
    @Log(title = "宿舍房间", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roomIds}")
    public AjaxResult remove(@PathVariable Long[] roomIds)
    {
        return toAjax(sysDormitoryRoomService.deleteSysDormitoryRoomByRoomIds(roomIds));
    }
}
