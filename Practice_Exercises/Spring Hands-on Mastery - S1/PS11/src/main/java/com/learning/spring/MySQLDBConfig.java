package com.learning.spring;

import java.util.Properties;

import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
 
@Configuration
public class MySQLDBConfig {
 
	@Autowired
	private Environment environment;
 
	@Bean(name = { "mysqlDataSource" })
	@Scope(value = "singleton")
	public DataSource getDataSource() {
 
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
 
		return dataSource;
	}
 
	@Bean(name = { "mysqlSessionFactory" })
	@Scope(value = "singleton")
	public LocalSessionFactoryBean getSessionFactory(
			@Autowired @Qualifier("mysqlDataSource") DataSource datasource) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(datasource);
		sessionFactoryBean.setPackagesToScan("com.learning.spring");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}
	@Bean(name = {"hibernateTransactionManager"})
	@Scope(value = "singleton")
	public HibernateTransactionManager getTransactionManager(
			@Autowired @Qualifier("mysqlSessionFactory") SessionFactory sessionFactory) {
		HibernateTransactionManager txmgr = new HibernateTransactionManager(sessionFactory);
		return txmgr;
	}
}
 
 
 
