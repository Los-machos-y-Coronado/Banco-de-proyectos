package edu.eci.cvds.samples.persistence;

import edu.eci.cvds.samples.entities.Like;

import java.util.List;

public interface DaoLike {

    public List<Like> consultarLikesIn(int inid) throws PersistenceException;

    public void registrarLikes(int id, String correo) throws PersistenceException ;

    public void deleteLikes(int id, String correo) throws PersistenceException ;

    public Like consultarLikesInCor(int id, String corr)throws PersistenceException ;
}
