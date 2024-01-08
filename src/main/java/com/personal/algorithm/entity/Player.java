package com.personal.algorithm.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_num")
    private long playerNum;

    @Column(name = "player_id", unique = true, nullable = false)
    private String playerId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nick_name", nullable = false)
    private String nickName;

    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    @Column(name = "is_admin")
    @ColumnDefault("false")
    private boolean isAdmin;

    public Player(String playerId, String password, String nickName, String phoneNumber) {
        this.playerId = playerId;
        this.password = password;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }
}
