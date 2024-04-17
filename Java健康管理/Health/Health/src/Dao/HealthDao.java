package Dao;

import Entiry.HealMes;
import Entiry.HealthDevelop;
import Entiry.Person;

import java.util.List;

public interface HealthDao {

    Person selectPerson(String staffId, String staffName);

    Boolean updateHelDevelop(HealthDevelop healthDevelop);

    Boolean updateHealMes(HealMes healMes);

    Boolean updateHealthDevelop(HealthDevelop healthDevelop);

    Boolean insertNewPerson(String staffId, String staffName);

    HealMes selectHealMes(String id);

    HealthDevelop selectHealthDevelop(String delId);

    Boolean deleteHealMes(String id);

    Boolean deleteHealthDevelop(String delId);

    List<HealMes> selectAllMes();

    List<HealthDevelop> selectAllDevelops();

    Boolean insertNewHealMes(HealMes healMes);

    Boolean insertNewHealthDevelop(HealthDevelop healthDevelop);
}
