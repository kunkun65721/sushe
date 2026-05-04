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
import com.sushe.susheguanli.domain.MyRepair;
import com.sushe.susheguanli.service.IMyRepairService;
import com.sushe.common.utils.poi.ExcelUtil;
import com.sushe.common.core.page.TableDataInfo;

/**
 * 报修记录Controller
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@RestController
@RequestMapping("/susheguanli/repair")
public class MyRepairController extends BaseController
{
    @Autowired
    private IMyRepairService myRepairService;

    /**
     * 查询报修记录列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:repair:list')")
    @GetMapping("/list")
    public TableDataInfo list(MyRepair myRepair)
    {
        startPage();
        List<MyRepair> list = myRepairService.selectMyRepairList(myRepair);
        return getDataTable(list);
    }

    /**
     * 导出报修记录列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:repair:export')")
    @Log(title = "报修记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MyRepair myRepair)
    {
        List<MyRepair> list = myRepairService.selectMyRepairList(myRepair);
        ExcelUtil<MyRepair> util = new ExcelUtil<MyRepair>(MyRepair.class);
        util.exportExcel(response, list, "报修记录数据");
    }

    /**
     * 获取报修记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:repair:query')")
    @GetMapping(value = "/{repairId}")
    public AjaxResult getInfo(@PathVariable("repairId") Long repairId)
    {
        return success(myRepairService.selectMyRepairByRepairId(repairId));
    }

    /**
     * 新增报修记录
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:repair:add')")
    @Log(title = "报修记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MyRepair myRepair)
    {
        return toAjax(myRepairService.insertMyRepair(myRepair));
    }

    /**
     * 修改报修记录
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:repair:edit')")
    @Log(title = "报修记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MyRepair myRepair)
    {
        return toAjax(myRepairService.updateMyRepair(myRepair));
    }

    /**
     * 删除报修记录
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:repair:remove')")
    @Log(title = "报修记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{repairIds}")
    public AjaxResult remove(@PathVariable Long[] repairIds)
    {
        return toAjax(myRepairService.deleteMyRepairByRepairIds(repairIds));
    }
}
