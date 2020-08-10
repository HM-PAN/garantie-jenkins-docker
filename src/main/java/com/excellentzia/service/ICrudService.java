package com.excellentzia.service;

import java.util.List;

public interface ICrudService<T,E> {
	T add(T t);
	T update (T t);
	T getOne(E id);
	List<T> findAll();
	void delete(E id);
	boolean exists (E id);
	Long counter ();

}
