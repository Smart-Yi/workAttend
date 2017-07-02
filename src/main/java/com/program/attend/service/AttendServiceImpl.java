package com.program.attend.service;

import com.program.attend.dao.AttendMapper;
import com.program.attend.entity.Attend;
import com.program.attend.vo.QueryCondition;
import com.program.common.page.PageQueryBean;
import com.program.common.utils.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 匡小菜 on 2017/6/28.
 */
@Service("AttendServiceImpl")
public class  AttendServiceImpl implements IAttendService{

    //中午12点
    private static final int MOON_HOUR = 12 ;

    //中午分钟
    private static final int MOON_MINUTE = 00 ;

    @Autowired
    private AttendMapper attendMapper ;

    private Log log = LogFactory.getLog(AttendServiceImpl.class);

    /**
     * @Author: Smart-YI
     * @Date: 2017/6/28 20:39
     * @params:  * @param attend
     * @Description:
     */
    @Override
    @Transactional
    public void signAttend(Attend attend) throws Exception {

        try {
            Date today = new Date() ;

            attend.setAttendDate(today);

            attend.setAttendWeek((byte)DateUtils.getTodayWeek(today));

            Date noon = DateUtils.getDate(MOON_HOUR,MOON_MINUTE);

            //从数据库取出此ID的打卡记录
            Attend todayRecord = attendMapper.selectTodaySignRecord(attend.getUserId());

            /***
             * attend 从前端传过来的attend记录
             * todayRecord 从数据库取出来的attend记录
             */

            if (today.compareTo(noon) <= 0) {

                //打卡时间在上午并且数据库[没有]今天的打卡记录 则 新插入上午打卡记录
                //打卡时间在上午并且数据库[有]今天的打卡记录 则 不做处理
                if (todayRecord == null) {

                    attend.setAttendMorning(today);

                    attendMapper.insertSelective(attend);
                }

            }else {

                //打卡时间在下午并且数据库没有今天的打卡记录 则 新插入下午打卡记录
                if (todayRecord == null) {

                    attend.setAttendEvening(today);

                    attendMapper.insertSelective(attend);

                }else {
                    //打卡时间在下午并且数据库有今天的打卡记录 则 更新下午打卡记录
                    todayRecord.setAttendEvening(today);

                    attendMapper.updateByPrimaryKeySelective(todayRecord);
                }
            }

        }catch (Exception e){

            log.error("签到异常" , e);

            throw  e;
        }


    }

    @Override
    public PageQueryBean listAttend(QueryCondition queryCondition){

        int count = attendMapper.countByCondition(queryCondition);

        PageQueryBean pageResult = new PageQueryBean();

        if (count > 0){
            pageResult.setCurrentPage(queryCondition.getCurrentPage());

            pageResult.setPageSize(queryCondition.getPageSize());

            pageResult.setTotalRows(count);


           List<Attend> attendList = attendMapper.selectAttendPage(queryCondition);

            pageResult.setItems(attendList);
        }
        return pageResult ;
    }


    @Override
    @Transactional
    public void test (Attend attend){
        attendMapper.insertSelective(attend);
    }


}
