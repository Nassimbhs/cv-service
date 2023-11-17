package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.ERole;
import workflow.example.workflow.entity.Role;

@ExtendWith(MockitoExtension.class)
class RoleEntityTest {

    @Test
    void testRoleEqualsAndHashCode() {
        Role role1 = new Role(1L, ERole.ROLE_USER);
        Role role2 = new Role(1L, ERole.ROLE_ADMIN);

        Assertions.assertEquals(role1, role2);
        Assertions.assertEquals(role1.hashCode(), role2.hashCode());
    }

    @Test
    void testRoleNotEquals() {
        Role role1 = new Role(1L, ERole.ROLE_USER);
        Role role2 = new Role(2L, ERole.ROLE_ADMIN);

        Assertions.assertNotEquals(role1, role2);
    }

    @Test
    void testToString() {
        Role role = new Role();
        role.setId(1L);
        role.setName(ERole.ROLE_USER);

        Assertions.assertNotNull(role.toString());
    }

    @Test
    void testEquals() {
        Role role1 = new Role();
        role1.setId(1L);

        Role role2 = new Role();
        role2.setId(1L);

        Role role3 = new Role();
        role3.setId(2L);

        Assertions.assertEquals(role1, role2);
        Assertions.assertNotEquals(role1, role3);
    }

    @Test
    void testHashCode() {
        Role role = new Role();
        role.setId(1L);
        Assertions.assertEquals(role.hashCode(), role.getClass().hashCode());
    }
    
}
