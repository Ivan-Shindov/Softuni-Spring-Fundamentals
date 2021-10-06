package bg.softuni.Mobilelele.repository;

import bg.softuni.Mobilelele.entity.Role;
import bg.softuni.Mobilelele.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<Role,Long> {

    Role findByRole(RoleEnum role);

}
