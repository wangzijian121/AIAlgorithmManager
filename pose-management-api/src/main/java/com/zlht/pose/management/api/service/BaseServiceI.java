package com.zlht.pose.management.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlht.pose.management.api.utils.Result;

import java.util.List;

public interface BaseServiceI<T> {


    Result<T> success(List<T> data);

    Result<T> faild(int code, String msg);
}
