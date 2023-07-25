package com.zlht.pose.management.dao.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "institution", autoResultMap = true)
public class Institution {
    @TableId(type = IdType.AUTO)
    @JsonIgnore
    private Integer id;

    @TableField
    @ApiModelProperty(name = "type", value = "机构类型", required = true)
    private Integer type;

    @TableField
    @ApiModelProperty(name = "name", value = "机构名", required = true)
    private String name;

    @TableField
    @ApiModelProperty(name = "phone", value = "手机", required = true)
    private String phone;

    @TableField
    @ApiModelProperty(name = "email", value = "邮箱", required = true)
    private String email;

    @TableField
    @ApiModelProperty(name = "address", value = "地址", required = true)
    private String address;

    @TableField
    @ApiModelProperty(name = "map", value = "地图位置", required = false)
    private String map;

    @TableField
    @ApiModelProperty(name = "createTime", value = "创建时间 iso:YYYY-MM-DDTHH:mm:ss.sssZ", required = true)
    private Date createTime;



}