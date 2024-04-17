package Health;

import Entiry.HealMes;
import Entiry.HealthDevelop;
import Entiry.Person;
import Service.HealService;
import ServiceImpl.HealServiceImpl;


import java.util.List;
import java.util.Scanner;

public class HealImpl {
   //验证用户
    public Person queryUser(String staffId,String staffName){
        HealService healService = new HealServiceImpl();
        Person person = healService.selectPerson(staffId,staffName);
        if (person!=null){
            return person;
        }
        return null;
    }
    public Boolean insertNewPerson(String staffId,String staffName){
        HealService healService = new HealServiceImpl();
        Boolean aBoolean = healService.insertNewPerson(staffId, staffName);
        if (aBoolean){
            return true;
        }
        return false;
    }
    public Boolean insertNewHealMes(HealMes healMes){
        HealService healService = new HealServiceImpl();
        Boolean aBoolean = healService.insertNewHealMes(healMes);
        if (aBoolean){
            return true;
        }
        return false;
    }
    public Boolean insertNewHealMesDevelop(HealthDevelop healthDevelop){
        HealService healService = new HealServiceImpl();
        Boolean aBoolean = healService.insertNewHealthDevelop(healthDevelop);
        if (aBoolean){
            return true;
        }
        return false;
    }
    public List<HealMes> selectAllHealMes(){
        HealService healService = new HealServiceImpl();
        List<HealMes> list = healService.selectAllMes();
        if (list!=null){
            return list;
        }
        return null;
    }
    public List<HealthDevelop> selectAllHealDevelop(){
        HealService healService = new HealServiceImpl();
        List<HealthDevelop> list = healService.selectAllDevelops();
        if (list!=null){
            return list;
        }
        return null;
    }
    public Boolean updateHealMesDevelop(HealthDevelop healthDevelop){
        HealService healService = new HealServiceImpl();
        Boolean aBoolean = healService.updateHealthDevelop(healthDevelop);
        if (aBoolean){
            return true;
        }
        return false;
    }
    public Boolean updateHealMes(HealMes healMes){
        HealService healService = new HealServiceImpl();
        Boolean aBoolean = healService.updateHealMes(healMes);
        if (aBoolean){
            return true;
        }
        return false;
    }
    public Boolean deleteHealMesById(String id){
        HealService healService = new HealServiceImpl();
        Boolean aBoolean = healService.deleteHealMes(id);
        if (aBoolean){
            return true;
        }
        return false;
    }
    public Boolean deleteHealMesDevelopByDelId(String delId){
        HealService healService = new HealServiceImpl();
        Boolean aBoolean = healService.deleteHealthDevelop(delId);
        if (aBoolean){
            return true;
        }
        return false;
    }
    public HealMes selectHealthMesById(String id){
        HealService healService = new HealServiceImpl();
        HealMes healMes = healService.selectHealMes(id);
        if (healMes!=null){
            return healMes;
        }
        return null;
    }
    public HealthDevelop selectHealthMesDevelopById(String delId){
        HealService healService = new HealServiceImpl();
        HealthDevelop healthDevelop = healService.selectHealthDevelop(delId);
        if (healthDevelop!=null){
            return healthDevelop;
        }
        return null;
    }
//实现
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HealImpl heal = new HealImpl();
          for (int i = 0; i >-1 ; i++) {
              System.err.println("♥♥♥♥♥♥欢迎使用健康管理系统♥♥♥♥♥♥");
              System.out.println("-1登陆系统-2注册账号");
              System.out.println("请选择操作");
              int login = scanner.nextInt();
              if (login==1){

                  System.err.println("♥♥♥♥♥♥账号登陆♥♥♥♥♥♥");
                  System.out.println("-1登陆系统-2返回");
                  System.out.println("请选择操作");
                  int loginBtn = scanner.nextInt();
                  if (loginBtn==1){
                      System.err.println("♥♥♥♥♥♥账号登陆♥♥♥♥♥♥");
                      System.out.println("请输入账号");
                      String staffId = scanner.next();
                      System.out.println("请输入密码");
                      String staffName = scanner.next();
                      //实现登录
                      Person person = heal.queryUser(staffId,staffName);
                      if (person!=null){
                          //z主界面
                          for (int j = 0; j >-1 ; j++) {
                              System.err.println("♥♥♥♥♥♥主界面♥♥♥♥♥♥");
                              System.out.println("-1体检信息管理-0返回");
                              System.out.println("请选择操作");
                              int main = scanner.nextInt();
                              if (main==1){
                                  for (int k = 0; k >-1 ; k++) {
                                      System.err.println("♥♥♥♥♥♥体检信息管理♥♥♥♥♥♥");
                                      System.out.println("-1增加体检信息-2查询全部体检信息-3修改体检信息-4删除信息");
                                      System.out.println("请选择操作");
                                      int add = scanner.nextInt();
                                      if (add==1){
                                          System.err.println("♥♥♥♥♥♥增加体检信息♥♥♥♥♥♥");
                                          System.err.println("请输入新的体检Id不可以重复Id例如：001");
                                          String id = scanner.next();
                                          System.err.println("请输入您的姓名");
                                          String realName = scanner.next();
                                          System.err.println("请输入您的年龄");
                                          int realAge = scanner.nextInt();
                                          System.err.println("请输入您的手机号");
                                          String realPhone = scanner.next();
                                          System.err.println("请输入您的具体情况");
                                          String realMes = scanner.next();
                                          heal.insertNewHealMes(new HealMes(id,realName,realPhone,realAge,realMes));
                                          System.out.println("添加成功");
                                          continue;
                                      }
                                      else if (add==2){
                                          System.err.println("♥♥♥♥♥♥查询全部体检信息♥♥♥♥♥♥");
                                          List<HealMes> list = heal.selectAllHealMes();
                                          if (list!=null){
                                              for (int l = 0; l <list.size() ; l++) {
                                                  System.out.println(list.get(l));
                                              }
                                              System.out.println("以上是全部体检信息");
                                          }
                                          else {
                                              System.err.println("没有任何体检信息");
                                          }
                                          continue;
                                      }
                                      else if (add==3){
                                          System.err.println("♥♥♥♥♥♥修改体检信息♥♥♥♥♥♥");
                                          List<HealMes> list = heal.selectAllHealMes();
                                          if (list!=null){
                                              for (int l = 0; l <list.size() ; l++) {
                                                  System.out.println(list.get(l));
                                              }
                                              System.out.println("以上是全部体检信息");
                                          }
                                          else {
                                              System.err.println("没有任何体检信息");
                                          }
                                          System.err.println("请输入您想修改的Id例如：001");
                                          String id = scanner.next();
                                          HealMes healMes = heal.selectHealthMesById(id);
                                          System.err.println("请输入您想修改的姓名如果不想修改请修改no");
                                          String realName = scanner.next();
                                          if (!(realName.equals("no"))){
                                              healMes.setRealName(realName);
                                          }
                                          System.err.println("请输入您的年龄如果不想修改请修改-1");
                                          int realAge = scanner.nextInt();
                                          if (realAge!=-1){
                                              healMes.setRealAge(realAge);
                                          }
                                          System.err.println("请输入您的手机号如果不想修改请输入no");
                                          String realPhone = scanner.next();
                                          if (!(realPhone.equals("no"))){
                                              healMes.setRealPhone(realPhone);
                                          }
                                          System.err.println("请输入您的具体情况如果不想修改请输入no");
                                          String realMes = scanner.next();
                                          if (!(realMes.equals("no"))){
                                              healMes.setRealText(realMes);
                                          }
                                          heal.updateHealMes(healMes);
                                          System.out.println("修改成功");
                                          continue;
                                      }
                                      else if (add==4){
                                          System.err.println("♥♥♥♥♥♥删除体检信息♥♥♥♥♥♥");
                                          List<HealMes> list = heal.selectAllHealMes();
                                          if (list==null){
                                              System.out.println("没有信息");
                                          }
                                          else {
                                              for (int l = 0; l <list.size() ; l++) {
                                                  System.out.println(list.get(l));
                                              }
                                              System.out.println("以上是全部体检信息");
                                          }
                                          System.err.println("请输入您想修改的Id例如：001");
                                          String id = scanner.next();
                                          heal.deleteHealMesById(id);
                                          System.out.println("删除成功");
                                          continue;

                                      }
                                      else {
                                          break;
                                      }
                                  }
                              }

//                              else if (main==2){
//                                  for (int k = 0; k >-1 ; k++) {
//                                      System.err.println("♥♥♥♥♥♥增加体检报告针对处理♥♥♥♥♥♥");
//                                      System.out.println("-1增加体检处理方案-2查询全部处理方案-3修改处理信息-4返回");
//                                      System.out.println("请选择操作");
//                                      int solve = scanner.nextInt();
//                                      if (solve==1){
//                                          System.err.println("♥♥♥♥♥♥增加方案♥♥♥♥♥♥");
//                                          System.out.println("以上是全部体检报告");
//                                          System.out.println("请选择您想针对的体检报告");
//                                          String id
//                                        continue;
//                                      }
//                                      else if (solve==2){
//                                          continue;
//                                      }
//                                      else if (solve==3){
//                                        continue;
//                                      }
//                                      else {
//                                          break;
//                                      }
//                                  }
//                              }
                              else {
                                  break;
                              }
                          }
                      }
                      else {
                          System.err.println("账号密码不存在");
                          continue;
                      }
                  }
                  else {
                      continue;
                  }
              }
              else {
                  System.err.println("♥♥♥♥♥♥账号注册♥♥♥♥♥♥");
                  System.out.println("-1注册-2返回");
                  System.out.println("请选择操作");
                  int register = scanner.nextInt();
                  if (register==1){
                      System.out.println("请输入新账号");
                      String staffId = scanner.next();
                      System.out.println("请输入新密码");
                      String staffName = scanner.next();
                      heal.insertNewPerson(staffId,staffName);
                      System.out.println("账号密码注册成功");
                      continue;
                  }
                  else {
                      continue;
                  }
              }
          }

   }
}
