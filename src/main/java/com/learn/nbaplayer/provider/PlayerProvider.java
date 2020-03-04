package com.learn.nbaplayer.provider;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengpengfei
 */
public class PlayerProvider {

    public String selectAllPlayers(){
        return "select * from nba_player";
    }


    public String selectById(@Param("id")String id){
        return "select * from nba_player where id = #{id}";

    }
}
