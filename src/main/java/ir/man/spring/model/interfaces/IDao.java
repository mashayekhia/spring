package ir.man.spring.model.interfaces;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao<T,ID extends Serializable>   {

    Optional<List<T>> getAll() throws SQLException;

    Optional<T> getById(ID id) throws SQLException;

    <S extends T> S insert(S entity) throws SQLException;

    <S extends T> S update(S entity) throws SQLException;

    T delete(ID id) throws SQLException;

    void delete(T entity) throws SQLException;

    void releaseConnection();
}
