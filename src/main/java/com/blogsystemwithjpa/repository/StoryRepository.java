package com.blogsystemwithjpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogsystemwithjpa.domain.Story;

/**
* This class is a Repository layer, part of the model, communicates with the DB.
* Extends interface for functions like save(), exists(), findAll(), count(), delete().
* @author Zed
*/
@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {
	
	//SELECT * FROM STORIES
	List<Story> findAll(); //Overridden to return List instead of Iterable.
	
	//SELECT * FROM STORIES WHERE posted IN (SELECT MAX(posted) FROM STORIES) LIMIT 1;
	Story findFirstByOrderByPostedDesc(); //JPA interprets this query.
	
	@Query(value = "select * from stories where title = ?1", nativeQuery = true) //native = not an object but a value of a record.
	Story findByTitle(String title);
	
	Story findByTitleIgnoreCase(String title); //from the interface, based on standardised function name
	
	List<Story> findAllByBloggerNameIgnoreCaseOrderByPostedDesc(String name);

}
