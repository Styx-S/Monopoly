package cn.styxs.monopoly.model;

import cn.styxs.monopoly.Service.GameService;
import lombok.Data;

import java.util.List;

@Data
public class Player {
    public enum PlayerState {
        alive,
        death,
    }

    int money; // 当前拥有的钱
    MapNode position; // 当前在地图上面哪个位置
    PlayerState state = PlayerState.alive;
    List<Property> properties; // 玩家当前拥有的
    Client device; // 对应哪一个用户

    public int cost(GameService game, int value) {
        if (money > value) {
            money -= value;
            return value;
        } else {
            this.state = PlayerState.death;
            game.playerDie(this);
            return money;
        }
    }
}
