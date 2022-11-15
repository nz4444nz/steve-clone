package com.lening.day1101.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "lnrecord")
public class RecordBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;
    private Date rdate;
    private Integer rduration;

    //学车记录表对科目表
    @Transient
    private SubjectBean subject=new SubjectBean();
}
