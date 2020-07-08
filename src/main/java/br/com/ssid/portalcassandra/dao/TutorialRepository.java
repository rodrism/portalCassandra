package br.com.ssid.portalcassandra.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

import br.com.ssid.portalcassandra.model.Tutorial;

public interface TutorialRepository extends CassandraRepository<Tutorial>{
	
	
	List<Tutorial> findByPublished(boolean published);
	List<Tutorial> findByTitleContaining(String title);
	
}
