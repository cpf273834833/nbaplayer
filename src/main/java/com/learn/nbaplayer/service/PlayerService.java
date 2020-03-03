package com.learn.nbaplayer.service;

import com.learn.nbaplayer.entity.NbaPlayer;

import java.util.Iterator;
import java.util.List;

public interface PlayerService {


    boolean addPlayer(NbaPlayer player,String id);

    Iterator<NbaPlayer> findAll();

    Integer importAll();
}
