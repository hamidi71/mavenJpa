package nl.programIt;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="nl.programit")
@EnableTransactionManagement

/*/*<context:annotation-config/>
<context:component-scan base-package="nl.programIt"/>
<tx:annotation-driven transaction-manager="transactionManagerObject"/>
<jpa:repositories base-package="nl.programIt.repository" 
entity-manager-factory-ref="entityManagerFactoryObject" 
transaction-manager-ref="transactionManagerObject"/>*/

public class ApplicationConfig {
	/*<bean id="databaseconuction" class="org.apache.commons.dbcp2.BasicDataSource">
	<property name="url" value="jdbc:mysql://localhost:3306/db-mavenjparepos"/>
	<property name="driverClassName" value="com.mysql.jdbc.Driver"/>
	<property name="username" value="root"/>
	<property name="password" value=""/>	
	</bean>*/
	@Bean
	public DataSource databaseconuction(){
		//class instantieren
		BasicDataSource db=new BasicDataSource();
		db.setUrl("jdbc:mysql://localhost:3306/db_mavenjparepos");
		db.setDriverClassName("com.mysql.jdbc.Driver");
		db.setUsername("root");
		return db;
	}
	@Bean
	/*<bean id="entityManagerFactoryObject" 
	 * class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
		<property name="dataSource" ref="databaseconuction"/>
		<property name="packagesToScan" value="nl.programIt.entities"/>
		<property name="jpaVendorAdapter"> 
			<bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter"/>			
		</property>		
	</bean>
	 * */
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryObject(){
		LocalContainerEntityManagerFactoryBean entityMan=new LocalContainerEntityManagerFactoryBean();
		entityMan.setDataSource(this.databaseconuction());//waarom niet databaseconuction()
		entityMan.setPackagesToScan("nl.programIt.entities");
		entityMan.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return entityMan;
	}
	/*<bean id="transactionManagerObject" class="org.springframework.orm.jpa.JpaTransactionManager">
	<property name="entityManagerFactory" ref="entityManagerFactoryObject"/> </bean>*/


	@Bean
	public JpaTransactionManager transactionManagerObject(){
		JpaTransactionManager jpaTrans=new JpaTransactionManager();
		jpaTrans.setEntityManagerFactory(this.entityManagerFactoryObject().getObject());
		return jpaTrans;
		
		
	}
	

}
//@ContextConfiguration(classes= ApplicationConfig.class)
