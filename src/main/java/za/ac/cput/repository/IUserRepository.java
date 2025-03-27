/* IUserRepository.java
Admin model class
Author: Agnes Mabusela (230020690)
Date: 26/03/2025
 */
package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.util.List;

public interface IUserRepository  extends IRepository <User, String>{

    List<User> getAll();
}
