package softuni.angular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.angular.data.entities.Role;

import java.util.List;
import java.util.Set;

/**
 * Project: backend
 * Created by: GKirilov
 * On: 10/15/2021
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByCode(String code);

    List<Role> findAllByCodeIn(Set<String> rolesCode);
}
