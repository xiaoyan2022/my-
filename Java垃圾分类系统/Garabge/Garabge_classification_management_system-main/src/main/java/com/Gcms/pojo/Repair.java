package com.Gcms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 报修管理
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repair {
     private Integer id;                          //报修管理id
     private String title;                       //报修标题
     private String details;                     //报修详情
     private String applicant;                   //报修人
     private Integer propertyCompletionStatus;   //物业完成状态（0代表未完成，1代表已完成）
     private Integer userConfirmationStatus;    //用户确认状态（0代表未确认，1代表已确认）

}
