package edu.eci.cvds.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Like;
import edu.eci.cvds.samples.persistence.DaoLike;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatisimpl.mappers.LikeMapper;

import java.util.List;

public class MyBatisDAOLike implements DaoLike {
    @Inject
    LikeMapper likeMapper;

    @Override
    public List<Like> consultarLikesIn(int inid) throws PersistenceException {
        try{
            return likeMapper.consultarLikesIn(inid);
        }catch (Exception e){
            throw new PersistenceException("error al consultar Likes de iniciativa " +inid,e );
        }
    }

    @Override
    public void registrarLikes(int id, String correo) throws PersistenceException {
        try{
            likeMapper.registrarLikes(id,correo,true);
        }catch (Exception e){
            throw new PersistenceException("error al registrar Like mbtis",e);
        }
    }

    @Override
    public void deleteLikes(int id, String correo) throws PersistenceException {
        try{
            likeMapper.deleteLikes(id,correo);
        }catch (Exception e){
            throw new PersistenceException("error al registrar Like mbtis",e);
        }
    }

    @Override
    public Like consultarLikesInCor(int id, String corr) throws PersistenceException {
        try{
            return likeMapper.consultarLikesInCor(id,corr);
        }catch (Exception e){
            throw new PersistenceException("error al registrar Like mbtis",e);
        }
    }
}
