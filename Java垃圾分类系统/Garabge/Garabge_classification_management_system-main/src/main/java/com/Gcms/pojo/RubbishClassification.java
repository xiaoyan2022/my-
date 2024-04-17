package com.Gcms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 垃圾分类信息管理
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubbishClassification {

      private Integer id;                 //垃圾分类编号
      private String classificationName; //垃圾分类名称(1塑料垃圾、2纸质垃圾、3干垃圾)
      private String rubbishType;       //可回收垃圾（0）

}
