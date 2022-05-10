package com.ncepu.service.impl;

import com.ncepu.bean.ST_Intrest;
import com.ncepu.dao.IntrestDao;
import com.ncepu.service.IntrestService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntrestServiceImpl implements IntrestService {

    @Autowired
    private IntrestDao dao;

    @Override
    public ST_Intrest getIntrestBySnm(@Param("S_Nm")int S_Nm) {
        return dao.getIntrestBySnm(S_Nm);
    }

    @Override
    public List<ST_Intrest> getAllIntrest() {
        return dao.getAllIntrest();
    }
}
