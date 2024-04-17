package com.Gcms.serviceImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.UserDao;
import com.Gcms.daoImpl.UserDaoImpl;
import com.Gcms.pojo.User;
import com.Gcms.service.UserService;
import com.Gcms.view.DataTable;
import com.Gcms.view.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc :
 */
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger("UserServiceImpl.class");
    //业务层 要 调用dao层
    private final UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public DefaultTableModel selectAll() {
        BaseDao.openConnection();
        ResultSet rs = null;//通过业务层调用具体的数据库操作
        DefaultTableModel dtm = null;
        try {
            if (Menu.userStatus == 0) {
                rs = userDao.selectAll(BaseDao.conn);
            } else {
                rs = userDao.selectAllWithoutPassword(BaseDao.conn);
            }

            dtm = DataTable.toDefaultTableModel(rs);//调用DataTable静态方法将ResultSet转化为DefaultTableModel
        } catch (SQLException e) {
            LOGGER.error("selectAll方法出错了");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, rs);
        }
        return dtm;
    }

    /**
     * 根据ID查询用户
     *
     * @param
     * @return
     */
    @Override
    public DefaultTableModel selectByUserName(String userName) {
        BaseDao.openConnection();
        ResultSet rs = null;//通过业务层调用具体的数据库操作
        DefaultTableModel dtm = null;
        try {
            rs = userDao.selectByUserName(BaseDao.conn, userName);
            dtm = DataTable.toDefaultTableModel(rs);//调用DataTable静态方法将ResultSet转化为DefaultTableModel
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, rs);
        }
        return dtm;
    }

    /**
     * 用户登录逻辑
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean login(String username, String password) {
        boolean flag = false;
        ResultSet rs = null;
        try {
            BaseDao.openConnection();
            rs = userDao.selectByNameByPassword(BaseDao.conn, username, password);//通过业务层调用具体的数据库操作
            if (rs.next()) {
                flag = true;
                Menu.userStatus = rs.getInt(7);//获取当前登录用户的状态
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行时异常
        } finally {
            //在service层进行connection连接的关闭
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, rs);//关闭资源
        }
        return flag;
    }

    /**
     * 用户注册逻辑
     */
    @Override
    public boolean register(String[] params) {
        boolean flag = false;
        //-------将参数封装为pojo类 user------
        User user = new User();
        user.setUsername(params[0]);
        user.setPassword(params[1]);
        user.setName(params[2]);
        user.setCommunityName(params[3]);
        user.setEmail(params[4]);
        user.setPhone(params[5]);
        user.setStatus(Integer.parseInt(params[6]));
        user.setCreateTime(new Date());//直接截取系统当前的时间作为创建时间
        try {
            BaseDao.openConnection();
            BaseDao.conn.setAutoCommit(false);//开启事务
            int i = userDao.insert(BaseDao.conn, user);//插入新用户信息
            BaseDao.conn.commit();//提交事务
            if (i > 0) {
                flag = true;
                LOGGER.info("用户信息注册成功");
                JOptionPane.showMessageDialog(Menu.menu, "添加成功");
            } else {
                LOGGER.info("用户信息注册失败");
                JOptionPane.showMessageDialog(Menu.menu, "添加成功");
            }
        } catch (SQLIntegrityConstraintViolationException e) {//用户名为主键，限制传入参数
            JOptionPane.showMessageDialog(null, "该用户名已经被使用，换一个吧");
            LOGGER.info("用户输入已存在的主键作为参数");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "出错了");
            LOGGER.info("SQL出现问题");
            try {
                BaseDao.conn.rollback();//出现问题回滚事务
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }

    /**
     * 传入主键（username）进行删除
     */
    @Override
    public boolean delete(String username) {
        boolean flag = false;//用于判断是否删除成功
        BaseDao.openConnection();
        try {
            BaseDao.conn.setAutoCommit(false);
            int i = userDao.delete(BaseDao.conn, username);//进行删除，i>0为删除成功
            BaseDao.conn.commit();
            if (i > 0) {
                flag = true;
                LOGGER.info("用户表删除数据成功");
                JOptionPane.showMessageDialog(null, "删除成功");
            } else {
                LOGGER.info("用户表删除数据失败");
                JOptionPane.showMessageDialog(null, "删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //在service层进行connection连接的关闭
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }

    @Override
    public boolean update(String[] params) {
        boolean flag = false;
        BaseDao.openConnection();

        //将修改过的参数封装为pojo类 user
        User user = new User();
        user.setUsername(params[0]);
        user.setPassword(params[1]);
        user.setName(params[2]);
        user.setCommunityName(params[3]);
        user.setEmail(params[4]);
        user.setPhone(params[5]);
        user.setStatus(Integer.parseInt(params[6]));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            user.setCreateTime(sdf.parse(params[7]));
            BaseDao.conn.setAutoCommit(false);
            int i = userDao.update(BaseDao.conn, user);
            BaseDao.conn.commit();

            if (i > 0) {
                flag = true;
                LOGGER.info("用户信息修改成功");
                JOptionPane.showMessageDialog(Menu.menu, "修改成功");
            } else {
                LOGGER.info("用户信息修改失败");
                JOptionPane.showMessageDialog(Menu.menu, "修改失败");
            }
        } catch (ParseException e) {
            LOGGER.error("用户输入的时间有误");
            JOptionPane.showMessageDialog(null, "请按照”yyyy-MM-dd HH:mm:ss“输入时间");
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("SQL出现错误");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }
}
