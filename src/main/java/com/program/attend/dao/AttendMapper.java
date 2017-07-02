package com.program.attend.dao;

import com.program.attend.entity.Attend;
import com.program.attend.vo.QueryCondition;

import java.util.Date;
import java.util.List;

public interface AttendMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Attend record);

    int insertSelective(Attend record);

    Attend selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Attend record);

    int updateByPrimaryKey(Attend record);

    Attend selectTodaySignRecord(Long userId);

    int countByCondition(QueryCondition record);

    List<Attend> selectAttendPage(QueryCondition record);

    List<Attend> selectByDate(Date date);
}