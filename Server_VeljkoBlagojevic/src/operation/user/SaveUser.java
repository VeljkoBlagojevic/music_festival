/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.user;

import domain.User;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import operation.AbstractGenericOperation;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class SaveUser extends AbstractGenericOperation {

    private User user;
    private static String passwordError;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof User)) {
            throw new Exception("Parameter is not a type of  User");
        }

        User insertedUser = (User) param;
        List<User> dbUsers = (List<User>) repository.findAll(new User(), FetchType.LAZY);

        if (dbUsers.stream().anyMatch(dbUser -> dbUser.equals(insertedUser))) {
            throw new Exception("There already registered same user in database");
        }
        if (dbUsers.stream().anyMatch(dbUser -> dbUser.getUsername().equals(insertedUser.getUsername()))) {
            throw new Exception("There already registered user in database with the same username");
        }
//        if (passwordValidation(insertedUser.getPassword())) {
//            throw new Exception("Password is invalid! It must contain atleast 5 charachters with one letter, one digit and one special charachter");
//        }
        if (!isValidPassword(insertedUser.getPassword())) {
            throw new Exception("Password is invalid!\n" + passwordError);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        user = (User) repository.save(param);
    }

    public User getUser() {
        return user;
    }

    public static boolean passwordValidation(String password) {
        if (password.length() >= 5) {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            //Pattern eight = Pattern.compile (".{8}");

            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            return hasLetter.find() && hasDigit.find() && hasSpecial.find();
        }
        return false;

    }

    public static boolean isValidPassword(String password) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isValid = true;
        if (password.length() < 5) {
            stringBuilder.append("Password must be more than 5 characters in length.\n");
            isValid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            stringBuilder.append("Password must have atleast one uppercase character.\n");
            isValid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            stringBuilder.append("Password must have atleast one lowercase character.\n");
            isValid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            stringBuilder.append("Password must have atleast one number.\n");
            isValid = false;
        }
        String specialChars = "(.*[@,#,$,%,!].*$)";
        if (!password.matches(specialChars)) {
            stringBuilder.append("Password must have atleast one special character among @#$%!.\n");
            isValid = false;
        }
        passwordError = stringBuilder.toString();
        return isValid;
    }

}
