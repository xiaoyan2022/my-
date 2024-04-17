package com.Gcms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : k
 * @Date : 2022/7/3
 * @Desc :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentList {

     private Integer id;                          //设备列表id
     private String equipmentName;              //设备名称
     private String deliveryPort;               //投放口
     private String cleaner;                    //清洁员
     private Integer deliveryPortCapacity;       //投放口容量
     private Integer deliveryPortTemperature;    //投放口温度
     private Integer deliveryPortWeight;         //投放口重量
     private Integer deliveryPortHumidity;       //投放口湿度
     private String deliveryPortHarmfulGas;     //投放口有害气体
     private Integer deliveryPortStatus;         //投放口状态  (0代表已满，1代表未满)
}
