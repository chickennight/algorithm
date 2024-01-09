package com.personal.algorithm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.personal.algorithm.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    @JsonProperty("player_id")
    private String playerId;

    @JsonProperty("password")
    private String password;

    @JsonProperty("nick_name")
    private String nickName;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("is_admin")
    private boolean isAdmin;


    public Player toEntity() {
        return new Player(this.playerId, this.password, this.nickName, this.phoneNumber, this.isAdmin);
    }
}
