/* IAdminRepository.java
Author: Agnes Mabusela (230020690)
Date: 26/03/2025
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Admin;

import java.util.List;

public interface IAdminRepository extends IRepository<Admin, String > {

    List<Admin> getAll();

}
