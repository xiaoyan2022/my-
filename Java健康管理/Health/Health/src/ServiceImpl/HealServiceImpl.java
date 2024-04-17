package ServiceImpl;



import Dao.HealthDao;
import DaoImpl.HealthDaoImpl;
import Entiry.HealMes;
import Entiry.HealthDevelop;
import Entiry.Person;
import Service.HealService;

import java.util.List;

public class HealServiceImpl implements HealService {
    private HealthDao healthDao;

    public HealServiceImpl() {
        super();
        healthDao = new HealthDaoImpl();

    }


    @Override
    public Person selectPerson(String staffId, String staffName) {
        return healthDao.selectPerson(staffId,staffName);
    }

    @Override
    public Boolean updateHelDevelop(HealthDevelop healthDevelop) {
        return healthDao.updateHelDevelop(healthDevelop);
    }

    @Override
    public Boolean updateHealMes(HealMes healMes) {
        return healthDao.updateHealMes(healMes);
    }

    @Override
    public Boolean updateHealthDevelop(HealthDevelop healthDevelop) {
        return healthDao.updateHealthDevelop(healthDevelop);
    }

    @Override
    public Boolean insertNewPerson(String staffId, String staffName) {
        return healthDao.insertNewPerson(staffId,staffName);
    }

    @Override
    public HealMes selectHealMes(String id) {
        return healthDao.selectHealMes(id);
    }

    @Override
    public HealthDevelop selectHealthDevelop(String delId) {
        return healthDao.selectHealthDevelop(delId);
    }

    @Override
    public Boolean deleteHealMes(String id) {
        return healthDao.deleteHealMes(id);
    }

    @Override
    public Boolean deleteHealthDevelop(String delId) {
        return healthDao.deleteHealthDevelop(delId);
    }

    @Override
    public List<HealMes> selectAllMes() {
        return healthDao.selectAllMes();
    }

    @Override
    public List<HealthDevelop> selectAllDevelops() {
        return healthDao.selectAllDevelops();
    }

    @Override
    public Boolean insertNewHealMes(HealMes healMes) {
        return healthDao.insertNewHealMes(healMes);
    }

    @Override
    public Boolean insertNewHealthDevelop(HealthDevelop healthDevelop) {
        return healthDao.insertNewHealthDevelop(healthDevelop);
    }
}
