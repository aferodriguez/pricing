package com.inditex.pricing.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.inditex.pricing.persistence.*"})
public class TestJpaConfig {
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();
        emf.setPackagesToScan("com.inditex.pricing");
        emf.setDataSource(createDataSource());
        emf.setJpaVendorAdapter(createJpaVendorAdapter());
        //emf.setJpaProperties(createHibernateProperties());
        emf.afterPropertiesSet();
        return emf;
    }
    	
    @Bean
     protected DataSource createDataSource() {
        EmbeddedDatabaseBuilder builder =
                new EmbeddedDatabaseBuilder();

        return builder.setType(EmbeddedDatabaseType.H2)		
        .addScript("classpath:schema.sql")
        .addScript("classpath:data.sql")
        .build();
    	 
    	/* DriverManagerDataSource dataSource = new DriverManagerDataSource();
         dataSource.setDriverClassName("org.h2.Driver");
         dataSource.setUrl("jdbc:h2:mem:myDb;INIT=runscript from '~/schema.sql'\\\\;runscript from '~/data.sql'");
         dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
         dataSource.setUrl("jdbc:hsqldb:mem:testdb");
         dataSource.setUsername("sa");
         dataSource.setPassword("");
         return dataSource;*/
    }

    private JpaVendorAdapter createJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

   /* private Properties createHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
        properties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty(
                "jpa.generate-ddl", "none");
        properties.setProperty(
                "jpa.hibernate.ddl-auto", "none");
        return properties;
    }*/

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
