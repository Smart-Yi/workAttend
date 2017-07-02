package com.program.common.task;

import com.program.attend.dao.AttendMapper;
import com.program.attend.entity.Attend;
import com.program.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 匡小菜 on 2017/6/30.
 */
public class AttendCheck {
    private static Byte ATTEND_STATUS = 2 ;

    private static int MINUTES_SUBTRACT = 720 ;

    private static int WORK_TIME = 540 ;

    @Autowired
    AttendMapper attendMapper;

    @Transactional
    public  void  checkAbsence(){

        List<Attend> attendList =  attendMapper.selectByDate(new Date());
          Integer

        for (Attend list :
                attendList) {

            if (list.getAttendMorning() ==null ||list.getAttendEvening() == null){

                list.setAttendStatus(ATTEND_STATUS);

                list.setAbsence(MINUTES_SUBTRACT);
            }else if (DateUtils.getMinutes(list.getAttendEvening(),list.getAttendMorning()) < WORK_TIME){

                list.setAttendStatus(ATTEND_STATUS);

                list.setAbsence(WORK_TIME - DateUtils.getMinutes(list.getAttendEvening(),list.getAttendMorning()));
            }
            attendMapper.updateByPrimaryKeySelective(list);
        }


    }

}
