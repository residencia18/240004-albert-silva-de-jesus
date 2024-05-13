package br.com.residenciatic18.avaliacao.api.ap002.jwt;

import lombok.RequiredArgsConstructor;

import br.com.residenciatic18.avaliacao.api.ap002.entity.UserSystem;
import br.com.residenciatic18.avaliacao.api.ap002.service.UserSystemService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserSystemService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSystem usuario = usuarioService.searchByUsername(username);
        return new JwtUserDetails(usuario);
    }

    public JwtToken getTokenAuthenticated(String username) {
        UserSystem.Role role = usuarioService.searchRoleByUsername(username);
        return JwtUtils.createToken(username, role.name().substring("ROLE_".length()));
    }
}
