package com.lening.day1101.controller;

import com.github.pagehelper.PageInfo;

import com.lening.day1101.entity.TraineeBean;
import com.lening.day1101.service.TraineeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/trainee")
public class TraineeController {
    @Resource
    private TraineeService traineeService;

    @RequestMapping("findAllPage")
    public PageInfo<TraineeBean> findAllPage(@RequestBody TraineeBean searchEntity,
                                             @RequestParam(defaultValue = "1")Integer pageNum,
                                             @RequestParam(defaultValue = "5")Integer pageSize){
        return traineeService.findAllPage(searchEntity, pageNum, pageSize);
    }

    @RequestMapping("toAddTra")
    public String toAddTra(){
        return "trainee_add";
    }
    @RequestMapping("addTra")
    public String addTra(TraineeBean trainee){
        traineeService.addTra(trainee);
        return "findAllPage";
    }
}
