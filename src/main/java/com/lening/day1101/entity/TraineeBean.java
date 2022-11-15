package com.lening.day1101.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "lntrainee")
public class TraineeBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;
    private String tname;
    private String tsex;
    private Integer tage;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tindate;

    private Long cid;
    private Long sid;
    private Long rid;
    //学员表对教练表多对一
    @JoinColumn(name = "cid")
    @ManyToOne
    private CoachBean coach=new CoachBean();
    //学车记录表多对多
    @JoinColumn(name = "rid")
    @ManyToOne
    private RecordBean record=new RecordBean();
    @JoinColumn(name = "sid")
    @ManyToOne
    private SubjectBean subject=new SubjectBean();
}
