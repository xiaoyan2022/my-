package DaoImpl;



import Dao.HealthDao;
import Entiry.HealMes;
import Entiry.HealthDevelop;
import Entiry.Person;
import Utils.utils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HealthDaoImpl implements HealthDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;


    @Override
    public Person selectPerson(String staffId, String staffName) {
        Person person = null;
        String sql = "select * from userDoctor where staffId = ? and staffName = ?";
        try {
            conn = utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, staffId);
            ps.setString(2,staffName);
            rs = ps.executeQuery();
            if(rs.next()) {
                person = new Person();
                person.setStaffId(rs.getString("staffId"));
                person.setStaffName(rs.getString("staffName"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (person!=null){
            return person;
        }
        return null;
    }

    @Override
    public Boolean updateHelDevelop(HealthDevelop healthDevelop) {
        return null;
    }

    @Override
    public Boolean updateHealMes(HealMes healMes) {
        Boolean bool = true;
        String sql = "update HealthMesTable set realName = ?, realAge = ?,realPhone = ? ,realMes = ? WHERE id = ?";
        try {
            conn = utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, healMes.getRealName());
            ps.setInt(2, healMes.getRealAge());
            ps.setString(3, healMes.getRealPhone());
            ps.setString(4, healMes.getRealText());
            ps.setString(5, healMes.getId());
            ps.executeUpdate();
            if(ps!=null) {
                bool = true;
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bool;
    }

    @Override
    public Boolean updateHealthDevelop(HealthDevelop healthDevelop) {
        Boolean bool = true;
        String sql = "update HealthMesTable set delMethod = ? WHERE delId = ?";
        try {
            conn = utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, healthDevelop.getDelMethod());
            ps.setString(2, healthDevelop.getDelId());

            ps.executeUpdate();
            if(ps!=null) {
                bool = true;
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bool;
    }

    @Override
    public Boolean insertNewPerson(String staffId, String staffName) {
        Boolean bool = true;
        String sql = "INSERT INTO userDoctor(staffId ,staffName )VALUES (?,?)";
        try {
            conn = utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, staffId);
            ps.setString(2, staffName);
            ps.executeUpdate();
            if(ps!=null) {
                bool = true;
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bool;
    }

    @Override
    public HealMes selectHealMes(String id) {
        HealMes healMes = null;
        String sql = "select * from HealthMesTable where id = ? ";
        try {
            conn = utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()) {
                healMes = new HealMes();
                healMes.setId(rs.getString("id"));
                healMes.setRealName(rs.getString("realName"));
                healMes.setRealAge(rs.getInt("realAge"));
                healMes.setRealPhone(rs.getString("realPhone"));
                healMes.setRealText(rs.getString("realMes"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (healMes!=null){
            return healMes;
        }
        return null;
    }

    @Override
    public HealthDevelop selectHealthDevelop(String delId) {
        HealthDevelop healthDevelop = null;
        String sql = "select * from HealthMesTable where delId = ? ";
        try {
            conn = utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, delId);

            rs = ps.executeQuery();
            if(rs.next()) {
                healthDevelop = new HealthDevelop();
                healthDevelop.setDelId(rs.getString("delId"));
                healthDevelop.setDelMethod(rs.getString("delMethod"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (healthDevelop!=null){
            return healthDevelop;
        }
        return null;
    }

    @Override
    public Boolean deleteHealMes(String id) {
        Boolean bool = true;
        String sql = "delete from HealthMesTable where id = ?";
        try {
            conn = utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            if(ps!=null) {
                bool = true;
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bool;
    }

    @Override
    public Boolean deleteHealthDevelop(String delId) {
        Boolean bool = true;
        String sql = "delete from HealthDevelopTable where delId = ?";
        try {
            conn = utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, delId);
            ps.executeUpdate();
            if(ps!=null) {
                bool = true;
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bool;
    }

    @Override
    public List<HealMes> selectAllMes() {
        HealMes healMes;
        List<HealMes> list = new ArrayList<>();
        String sql = "SELECT * FROM HealthMesTable ";
        try {
            conn = utils.getConnection();
            ps =conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                healMes = new HealMes();
                healMes.setId(rs.getString("id"));
                healMes.setRealName(rs.getString("realName"));
                healMes.setRealAge(rs.getInt("realAge"));
                healMes.setRealPhone(rs.getString("realPhone"));
                healMes.setRealText(rs.getString("realMes"));
                list.add(healMes);
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (list.size()==0){
            return null;
        }
        return list;
    }

    @Override
    public List<HealthDevelop> selectAllDevelops() {
        HealthDevelop healthDevelop;
        List<HealthDevelop> list = new ArrayList<>();
        String sql = "SELECT * FROM HealthDevelopTable ";
        try {
            conn = utils.getConnection();
            ps =conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                healthDevelop = new HealthDevelop();
                healthDevelop.setDelId(rs.getString("delId"));
                healthDevelop.setDelMethod(rs.getString("delMethod"));
                list.add(healthDevelop);
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (list.size()==0){
            return null;
        }
        return list;
    }

    @Override
    public Boolean insertNewHealMes(HealMes healMes) {
        Boolean bool = true;
        String sql = "INSERT INTO HealthMesTable(id ,realName,realAge,realPhone,realMes )VALUES (?,?,?,?,?)";
        try {
            conn = utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, healMes.getId());
            ps.setString(2, healMes.getRealName());
            ps.setInt(3, healMes.getRealAge());
            ps.setString(4, healMes.getRealPhone());
            ps.setString(5, healMes.getRealText());

            ps.executeUpdate();
            if(ps!=null) {
                bool = true;
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bool;
    }

    @Override
    public Boolean insertNewHealthDevelop(HealthDevelop healthDevelop) {
        Boolean bool = true;
        String sql = "INSERT INTO HealthMesTable(delId ,delMethod)VALUES (?,?)";
        try {
            conn = utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, healthDevelop.getDelId());
            ps.setString(2, healthDevelop.getDelMethod());

            ps.executeUpdate();
            if(ps!=null) {
                bool = true;
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                utils.Close(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bool;
    }
}
