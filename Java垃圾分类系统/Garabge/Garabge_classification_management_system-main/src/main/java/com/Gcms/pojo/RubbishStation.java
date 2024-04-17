package com.Gcms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 垃圾站信息管理
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubbishStation {
      private Integer id;             //垃圾站信息主键id
      private Integer classificationName; //垃圾分类名称(1塑料垃圾、2纸质垃圾、3干垃圾)
      private String nameStation;    //垃圾站名
      private String contacts;        //联系人
}
