package com.zlht.pose.management.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlht.pose.management.dao.entity.Charge;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface ChargeMapper extends BaseMapper<Charge> {


    @Select("select * from (select c.id,\n" +
            "        c.type,\n" +
            "        c.institution_id,\n" +
            "        c.charge_time,\n" +
            "        c.confirm_people,\n" +
            "        c.confirm_time,\n" +
            "        c.status,\n" +
            "        c.mark,\n" +
            "        c.create_time,\n" +
            "        i.name\n" +
            " from charge c\n" +
            "          left join institution i on i.id = c.institution_id)\n" +
            "res  where (#{keyword} IS NULL OR res.name LIKE CONCAT('%', #{keyword}, '%')) and  (#{type}  = -1 OR res.id =#{type})")
    Page<Map<String, Object>> selectCharge(Page<?> page, @Param("keyword") String keyword,
                                           @Param("type") int type);

}