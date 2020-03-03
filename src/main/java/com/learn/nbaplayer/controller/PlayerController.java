package com.learn.nbaplayer.controller;

import com.learn.nbaplayer.entity.NbaPlayer;
import com.learn.nbaplayer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;


    /**
     * 把数据从mysql 导入 es
     * @return
     */
    @PostMapping("/import")
    public Integer importAllList(){
        return playerService.importAll();
    }


    /**
     * 查询es 所有球员信息
     * @return
     */
    @GetMapping("list")
    public Iterator<NbaPlayer> getAllPlayers(){
        return playerService.findAll();
    }



}
