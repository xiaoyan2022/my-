package com.Gcms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 投诉管理
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {
    private Integer id;                      //投诉管理id
    private String title;                    //投诉标题
    private String details;                  //投诉详情
    private String complainant;              //投诉人
    private Integer propertyCompletionStatus; //物业完成状态（0代表未完成，1代表已完成）
    private Integer userConfirmationStatus;   //用户确认状态（0代表未确认，0代表已确认）
}
