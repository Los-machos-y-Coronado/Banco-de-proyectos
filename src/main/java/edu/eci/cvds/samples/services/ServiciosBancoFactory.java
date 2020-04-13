/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.cvds.samples.persistence.DaoUsuario;
import edu.eci.cvds.samples.persistence.mybatisimpl.MyBatisDAOUsuario;
import edu.eci.cvds.samples.services.impl.ServiciosBancoImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

/**
 *
 * @author Andres Gonzalez
 */
public class ServiciosBancoFactory {
    private static ServiciosBancoFactory instance = new ServiciosBancoFactory();
    
    private static Injector injector;
    
    public ServiciosBancoFactory(){
        injector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize(){
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
                bind(ServiciosBanco.class).to(ServiciosBancoImpl.class);
                bind(DaoUsuario.class).to(MyBatisDAOUsuario.class);
                
            }
        }
        );
    }
    
    public ServiciosBanco getServiciosBanco(){
        return injector.getInstance(ServiciosBanco.class);
    }
    public static ServiciosBancoFactory getInstance(){
        return instance;
    }
    
}
