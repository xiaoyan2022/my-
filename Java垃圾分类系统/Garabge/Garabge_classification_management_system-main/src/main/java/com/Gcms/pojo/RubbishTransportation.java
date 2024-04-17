package com.Gcms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 垃圾运输信息管理
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubbishTransportation {
     private Integer id;                       //垃圾运输信息管理id编号
     private String chargeName;               //收费名称
     private Integer transportationQuantity;  //运输数量
     private String communityName;            //小区名称
     private Integer rubbishType;       //可回收垃圾（0） 不可回收垃圾（1）
     private Integer transportationStatus;    //运输状态(0代表运输中，1代表已送达)
     private Date createTime;                 //创建时间
     private Date transportationTime;        //运输时间
}
