package ICAT.backend.service;

import ICAT.backend.pojo.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * get all user
     * @return the list of the user
     */
    public List<User> getAllUser();

    /**
     * add new user
     * @param user to add
     */
    public void addUser(User user);

    /**
     * delete a user
     * @param id of the user to be deleted
     */
    public void deleteUserById(String id);

    /**
     * update a user
     * @param user to update
     */
    public void updateUser(User user);

    /**
     * change user's password
     * @param id of the user
     * @param password new password
     */
    public void changePassword(String id, String password);

    /**
     * user login
     * @param id of the user
     * @param password of the user
     * @return the user or null
     */
    public User login(String id, String password);

    /**
     * get user by id
     * @param id of the user to query
     * @return the user with the id
     */
    public Optional<User> getUserById(String id);

}
