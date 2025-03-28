/* AdminRepository.java
Author: Agnes Mabusela (230020690)
Date: 26/03/2025
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Admin;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository implements IAdminRepository {


    private static IAdminRepository repository = null;
    private List<Admin> adminList;


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

        boolean success = adminList.add(admin);
        if(success) {
            return admin;
        }
        return null;
    }

    @Override
    public Admin read(String adminIdentityNumber) {
        for(Admin admin : adminList){
            if(admin.getUserIdentityNumber().equals(adminIdentityNumber)){
                return admin;
            }
        }
        return null;
    }

    @Override
    public Admin update(Admin admin) {
        String id = admin.getUserIdentityNumber();;
        Admin adminOld = read(id);

        if(adminOld != null){
            adminList.remove(adminOld);
            adminList.add(admin);
            return admin;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
         Admin adminToDelete = read(id);
         if(adminToDelete == null) {
             return false;
         }
         return adminList.remove(adminToDelete);
    }

    @Override
    public List<Admin> getAll() {
        return adminList;
    }

}
