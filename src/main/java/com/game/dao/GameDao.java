package com.game.dao;

import java.util.List;

import com.game.dto.GameInfo;

public interface GameDao {
public List<GameInfo> checkLink(String packageName);
}
