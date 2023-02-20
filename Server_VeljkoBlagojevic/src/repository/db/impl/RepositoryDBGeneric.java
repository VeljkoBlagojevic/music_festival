/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;

import domain.GenericEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import operation.FetchType;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author Cartman
 */
public class RepositoryDBGeneric implements DbRepository<GenericEntity, Long> {

//    public void add(GenericEntity entity) throws Exception {
//        try {
//            Connection connection = DbConnectionFactory.getInstance().getConnection();
//            StringBuilder sb = new StringBuilder();
//            sb.append("INSERT INTO ")
//                    .append(entity.getTableName())
//                    .append(" (").append(entity.getColumnNamesForInsert()).append(")")
//                    .append(" VALUES (")
//                    .append(entity.getInsertValues())
//                    .append(")");
//            String query = sb.toString();
//            System.out.println(query);
//            ResultSet rsKey;
//            try (Statement statement = connection.createStatement()) {
//                statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
//                rsKey = statement.getGeneratedKeys();
//                if (rsKey.next()) {
//                    Long id = rsKey.getLong(1);
//                    entity.setId(id);
//                }
//            }
//            rsKey.close();
//        } catch (SQLException ex) {
//            throw ex;
//        }
//    }
    @Override
    public Long count(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String sqlQuery = "SELECT COUNT(*) AS total FROM " + entity.getTableName();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            rs.first();
            final Long count = rs.getLong("total");
            return count;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void delete(GenericEntity entity) throws Exception {

        //izgleda da ne radi iz nekog razloga
        try {
            String sqlQuery = "DELETE FROM " + entity.getTableName() + " WHERE id = ?";
            System.out.println(sqlQuery);
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, entity.getId());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("Did not delete anything!");
            }
            if (affectedRows > 1) {
                throw new Exception("Deleted multiple bands!");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void deleteAll(GenericEntity entity) throws Exception {
        try {
            String sqlQuery = "DELETE FROM " + entity.getTableName();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Deleted " + affectedRows + " entities from table " + entity.getTableName());
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void deleteAll(GenericEntity entity, Iterable<? extends GenericEntity> entities) throws Exception {
        final String formattedIDs = StreamSupport.stream(entities.spliterator(), false)
                .mapToLong(GenericEntity::getId)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        String sqlQuery = "DELETE FROM " + entity.getTableName() + " WHERE id IN (" + formattedIDs + ")";

        System.out.println(sqlQuery);

        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            connection.createStatement().execute(sqlQuery);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void deleteAllByIDs(GenericEntity entity, Iterable<? extends Long> ids) throws Exception {
        final String formattedIDs = StreamSupport.stream(ids.spliterator(), false)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        String sqlQuery = "DELETE FROM " + entity.getTableName() + " WHERE id IN (" + formattedIDs + ")";

        System.out.println(sqlQuery);
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            connection.createStatement().execute(sqlQuery);
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Override
    public void deleteByID(GenericEntity entity, Long id) throws Exception {
        String sqlQuery = "DELETE FROM " + entity.getTableName() + " WHERE id = ?";
        System.out.println(sqlQuery);
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("Did not delete anything!");
            }
            if (affectedRows > 1) {
                throw new Exception("Deleted multiple bands!");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public boolean existsByID(GenericEntity entity, Long id) throws Exception {
        String sqlQuery = "SELECT * FROM " + entity.getTableName() + " WHERE id = ?";
        System.out.println(sqlQuery);
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);
            final boolean exists = preparedStatement.execute();
            return exists;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Iterable<GenericEntity> findAll(GenericEntity entity, FetchType fetch) throws Exception {
        String sqlQuery = "SELECT * FROM " + entity.getTableName() + " " + entity.getAlias() + " " + entity.getJoinClause(fetch);
        System.out.println(sqlQuery);
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            return entity.selectList(rs);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Iterable<GenericEntity> findAllByIDs(GenericEntity entity, Iterable<Long> ids) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<GenericEntity> findByID(GenericEntity entity, Long id) throws Exception {
        String sqlQuery = "SELECT * FROM " + entity.getTableName() + " " + entity.getAlias() + " " + entity.getJoinClause(FetchType.EAGER) + " WHERE " + entity.getAlias() + ".id = " + id;
        System.out.println(sqlQuery);
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            return entity.selectObject(rs);
        } catch (Exception ex) {
            throw ex;
//            return Optional.empty();
        }
    }

    @Override
    public <S extends GenericEntity> S save(S entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (").append(entity.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(entity.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            ResultSet rsKey;
            try ( Statement statement = connection.createStatement()) {
                statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                rsKey = statement.getGeneratedKeys();
                if (rsKey.next()) {
                    Long id = rsKey.getLong(1);
                    entity.setId(id);
                }
            }
            rsKey.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return entity;
    }

    @Override
    public <S extends GenericEntity> Iterable<S> saveAll(GenericEntity entity, Iterable<S> entities) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (")
                    .append(entity.getColumnNamesForInsert())
                    .append(")")
                    .append(" VALUES (");

            String formattedPlaceholders = Arrays.stream(entity.getColumnNamesForInsert().split(","))
                    .map(column -> "?")
                    .collect(Collectors.joining(","));

//            for (int i = 0; i < entity.getColumnNamesForInsert().split(",").length; i++) {
//                sb.append("?");
//            }
            sb.append(formattedPlaceholders);
            sb.append(")");

            String sqlQuery = sb.toString();
            System.out.println(sqlQuery);

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

//            StreamSupport
//                    .stream(entities.spliterator(), false)
//                    .forEach(s -> {
//                        try {
//                            s.prepareParametrizedValues(preparedStatement);
//                            preparedStatement.addBatch();
//                        } catch (SQLException ex) {
//                            Logger.getLogger(RepositoryDBGeneric.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    });
            for (S s : entities) {
                s.prepareParametrizedValues(preparedStatement);
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            for (S s : entities) {
                generatedKeys.next();
                s.setId(generatedKeys.getLong(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return entities;
    }

    @Override
    public <S extends GenericEntity> S update(S entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String sqlQuery = "UPDATE " + entity.getTableName() + " SET " + entity.getUpdateValues() + " WHERE id = " + entity.getId();
            System.out.println(sqlQuery);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
            return entity;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
