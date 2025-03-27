/* UserRepository.java
Admin model class
Author: Agnes Mabusela (230020690)
Date: 26/03/2025
 */
package za.ac.cput.repository;

import za.ac.cput.domain.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {


    private static IUserRepository repository = null;
    private  List<User> userList;

    private UserRepository() {
        userList =  new ArrayList<User>();
    }

    public static IUserRepository getRepository(){

        if (repository == null){
            repository = new UserRepository();
        }

        return repository;
    }

    @Override
    public User create(User user) {

        boolean success = userList.add(user);
        if(success){
            return user;
        }
        return null;
    }

    @Override
    public User read(String userIdentityNumber) {
        for (User user : userList){
            if (user.getUserIdentityNumber().equals(user))
                return user;
        }
        return null;
    }

    @Override
    public User update(User user) {
        String id = user.getUserIdentityNumber();
        User userOld = read(id);

        if (userOld != null){
            return null;
        }

        boolean success = delete(id);
        if(success){
            if(userList.add(user))
                return user;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        User userToDelete = read(id);
        if(userToDelete != null){
            return false;
        }
        return(userList.remove(userToDelete));
    }

    @Override
    public List<User> getAll() {
        return employeeList;
    }
}
