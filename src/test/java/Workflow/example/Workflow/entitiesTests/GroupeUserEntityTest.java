package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.GroupeUser;
import workflow.example.workflow.entity.User;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class GroupeUserEntityTest {

    @Test
    void testGroupeUserEqualsAndHashCode() {
        GroupeUser groupeUser1 = new GroupeUser(1L, "Group1", "Description1", new HashSet<>());
        GroupeUser groupeUser2 = new GroupeUser(1L, "Group2", "Description2", new HashSet<>());

        Assertions.assertEquals(groupeUser1, groupeUser2);
        Assertions.assertEquals(groupeUser1.hashCode(), groupeUser2.hashCode());
    }

    @Test
    void testGroupeUserNotEquals() {
        GroupeUser groupeUser1 = new GroupeUser(1L, "Group1", "Description1", new HashSet<>());
        GroupeUser groupeUser2 = new GroupeUser(2L, "Group2", "Description2", new HashSet<>());

        Assertions.assertNotEquals(groupeUser1, groupeUser2);
    }

    @Test
    void testGroupeUserUsersRelationship() {
        GroupeUser groupeUser = new GroupeUser();
        User user = mock(User.class);

        Set<User> users = new HashSet<>();
        users.add(user);

        groupeUser.setUsers(users);

        Assertions.assertEquals(users, groupeUser.getUsers());
    }

    @Test
    void testToString() {
        GroupeUser groupeUser = new GroupeUser();
        groupeUser.setId(1L);
        groupeUser.setNom("Team A");
        groupeUser.setDescription("A great team");
        Assertions.assertNotNull(groupeUser.toString());
    }

    @Test
    void testEquals() {
        GroupeUser group1 = new GroupeUser();
        group1.setId(1L);

        GroupeUser group2 = new GroupeUser();
        group2.setId(1L);

        GroupeUser group3 = new GroupeUser();
        group3.setId(2L);

        Assertions.assertEquals(group1, group2);
        Assertions.assertNotEquals(group1, group3);
    }

    @Test
    void testHashCode() {
        GroupeUser groupeUser = new GroupeUser();
        groupeUser.setId(1L);

        Assertions.assertEquals(groupeUser.hashCode(), groupeUser.getClass().hashCode());
    }

}
