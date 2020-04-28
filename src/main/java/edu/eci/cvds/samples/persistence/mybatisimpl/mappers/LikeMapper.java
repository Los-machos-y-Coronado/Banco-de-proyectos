package edu.eci.cvds.samples.persistence.mybatisimpl.mappers;

import edu.eci.cvds.samples.entities.Like;
import edu.eci.cvds.samples.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LikeMapper {

    public List<Like> consultarLikesIn(@Param("inid") int inid) throws PersistenceException;

    public void registrarLikes(@Param("inid") int id,@Param ("corr") String correo,@Param("boole") boolean bool);

    public void deleteLikes(@Param("inid") int id, @Param ("corr") String correo);

    public Like consultarLikesInCor(@Param("inid") int id, @Param ("corr") String correo);
}
