package com.program.attend.service;

import com.program.attend.entity.Attend;
import com.program.attend.vo.QueryCondition;
import com.program.common.page.PageQueryBean;

/**
 * Created by 匡小菜 on 2017/6/28.
 */
public interface IAttendService {

    /**
     * @Author: Smart-YI
     * @Date: 2017/6/28 20:38
     * @params:  * @param attend
     * @Description:
     */
    public void signAttend(Attend attend) throws Exception;

    public PageQueryBean listAttend(QueryCondition queryCondition);

    public void test(Attend attend);



}
