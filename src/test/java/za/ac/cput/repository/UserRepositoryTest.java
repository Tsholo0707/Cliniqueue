/* UserRepository.java
Admin model class
Author: Agnes Mabusela (230020690)
Date: 26/03/2025
 */

package za.ac.cput.repository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodsOrder(MethodOrderer.MethodName.class)

class UserRepositoryTest {

        private static IUserRepository repository = UserRepository.getRepository();
        private User user = UserFactory.createUser("");

    @Test
    void a_create() {
        User created = repository.create(user);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        User read = repository.read(user.getUserIdentityNumber());
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        User  newUser = new User.Builder().copy(user).setUserFirstName("").build();
        User updated = repository.create(newUser);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    void d_delete() {
        assertTrue(repository.delete(user.getUserIdentityNumber()));
        System.out.println("Success: employee deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(repository.getAll());
    }
}