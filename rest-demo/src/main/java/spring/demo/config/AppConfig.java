package spring.demo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "spring.demo")
@PropertySource({ "classpath:persistense-mssql.properties" })
public class AppConfig {
	@Autowired
	private Environment ev;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public DataSource dataSource() {

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(ev.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		logger.info("User: " + ev.getProperty("jdbc.user"));

		dataSource.setJdbcUrl(ev.getProperty("jdbc.url"));
		dataSource.setUser(ev.getProperty("jdbc.user"));
		dataSource.setPassword(ev.getProperty("jdbc.password"));

		dataSource.setInitialPoolSize(getIntPropert("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(getIntPropert("connection.pool.minPoolSize"));
		dataSource.setMaxPoolSize(getIntPropert("connection.pool.maxPoolSize"));
		dataSource.setMaxIdleTime(getIntPropert("connection.pool.maxIdleTime"));

		return dataSource;
	}

	private int getIntPropert(String string) {
		String pro = ev.getProperty(string);
		int intpro = Integer.parseInt(pro);
		System.out.println(intpro);
		return intpro;
	}

	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan(ev.getProperty("hibernate.packagesToScan"));
		bean.setHibernateProperties(getHibernateProperties());
		return bean;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialec", ev.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", ev.getProperty("hibernate.show_sql"));
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory) {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(factory);
		return manager;
	}

}
