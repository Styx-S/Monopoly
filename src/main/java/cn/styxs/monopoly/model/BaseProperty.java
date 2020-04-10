package cn.styxs.monopoly.model;

import cn.styxs.monopoly.Service.GameService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseProperty {
    String name; // 名字

    public void onPlayerArrive(GameService game, Player player) {
        // do nothing
        game.setState(Game.GameState.next);
    }
}
