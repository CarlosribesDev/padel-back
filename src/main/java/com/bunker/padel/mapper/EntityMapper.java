package com.bunker.padel.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface EntityMapper <E, M> {

    M entityToDTO(E e);

    default List<M> entitiesToDTOs(final List<E> e){
        if(e == null) return null;

        return e.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    default List<M> entitiesToDTOs(final Iterable<E> e){
        if(e == null) return null;

        return StreamSupport.stream(e.spliterator(), false).map(this::entityToDTO).collect(Collectors.toList());
    }

    E DTOToEntity(M m);

    default List<E> DTOsToEntities(final List<M> m){
        if(m == null) return null;

        return m.stream().map(this::DTOToEntity).collect(Collectors.toList());
    }

    default List<E> DTOsToEntities(final Iterable<M> m){
        if(m == null) return null;

        return StreamSupport.stream(m.spliterator(), false).map(this::DTOToEntity).collect(Collectors.toList());
    }
}