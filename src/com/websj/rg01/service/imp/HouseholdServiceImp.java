package com.websj.rg01.service.imp;

import com.websj.rg01.dao.HouseholdDao;
import com.websj.rg01.dao.imp.HouseholdDaoimp;
import com.websj.rg01.entity.Household;
import com.websj.rg01.service.HouseholdService;

import java.util.List;

public class HouseholdServiceImp implements HouseholdService {
    private HouseholdDao dao = new HouseholdDaoimp();

    @Override
    public List<Household> findall() {

        return dao.findall();
    }

    @Override
    public void addHouseHoldUser(Household household) {dao.addHousehold(household);}

    @Override
    public void deleteHouseholdUser(int id) {
        dao.deleteHousehold(id);
    }

    @Override
    public void updateHouseholdUser(Household household) {
            dao.update(household);
    }

    @Override
    public Household findHouseholdUser(String idcard) {
        return dao.findHousehold(idcard);
    }
}
