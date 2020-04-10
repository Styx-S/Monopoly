package cn.styxs.monopoly.model;

import cn.styxs.monopoly.Service.GameService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Property extends BaseProperty{
    int price; // 地价
    List<PropertyLevel> propertyLevelList; // 可以升级的
    int currentLevel = 0;
    PropertyGroup group;
    Player owner;

    @Override
    public void onPlayerArrive(GameService game, Player player) {
        if (owner == null) {
            // 玩家是否要购买这块地
            game.setState(Game.GameState.wait_buy);
        }
        else if (player.equals(owner)) {
            // 玩家是否要升级
            game.setState(Game.GameState.wait_upgrade);
        }
        else {
            // 玩家扣过路费
            owner.setMoney(owner.getMoney()+player.cost(game, getCost()));

        }
    }

    public int getCost() {
        // TODO: 把当前level对应的升级的过路费计算进去
        return price / 10;
    }
}
