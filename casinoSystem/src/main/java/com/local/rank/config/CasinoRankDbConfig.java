package com.local.rank.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="rankDbEntityManagerFactory",transactionManagerRef="rankDbTransactionManager",
basePackages={"com.local.rank.daos.repositories"})
public class CasinoRankDbConfig {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	@Bean(name="rankDbDataSource")
	@Primary
	public DataSource dataSource()
	{
		BasicDataSource simpleDriverDataSource=new BasicDataSource();
		simpleDriverDataSource.setUrl(url);
		simpleDriverDataSource.setUsername(userName);
		simpleDriverDataSource.setPassword(password);
		simpleDriverDataSource.setDriverClassName(driverClassName);
		return simpleDriverDataSource;
	}
	
	@Bean(name = "rankDbEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("rankDbDataSource")DataSource dataSource)
	{
		return builder.dataSource(dataSource).packages("com.local.rank.db.model")
				.persistenceUnit("rankPersistanceUnit").properties(jpaProperties()).build();
	}
	
	@Bean(name ="rankDbTransactionManager")
	@Primary
	public PlatformTransactionManager transactionManager(@Qualifier("rankDbEntityManagerFactory")
	EntityManagerFactory entityManagerFactory)
	{
		return new JpaTransactionManager(entityManagerFactory);
	}
	private Map<String, String> jpaProperties() {
		Map<String, String> jpaPropertiesMap = new HashMap<>();
		jpaPropertiesMap.put("show.sql", "True");
		return jpaPropertiesMap;
	}
}
