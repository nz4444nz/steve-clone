package com.lening.day1101.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.day1101.entity.CoachBean;
import com.lening.day1101.entity.RecordBean;
import com.lening.day1101.entity.SubjectBean;
import com.lening.day1101.entity.TraineeBean;
import com.lening.day1101.mapper.CoachMapper;
import com.lening.day1101.mapper.RecordMapper;
import com.lening.day1101.mapper.SubjectMapper;
import com.lening.day1101.mapper.TraineeMapper;
import com.lening.day1101.service.TraineeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService {
    @Resource
    private TraineeMapper traineeMapper;
    @Resource
    private SubjectMapper subjectMapper;
    @Resource
    private CoachMapper coachMapper;
    @Resource
    private RecordMapper recordMapper;

    @Override
    public PageInfo<TraineeBean> findAllPage(TraineeBean searchEntity, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(TraineeBean.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchEntity!= null) {
            if (!StringUtils.isEmpty(searchEntity.getTname())) {
                criteria.andLike("tname", "%"+searchEntity.getTname()+"%");
            }
        }
        List<TraineeBean> list=traineeMapper.selectByExample(example);
        for (TraineeBean traineeBean : list) {
            if (traineeBean.getSid()!=null) {
                SubjectBean subject=subjectMapper.selectByPrimaryKey(traineeBean.getSid());
                traineeBean.setSubject(subject);
            }
            if (traineeBean.getRid()!=null) {
                RecordBean record=recordMapper.selectByPrimaryKey(traineeBean.getRid());
                traineeBean.setRecord(record);
            }
            if (traineeBean.getCid()!=null) {
                CoachBean coach=coachMapper.selectByPrimaryKey(traineeBean.getCid());
                traineeBean.setCoach(coach);
            }
        }
        PageInfo<TraineeBean> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void addTra(TraineeBean trainee) {

    }
}
