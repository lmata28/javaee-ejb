package com.tecsup.ejb.util;

import java.util.List;

public interface GenericDAO<T> {

    public List<T> all();

    public T find(Long id);

    public void save(T t);

    public void update(T t);

    public void delete(T t);
}
