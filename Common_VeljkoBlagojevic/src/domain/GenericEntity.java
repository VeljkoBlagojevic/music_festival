/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();
    
    String getUpdateValues();

    Long getId();
    
    void setId(Long id);
    
    Iterable<GenericEntity> selectList(ResultSet rs) throws SQLException;
    
    String getAlias();

    String getJoinClause(FetchType fetch);

    Optional<GenericEntity> selectObject(ResultSet rs);
    
    default void prepareParametrizedValues(PreparedStatement preparedStatement) {}

}
