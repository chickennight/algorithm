package com.personal.algorithm.util.jwt;

import com.personal.algorithm.entity.Player;
import com.personal.algorithm.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final PlayerRepository playerRepository;

    @Autowired
    public UserDetailsServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String playerId) throws UsernameNotFoundException {
        Optional<Player> playerOptional = playerRepository.findByPlayerId(playerId);

        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            if (player.isAdmin())
                return new User(player.getPlayerId(), player.getPassword(), AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
            else return new User(player.getPlayerId(), player.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException(playerId + "사용자 없음");
        }
    }

}