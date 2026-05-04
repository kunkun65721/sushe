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
import com.sushe.susheguanli.domain.MyStudentHabit;
import com.sushe.susheguanli.service.IMyStudentHabitService;
import com.sushe.common.utils.poi.ExcelUtil;
import com.sushe.common.core.page.TableDataInfo;

/**
 * 学生习惯档案Controller
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@RestController
@RequestMapping("/susheguanli/habit")
public class MyStudentHabitController extends BaseController
{
    @Autowired
    private IMyStudentHabitService myStudentHabitService;

    /**
     * 查询学生习惯档案列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:habit:list')")
    @GetMapping("/list")
    public TableDataInfo list(MyStudentHabit myStudentHabit)
    {
        startPage();
        List<MyStudentHabit> list = myStudentHabitService.selectMyStudentHabitList(myStudentHabit);
        return getDataTable(list);
    }

    /**
     * 导出学生习惯档案列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:habit:export')")
    @Log(title = "学生习惯档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MyStudentHabit myStudentHabit)
    {
        List<MyStudentHabit> list = myStudentHabitService.selectMyStudentHabitList(myStudentHabit);
        ExcelUtil<MyStudentHabit> util = new ExcelUtil<MyStudentHabit>(MyStudentHabit.class);
        util.exportExcel(response, list, "学生习惯档案数据");
    }

    /**
     * 获取学生习惯档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:habit:query')")
    @GetMapping(value = "/{habitId}")
    public AjaxResult getInfo(@PathVariable("habitId") Long habitId)
    {
        return success(myStudentHabitService.selectMyStudentHabitByHabitId(habitId));
    }

    /**
     * 新增学生习惯档案
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:habit:add')")
    @Log(title = "学生习惯档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MyStudentHabit myStudentHabit)
    {
        return toAjax(myStudentHabitService.insertMyStudentHabit(myStudentHabit));
    }

    /**
     * 修改学生习惯档案
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:habit:edit')")
    @Log(title = "学生习惯档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MyStudentHabit myStudentHabit)
    {
        return toAjax(myStudentHabitService.updateMyStudentHabit(myStudentHabit));
    }

    /**
     * 删除学生习惯档案
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:habit:remove')")
    @Log(title = "学生习惯档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{habitIds}")
    public AjaxResult remove(@PathVariable Long[] habitIds)
    {
        return toAjax(myStudentHabitService.deleteMyStudentHabitByHabitIds(habitIds));
    }
}
