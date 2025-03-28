/* UserRepositoryTest.java
Author: Agnes Mabusela (230020690)
Date: 26/03/2025
 */

package za.ac.cput.repository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)

class UserRepositoryTest {

        private static IUserRepository repository = UserRepository.getRepository();
        private User user = UserFactory.createUser("9892893872902", "Madikila","Agnes","Mabusela", "0762736725", "Agnes@gmail.com","Agnes12345","UNDEFINED");

    @Test
    void a_create() {
        User created = repository.create(user);
        assertNotNull(created);
        assertEquals(user.getUserIdentityNumber(), created.getUserIdentityNumber());
        System.out.println(created);
    }

    @Test
    void b_read() {
        User read = repository.read(user.getUserIdentityNumber());
        assertNotNull(read);
        assertEquals(user.getUserIdentityNumber(), read.getUserIdentityNumber());
        assertEquals(user.getUserFirstName(), read.getUserFirstName());
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        User  updatedUser = new User.Builder().copy(user).setUserFirstName("Jenny").build();
        User updated = repository.update(updatedUser);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    void d_delete() {
        assertTrue(repository.delete(user.getUserIdentityNumber()));
        assertNotNull(repository.read(user.getUserIdentityNumber()));
        System.out.println("Success: user deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(repository.getAll());
        assertTrue(repository.getAll().size() > 0);
    }
}