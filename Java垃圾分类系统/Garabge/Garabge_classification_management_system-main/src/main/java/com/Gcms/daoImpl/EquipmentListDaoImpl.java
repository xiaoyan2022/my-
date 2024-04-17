package com.Gcms.daoImpl;


import com.Gcms.dao.BaseDao;
import com.Gcms.dao.EquipmentListDao;
import com.Gcms.pojo.EquipmentList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/3
 * @Desc :
 */
public class EquipmentListDaoImpl implements EquipmentListDao {
    @Override
    public ResultSet selectAll(Connection connection) throws SQLException {
        ResultSet rs = null;

        String sql = "select id as '设备ID'," +
                "equipmentName as '设备名称'," +
                "deliveryPort as '投放点'," +
                "cleaner as '清洁工'," +
                "deliveryPortCapacity as '投放点容量'," +
                "deliveryPortTemperature as '投放点温度'," +
                "deliveryPortWeight as '投放点重量'," +
                "deliveryPortHumidity as '投放点湿度'," +
                "deliveryPortHarmfulGas as '投放点有害气体'," +
                "deliveryPortStatus as '投放点状态' from gui.equipment_list";

        rs = BaseDao.execute(connection, BaseDao.pstmt, null, sql);

        //BaseDao.closeResource(connection, pstm, rs);

        return rs;

    }


    @Override
    public int add(Connection connection, EquipmentList equipmentList) throws SQLException {
        int flag = 0;
        if (connection != null) {
            String sql = "insert into gui.equipment_list(" +
                    "equipmentName,deliveryPort,cleaner," +
                    "deliveryPortCapacity,deliveryPortTemperature," +
                    "deliveryPortWeight,deliveryPortHumidity,deliveryPortHarmfulGas," +
                    "deliveryPortStatus) " +
                    "values(?,?,?,?,?,?,?,?,?)";
            Object[] params = {equipmentList.getEquipmentName(), equipmentList.getDeliveryPort(),
                    equipmentList.getCleaner(), equipmentList.getDeliveryPortCapacity(),
                    equipmentList.getDeliveryPortTemperature(), equipmentList.getDeliveryPortWeight(),
                    equipmentList.getDeliveryPortHumidity(),
                    equipmentList.getDeliveryPortHarmfulGas(), equipmentList.getDeliveryPortStatus()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);

            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }

    @Override
    public int delete(Connection connection, Integer id) throws SQLException {
        int flag = 0;

        if (connection != null) {
            String sql = "delete from gui.equipment_list where id = ?";
            Object[] params = {id};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);

            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }

    @Override
    public int update(Connection connection, EquipmentList equipmentList) throws SQLException {
        int flag = 0;
        if (connection != null) {
            String sql = "update gui.equipment_list set equipmentName=?," +
                    "deliveryPort=?,cleaner = ?,deliveryPortCapacity =?,deliveryPortTemperature=?," +
                    "deliveryPortWeight =?,deliveryPortHumidity=?,deliveryPortHarmfulGas=? ," +
                    "deliveryPortStatus=? where id = ? ";

            Object[] params = {equipmentList.getEquipmentName(), equipmentList.getDeliveryPort(),
                    equipmentList.getCleaner(), equipmentList.getDeliveryPortCapacity(),
                    equipmentList.getDeliveryPortTemperature(), equipmentList.getDeliveryPortWeight(),
                    equipmentList.getDeliveryPortHumidity(),
                    equipmentList.getDeliveryPortHarmfulGas(), equipmentList.getDeliveryPortStatus(),
                    equipmentList.getId()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);
            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }
}
