package br.com.ssid.portalcassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import br.com.ssid.portalcassandra.dao.TutorialRepository;

@ComponentScan(basePackages = {"br.com.ssid.portalcassandra", "br.com.ssid.portalcassandra.controller", "br.com.ssid.portalcassandra.model"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableCassandraRepositories(basePackageClasses = TutorialRepository.class)
public class PortalcassandraApplication {
	

	public static void main(String[] args) {
		
		SpringApplication.run(PortalcassandraApplication.class, args);
		
	}

}
