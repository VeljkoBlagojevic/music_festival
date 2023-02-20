/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.user;

import domain.User;
import exception.UserNotFoundException;
import java.util.List;
import operation.AbstractGenericOperation;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class FindAllUsers extends AbstractGenericOperation {

    private List<User> users;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof User)) {
            throw new Exception("Parameter is not a type of  User");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        users = (List<User>) repository.findAll(param, FetchType.LAZY);

        if (users.isEmpty()) {
            throw new UserNotFoundException();
        }
    }

    public List<User> getUsers() {
        return users;
    }

}
