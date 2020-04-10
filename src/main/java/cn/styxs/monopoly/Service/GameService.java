package cn.styxs.monopoly.Service;

import cn.styxs.monopoly.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class GameService {
    Game game;

    HashMap<Client, Player> map = new HashMap<>();

    public void start(List<Client> clients) {
        game = new Game();
        ArrayList<Player> players = new ArrayList<>();
        for (Client client : clients) {
            Player p = new Player();
            p.setDevice(client);
            players.add(p);
        }
        game.setPlayers(players);

        // TODO: 地图放进数据库
        Map map = new Map();
        map.setGroups(new ArrayList<>());
        PropertyGroup groupA = new PropertyGroup("A");
        map.getGroups().add(groupA);
        Property A1 = Property.builder().price(50).group(groupA).build();
                A1.setName("A1");
        Property A2 = Property.builder().price(50).group(groupA).build();
                A2.setName("A2");
        Property A3 = Property.builder().price(70).group(groupA).build();
                A3.setName("A3");
        map.addProperty(A1);
        map.addProperty(A2);
        map.addProperty(A3);
        PropertyGroup groupB = new PropertyGroup("B");
        map.getGroups().add(groupB);
        Property B1 = Property.builder().price(50).group(groupB).build();
        B1.setName("B1");
        Property B2 = Property.builder().price(50).group(groupB).build();
        B2.setName("B2");
        map.addProperty(B1);
        map.addProperty(B2);

        game.setMap(map);
        game.start();
    }

    public void roll(Client client) {
        Player p = game.getPlayers().get(game.getCurrentPlayerIndex());
        if (! p.getDevice().equals(client)) {
            return;
        }
        int step = randomStep();
        for (int i = 0; i < step; i++) {
            p.setPosition(p.getPosition().getNextNode());
        }
        p.getPosition().getProperty().onPlayerArrive(this, p);
    }


    public static int randomStep() {
        return new Random().nextInt(6) + 1;
    }

    public void playerDie(Player player) {

    }

    public void setState(Game.GameState state) {
        this.game.setState(state);
        if (state == Game.GameState.next) {
            game.nextPlayer();
        }
    }

    public Game action(Client client, int action) {
        Player p = map.get(client);
        Game.GameState state = this.game.getState();
        if (state == Game.GameState.next) {
            roll(client);
        }else if (state == Game.GameState.wait_buy) {
            if (action == 0) {
                setState(Game.GameState.next);
            } else {
                // ...
            }
        } else if (state == Game.GameState.wait_upgrade) {
            // ...
        }
        return game;
    }

    public Game getGame() {
        return game;
    }
}
