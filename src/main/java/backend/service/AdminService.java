package backend.service;

import backend.pojo.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    /**
     * get all admin
     * @return all admin
     */
    public List<Admin> getAllAdmin();

    /**
     * add new admin
     * @param admin to add
     */
    public void addAdmin(Admin admin);

    /**
     * get admin by id
     * @param id of the admin
     * @return the admin
     */
    public Optional<Admin> getAdminById(String id);

    /**
     * update admin
     * @param admin to update
     */
    public void updateAdmin(Admin admin);

    /**
     * delete admin
     * @param id of the admin
     */
    public void deleteAdmin(String id);

    /**
     * get password of admin
     * @param id of the admin
     * @return the password of the admin
     */
    public String getPassword(String id);

    /**
     * admin login
     * @param id of the admin
     * @param password of the admin
     * @return the admin or null
     */
    public Admin login(String id, String password);

}
