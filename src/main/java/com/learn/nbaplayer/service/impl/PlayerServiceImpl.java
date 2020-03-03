package com.learn.nbaplayer.service.impl;

import com.learn.nbaplayer.entity.NbaPlayer;
import com.learn.nbaplayer.dao.es.PlayerRepository;
import com.learn.nbaplayer.dao.mysql.PlayerMapper;
import com.learn.nbaplayer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author chengpengfei
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerMapper playerMapper;


    @Override
    public boolean addPlayer(NbaPlayer player, String id) {
        return false;
    }


    @Override
    public Iterator<NbaPlayer> findAll() {
        return playerRepository.findAll().iterator();
    }


    @Override
    public Integer importAll(){
        List<NbaPlayer> nbaPlayers = playerMapper.selectAllPlayers();
        Iterable<NbaPlayer> result = playerRepository.saveAll(nbaPlayers);
        Iterator<NbaPlayer> iterator = result.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }
        return count;

    }
}
