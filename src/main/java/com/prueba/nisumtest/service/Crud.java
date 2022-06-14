package com.prueba.nisumtest.service;

import java.util.List;

public interface Crud<T> {
    T create(T object);
    List<T> findAll();
}
