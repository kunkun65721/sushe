package com.sushe.susheguanli.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.sushe.common.annotation.Excel;
import com.sushe.common.core.domain.BaseEntity;

/**
 * 学生习惯档案对象 my_student_habit
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public class MyStudentHabit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long habitId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long studentId;

    /** 作息习惯 */
    @Excel(name = "作息习惯")
    private String sleepHabit;

    /** 睡觉时间 */
    @Excel(name = "睡觉时间")
    private String sleepTime;

    /** 起床时间 */
    @Excel(name = "起床时间")
    private String wakeTime;

    /** 午休习惯 */
    @Excel(name = "午休习惯")
    private String napHabit;

    /** 洗澡频率 */
    @Excel(name = "洗澡频率")
    private String bathFrequency;

    /** 卫生重视程度 */
    @Excel(name = "卫生重视程度")
    private String cleanImportance;

    /** 能否接受室友不打扫 */
    @Excel(name = "能否接受室友不打扫")
    private String tolerateDirty;

    /** 学习地点 */
    @Excel(name = "学习地点")
    private String studyLocation;

    /** 欢迎室友带朋友 */
    @Excel(name = "欢迎室友带朋友")
    private String friendVisit;

    /** 是否接受室友开麦游戏 */
    @Excel(name = "是否接受室友开麦游戏")
    private String gamingMic;

    /** 是否打呼噜 */
    @Excel(name = "是否打呼噜")
    private String snoring;

    /** 填写状态 */
    @Excel(name = "填写状态")
    private String fillStatus;

    /** 填写时间 */
    private Date fillTime;

    public void setHabitId(Long habitId) 
    {
        this.habitId = habitId;
    }

    public Long getHabitId() 
    {
        return habitId;
    }

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }

    public void setSleepHabit(String sleepHabit) 
    {
        this.sleepHabit = sleepHabit;
    }

    public String getSleepHabit() 
    {
        return sleepHabit;
    }

    public void setSleepTime(String sleepTime) 
    {
        this.sleepTime = sleepTime;
    }

    public String getSleepTime() 
    {
        return sleepTime;
    }

    public void setWakeTime(String wakeTime) 
    {
        this.wakeTime = wakeTime;
    }

    public String getWakeTime() 
    {
        return wakeTime;
    }

    public void setNapHabit(String napHabit) 
    {
        this.napHabit = napHabit;
    }

    public String getNapHabit() 
    {
        return napHabit;
    }

    public void setBathFrequency(String bathFrequency) 
    {
        this.bathFrequency = bathFrequency;
    }

    public String getBathFrequency() 
    {
        return bathFrequency;
    }

    public void setCleanImportance(String cleanImportance) 
    {
        this.cleanImportance = cleanImportance;
    }

    public String getCleanImportance() 
    {
        return cleanImportance;
    }

    public void setTolerateDirty(String tolerateDirty) 
    {
        this.tolerateDirty = tolerateDirty;
    }

    public String getTolerateDirty() 
    {
        return tolerateDirty;
    }

    public void setStudyLocation(String studyLocation) 
    {
        this.studyLocation = studyLocation;
    }

    public String getStudyLocation() 
    {
        return studyLocation;
    }

    public void setFriendVisit(String friendVisit) 
    {
        this.friendVisit = friendVisit;
    }

    public String getFriendVisit() 
    {
        return friendVisit;
    }

    public void setGamingMic(String gamingMic) 
    {
        this.gamingMic = gamingMic;
    }

    public String getGamingMic() 
    {
        return gamingMic;
    }

    public void setSnoring(String snoring) 
    {
        this.snoring = snoring;
    }

    public String getSnoring() 
    {
        return snoring;
    }

    public void setFillStatus(String fillStatus) 
    {
        this.fillStatus = fillStatus;
    }

    public String getFillStatus() 
    {
        return fillStatus;
    }

    public void setFillTime(Date fillTime) 
    {
        this.fillTime = fillTime;
    }

    public Date getFillTime() 
    {
        return fillTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("habitId", getHabitId())
            .append("studentId", getStudentId())
            .append("sleepHabit", getSleepHabit())
            .append("sleepTime", getSleepTime())
            .append("wakeTime", getWakeTime())
            .append("napHabit", getNapHabit())
            .append("bathFrequency", getBathFrequency())
            .append("cleanImportance", getCleanImportance())
            .append("tolerateDirty", getTolerateDirty())
            .append("studyLocation", getStudyLocation())
            .append("friendVisit", getFriendVisit())
            .append("gamingMic", getGamingMic())
            .append("snoring", getSnoring())
            .append("fillStatus", getFillStatus())
            .append("fillTime", getFillTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
