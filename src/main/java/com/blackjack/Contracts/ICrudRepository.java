package com.blackjack.Contracts;

import java.io.Serializable;
import org.springframework.data.repository.Repository;

public interface ICrudRepository <T, ID extends Serializable>extends Repository<T, ID> {
    
	public T save(T entity);
   
	public T findOne(ID primaryKey);
  
	public Iterable<T> findAll();

	public Long count();

	public void delete(T entity);

	public boolean exists(ID primaryKey);

}