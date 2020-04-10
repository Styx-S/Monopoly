package cn.styxs.monopoly.model;

import java.util.List;

public class Room {
    Long id; // 房间号
    List<Client> clients; // 当前在房间里的玩家
    Game game; // 游戏


    public enum RoomState{
        Waiting, // 还没开始
        Playing, // 游戏中
    }
}
