package br.com.residenciatic18.avaliacao.api.ap002.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.residenciatic18.avaliacao.api.ap002.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

  Optional<Token> findByToken(String token);

  Optional<Token> findByUserId(Long userId);

}
