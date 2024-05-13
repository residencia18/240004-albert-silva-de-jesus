package br.com.residenciatic18.avaliacao.api.ap002.repository;

import br.com.residenciatic18.avaliacao.api.ap002.entity.UserSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem, Long> {
    
    Optional<UserSystem> findByUsername(String username);

    @Query("select u.role from UserSystem u where u.username like :username")
    UserSystem.Role findRoleByUsername(String username);
}
