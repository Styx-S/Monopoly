package cn.styxs.monopoly.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class Game {
    public enum GameState {
        next, // 继续下一个玩家
        wait_buy, // 等待玩家选择是否买地
        wait_upgrade, // 等待玩家选择是否升级
    }
    GameState state = GameState.next;
    Map map;
    List<Player> players;

    int currentPlayerIndex = 0;

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void start() {
        for (Player p : players) {
            p.setPosition(map.getMapNodes().get(0));
        }
    }
}
