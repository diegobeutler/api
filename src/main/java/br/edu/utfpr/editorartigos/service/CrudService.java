package br.edu.utfpr.editorartigos.service;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface CrudService<T, ID> {
    List<T> findAll();

    List<T> findAll(Sort sort);

    List<T> findAllById(Iterable<ID> ids);

    <S extends T> List<S> saveAll(Iterable<S> entities);

    <S extends T> S saveAndFlush(S entity);

    <S extends T> S save(S entity) throws Exception;

    void delete(ID id);

}
