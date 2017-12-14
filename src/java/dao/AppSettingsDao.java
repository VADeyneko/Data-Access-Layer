package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.AppSettings;

@Stateless
public class AppSettingsDao extends AbstractDao<AppSettings> {

    @PersistenceContext(unitName = "Data_Access_LayerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppSettingsDao() {
        super(AppSettings.class);
    }

    @Override
    public AppSettings find(Object id) {

        return super.find(id);
    }

    public AppSettings getSettingsInstance() {
        List<AppSettings> inst = super.all();
        if (inst.isEmpty()) {
            AppSettings  instance = new AppSettings();
            instance.setdPeriodBegin( java.sql.Date.valueOf("2017-01-01"));
            instance.setdPeriodEnd(  java.sql.Date.valueOf("2019-01-01"));
            instance.setMinDaysAllowed(0);
            instance.setMaxDaysAllowed(1000000);
            super.create(instance);
            return instance;
            
        } else {
            return inst.get(0);
        }

    }
}
