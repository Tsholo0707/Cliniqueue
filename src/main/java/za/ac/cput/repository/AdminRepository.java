/* AdminRepository.java
Author: Agnes Mabusela (230020690)
Date: 26/03/2025
 */
package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.util.List;

public class AdminRepository implements IAdminRepository {


    private static IAdminRepository repository = null;
    private List<Admin> AdminList;


    private AdminRepository() {
            adminList = new ArrayList<Admin>();
    }

    public static IAdminRepository getRepository(){

        if(repository == null){
            repository =  new AdminRepository();
        }
        return repository;
    }

    @Override
    public Admin create(Admin admin) {

        boolean success = AdminList.add(admin);
        if(success) {
            return admin;
        }
        return null;
    }

    @Override
    public Admin read(String adminIdentityNumber) {
        for(Admin admin : adminList){
            if(admin.)
        }
        return null;
    }

    @Override
    public Admin update(Admin admin) {
        return null;
    }

    @Override
    public boolean delete(String id) {
         Admin adminToDelete = read(id);
         if(adminToDelete != null) {
             return false;
         }
         return(adminList.remove(adminToDelete));
    }

    @Override
    public List<User> getAll() {
        return employeeList;
    }

}
