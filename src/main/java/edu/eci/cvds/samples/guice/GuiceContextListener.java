package edu.eci.cvds.samples.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.cvds.samples.persistence.DaoIniciativa;
import edu.eci.cvds.samples.persistence.DaoUsuario;
import edu.eci.cvds.samples.persistence.mybatisimpl.MyBatisDAOIniciativa;
import edu.eci.cvds.samples.persistence.mybatisimpl.MyBatisDAOUsuario;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.impl.ServiciosBancoImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("Test");
                setClassPathResource("mybatis-config-h2.xml");

                bind(DaoIniciativa.class).to(MyBatisDAOIniciativa.class);
                bind(DaoUsuario.class).to(MyBatisDAOUsuario.class);
                bind(ServiciosBanco.class).to(ServiciosBancoImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}