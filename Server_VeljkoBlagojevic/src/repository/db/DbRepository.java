/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import repository.Repository;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VeljkoBlagojevic
 * @param <T>
 * @param <ID>
 */
public interface DbRepository<T, ID> extends Repository<T, ID> {

    default public Connection connect() throws Exception {
        try {
            return DbConnectionFactory.getInstance().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(DbRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    default public void disconnect() {
        try {
            DbConnectionFactory.getInstance().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(DbRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    default public void commit() {
        try {
            DbConnectionFactory.getInstance().getConnection().commit();
        } catch (Exception ex) {
            Logger.getLogger(DbRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    default public void rollback() {
        try {
            DbConnectionFactory.getInstance().getConnection().rollback();
        } catch (Exception ex) {
            Logger.getLogger(DbRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
