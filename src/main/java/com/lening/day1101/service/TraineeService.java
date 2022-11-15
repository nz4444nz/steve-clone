package com.lening.day1101.service;

import com.github.pagehelper.PageInfo;
import com.lening.day1101.entity.TraineeBean;

public interface TraineeService {
    PageInfo<TraineeBean> findAllPage(TraineeBean searchEntity, Integer pageNum, Integer pageSize);

    void addTra(TraineeBean trainee);
}
