package repository;

import java.util.Optional;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 * @param <T>
 * @param <ID>
 */
public interface Repository<T, ID> {

//    long count();

    Long count(T entity) throws Exception;

    void delete(T entity) throws Exception;

//    void deleteAll();
    void deleteAll(T entity) throws Exception;

//    void deleteAll(Iterable<? extends T> entities);
    void deleteAll(T entity, Iterable<? extends T> entities) throws Exception;

//    default void deleteAll(Iterable<? extends T> entities) {
//        entities.forEach(entity -> delete(entity));
//    }
//    
//    void deleteAllByIDs(Iterable<? extends ID> ids);
    void deleteAllByIDs(T entity, Iterable<? extends ID> ids) throws Exception;
//    default void deleteAllByIDs(Iterable<? extends ID> ids) {
//        ids.forEach(id -> deleteByID(id));
//    }

//    void deleteByID(ID id) throws Exception;
    void deleteByID(T entity, ID id) throws Exception;

//    boolean existsByID(ID id);
    boolean existsByID(T entity, ID id) throws Exception;

//    Iterable<T> findAll();

    Iterable<T> findAll(T entity, FetchType fetch) throws Exception;

//    Iterable<T> findAllByIDs(Iterable<ID> ids);
    Iterable<T> findAllByIDs(T entity, Iterable<ID> ids) throws Exception;
//    
//    default Iterable<T> findAllByIDs(Iterable<ID> ids) {
//        return StreamSupport
//                .stream(ids.spliterator(), false)
//                .map(id -> findByID(id))
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .collect(Collectors.toList());
//    }

//    Optional<T> findByID(ID id);
    Optional<T> findByID(T entity, ID id) throws Exception;

    <S extends T> S save(S entity) throws Exception;

//    <S extends T> Iterable<S> saveAll(Iterable<S> entities) throws Exception;
    <S extends T> Iterable<S> saveAll(T entity, Iterable<S> entities) throws Exception;
    
    <S extends T> S update(S entity) throws Exception;
    
//    default <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
//        return StreamSupport.stream(entities.spliterator(), false)
//                .map(entity -> save(entity))
//                .collect(Collectors.toList());
//    }

//    <S extends T> S update(S entity);
//
//    <S extends T> Iterable<S> updateAll(Iterable<S> entities);
}
