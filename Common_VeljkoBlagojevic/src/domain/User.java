package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.FetchType;

public class User /* Korisnik */ implements GenericEntity {

    private Long userID;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    public User() {
    }

    public User(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public User(Long id, String firstname, String lastname, String username, String password) {
        this.userID = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.userID);
        hash = 73 * hash + Objects.hashCode(this.firstname);
        hash = 73 * hash + Objects.hashCode(this.lastname);
        hash = 73 * hash + Objects.hashCode(this.username);
        hash = 73 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.userID, other.userID);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

    public boolean hasAdequateCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "firstname, lastname, username, password";
    }

    @Override
    public String getInsertValues() {
        return "'" + firstname + "', '" + lastname + "', '" + username + "', '" + password + "'";
    }

    @Override
    public void setId(Long id) {
        this.userID = id;
    }

    @Override
    public Long getId() {
        return userID;
    }

    @Override
    public Iterable<GenericEntity> selectList(ResultSet rs) throws SQLException {
        List<GenericEntity> users = new ArrayList<>();
        try (rs) {
            while (rs.next()) {
                User user = new User(
                        rs.getLong("u.id"),
                        rs.getString("u.firstname"),
                        rs.getString("u.lastname"),
                        rs.getString("u.username"),
                        rs.getString("u.password"));
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public String getUpdateValues() {
        return "firstname = '" + firstname + "', lastname = '" + lastname + "', username = '" + username + "', password = '" + password + "'";
    }

    @Override
    public String getAlias() {
        return "u";
    }

    @Override
    public String getJoinClause(FetchType fetch) {
        return "";
    }

    @Override
    public Optional<GenericEntity> selectObject(ResultSet rs) {
        User user;
        try {
            if (rs.next()) {
                user = new User(
                        rs.getLong("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            } else {
                return Optional.empty();
            }
            return Optional.of(user);
        } catch (SQLException ex) {
            Logger.getLogger(Band.class.getName()).log(Level.SEVERE, null, ex);
            return Optional.empty();
        }
    }

}
