package alex.tir.cloud_storage_back.repo;

import alex.tir.cloud_storage_back.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
    @Query("SELECT r FROM Role r WHERE r.name = 'USER'")
    Role getUserRole();
}
