//package com.javaschool.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@Import(SpringServiceConfig.class)
//@EnableJpaRepositories(basePackages = "com.javaschool.repositories")
//@EnableTransactionManagement
//public class SpringMainConfig {
//
//    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
//    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jvs";
//    private static final String DATABASE_USERNAME = "root";
//    private static final String DATABASE_PASSWORD = "";
//    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
//    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.javaschool.model";
//
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName(DATABASE_DRIVER);
//        dataSource.setUrl(DATABASE_URL);
//        dataSource.setUsername(DATABASE_USERNAME);
//        dataSource.setPassword(DATABASE_PASSWORD);
//
//        return dataSource;
//
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource());
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
//        entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
//
//        entityManagerFactoryBean.setJpaProperties(additionalProperties());
//
//        return entityManagerFactoryBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }
//
//
//    private Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//        return properties;
//    }
//
//}
