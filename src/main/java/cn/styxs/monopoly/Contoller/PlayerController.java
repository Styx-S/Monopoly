package cn.styxs.monopoly.Contoller;

import cn.styxs.monopoly.Service.GameService;
import cn.styxs.monopoly.model.Client;
import cn.styxs.monopoly.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class PlayerController {
    @Autowired
    GameService gameService;

    HashMap<Long, Client> map = new HashMap<>();

    @RequestMapping(value = "/action", method = RequestMethod.POST)
    public Game action(@RequestParam Long uid, @RequestParam int action) {
        return gameService.action(map.get(uid), action);
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public Game getGame() {
        return gameService.getGame();
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public Game start() {
        Client A = Client.builder().uid(1L).name("A").build();
        Client B = Client.builder().uid(2L).name("B").build();
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(A);
        clients.add(B);
        map.put(1L, A);
        map.put(2L, B);
        gameService.start(clients);
        return gameService.getGame();
    }
}
