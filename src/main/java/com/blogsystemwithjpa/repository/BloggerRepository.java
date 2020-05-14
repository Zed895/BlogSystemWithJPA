package com.blogsystemwithjpa.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogsystemwithjpa.domain.Blogger;

/**
* This class is a Repository layer, part of the model, communicates with the DB.
* Extends interface for functions like save(), exists(), findAll(), count(), delete().
* @author Zed
*/
@Repository
public interface BloggerRepository extends CrudRepository<Blogger, Long> {
	List<Blogger> findAll();

}
