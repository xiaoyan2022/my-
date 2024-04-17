package Service;


import Entiry.HealMes;
import Entiry.HealthDevelop;
import Entiry.Person;

import java.util.List;

//业务接口创建
public interface HealService {
              //工号登录
    Person selectPerson(String staffId,String staffName);
    //修改管理方式
    Boolean updateHelDevelop(HealthDevelop healthDevelop);
    //修改体检报告
    Boolean updateHealMes(HealMes healMes);
    //修改体检处理方法
    Boolean updateHealthDevelop(HealthDevelop healthDevelop);
    //插入新账户
    Boolean insertNewPerson(String staffId,String staffName);
    //获得体检报告实体
    HealMes selectHealMes(String id);
    //获得管理信息实体
    HealthDevelop selectHealthDevelop(String delId);
    //删除体检报告
    Boolean deleteHealMes(String id);
    //删除体检处理方法
    Boolean deleteHealthDevelop(String delId);
    //查询全部体检报告
    List<HealMes> selectAllMes();
    //查看全部体检处理方法
    List<HealthDevelop> selectAllDevelops();
    //插入新的体检报告
    Boolean insertNewHealMes(HealMes healMes);
    //插入新的体检处理方法
    Boolean insertNewHealthDevelop(HealthDevelop healthDevelop);
}
