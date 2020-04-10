package cn.styxs.monopoly.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Client {
    long uid;
    String name;
}
