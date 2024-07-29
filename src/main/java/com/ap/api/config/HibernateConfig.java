package com.ap.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(
                "com.ap.api.repository.entity" );
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
   /* @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }*/

 /*   @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.disha.common.api.domain");

        factoryBean.setHibernateProperties(hibernateProperties());
        // factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        //factoryBean.setAnnotatedClasses(User.class);
        return factoryBean;
    }
*/
  /*  @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
*/
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.proc.param_null_passing", env.getRequiredProperty("hibernate.proc.param_null_passing"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));

        /* properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
         properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

         properties.put("hibernate.connection.autocommit", env.getProperty("hibernate.connection.autocommit"));
         properties.put("hibernate.current.session.context.class", env.getProperty("hibernate.current.session.context.class"));*/
        return properties;
    }
}
