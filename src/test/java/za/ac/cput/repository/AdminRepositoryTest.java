/* AdminRepositoryTest.java
Author: Agnes Mabusela (230020690)
Date: 28/03/2025
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class AdminRepositoryTest {

    private static IAdminRepository repository = AdminRepository.getRepository();
    private Admin admin = AdminFactory.createAdmin("A1234343","Madikila"," Agnes ", "Mabusela", "8292837883788","AgnesMabusela@gmail.com","Agnes123","ADMIN", LocalDateTime.parse("28 March 2025"), "ACTIVE");

    @Test
    void a_create() {
        Admin created = repository.create(admin);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read(){
        Admin read = repository.read(admin.getUserIdentityNumber());
        assertNotNull(read);
        System.out.println(read.toString());
    }
    @Test
    void c_update(){
        Admin newAdmin = (Admin) new Admin.Builder().copy(admin).setUserLastName("Mabusela").build();
        Admin updated = repository.update(newAdmin);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }
    @Test
    void d_delete(){
        assertTrue(repository.delete(admin.getUserIdentityNumber()));
        System.out.println("Success: admin deleted");
    }

    @Test
    void e_getAll(){
        System.out.println(repository.getAll());
        assertTrue(repository.getAll().size() > 0);
    }

}
