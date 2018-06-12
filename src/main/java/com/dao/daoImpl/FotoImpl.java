package com.dao.daoImpl;

import com.dao.AbstractDAO;
import com.dao.FotoDAO;
import com.model.Foto;
import org.springframework.stereotype.Repository;

@Repository("fotoDAO")
public class FotoImpl extends AbstractDAO<Integer, Foto> implements FotoDAO {

    @Override
    public Foto findById(int id) {
        return getByKey(id);
    }
}
