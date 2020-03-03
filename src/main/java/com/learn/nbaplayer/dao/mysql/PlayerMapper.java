package com.learn.nbaplayer.dao.mysql;

import com.learn.nbaplayer.entity.NbaPlayer;
import com.learn.nbaplayer.provider.PlayerProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;


/**
 * @author chengpengfei
 */
public interface PlayerMapper{

    @SelectProvider(type = PlayerProvider.class,method = "selectAllPlayers")
    List<NbaPlayer> selectAllPlayers();

    @SelectProvider(type = PlayerProvider.class,method = "selectById")
    NbaPlayer selectById(@Param("id")String id);
}
