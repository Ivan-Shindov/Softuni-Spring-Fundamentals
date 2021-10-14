package bg.softuni.Mobilelele.repository;

import bg.softuni.Mobilelele.model.entity.Role;
import bg.softuni.Mobilelele.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<Role,Long> {

    Role findByRole(RoleEnum role);

}
