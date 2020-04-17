/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

import static com.google.inject.Guice.createInjector;


import com.google.inject.Injector;
import edu.eci.cvds.samples.persistence.DaoIniciativa;
import edu.eci.cvds.samples.persistence.DaoUsuario;
import edu.eci.cvds.samples.persistence.mybatisimpl.MyBatisDAOIniciativa;
import edu.eci.cvds.samples.persistence.mybatisimpl.MyBatisDAOUsuario;
import edu.eci.cvds.samples.services.impl.ServiciosBancoImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import java.util.Optional;

/**
 *
 * @author Jairo Gomez
 */
public class ServiciosBancoFactory {

        private static ServiciosBancoFactory  instance = new ServiciosBancoFactory();

        private static Optional<Injector> optInjector;

        private Injector myBatisInjector(String env, String pathResource) {
            return createInjector(new XMLMyBatisModule() {
                @Override
                protected void initialize() {
                    setEnvironmentId(env);
                    setClassPathResource(pathResource);
                    bind(DaoUsuario.class).to(MyBatisDAOUsuario.class);
                    bind(DaoIniciativa.class).to(MyBatisDAOIniciativa.class);
                    bind(ServiciosBanco.class).to(ServiciosBancoImpl.class);

                }
            });
        }
    private ServiciosBancoFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosBanco getServiciosBanco(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServiciosBanco.class);
    }


    public ServiciosBanco getServiciosBancoTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ServiciosBanco.class);
    }


    public static ServiciosBancoFactory getInstance(){
        return instance;
    }

}
