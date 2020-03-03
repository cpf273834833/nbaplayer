package com.learn.nbaplayer.controller;

import com.github.pagehelper.PageInfo;
import com.learn.nbaplayer.entity.NbaPlayer;
import com.learn.nbaplayer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * @author chengpengfei
 */
@RestController
@RequestMapping("player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;


    /**
     * 把数据从mysql 导入 es
     */
    @PostMapping("/importEs")
    public Integer importAllList(){
        return playerService.importAll();
    }


    /**
     * 查询es 所有球员信息
     */
    @GetMapping("list")
    public Iterator<NbaPlayer> getAllPlayers(){
        return playerService.findAll();
    }


    /**
     * 根据id 删除es 记录
     */
    @PostMapping("delete/{id}")
    public Boolean delete(@PathVariable String id){
        return playerService.delete(id);
    }


    /**
     * 根据id 从mysql新增一条记录到es
     */
    @PostMapping("create/{id}")
    public NbaPlayer create(@PathVariable String id){
        return playerService.create(id);
    }

    /**
     *  根据id查询
     */
    @GetMapping("search/{id}")
    public NbaPlayer search(@PathVariable String id){
        return playerService.searchById(id);
    }


    /**
     * 简单查询 country countryEn
     */
    @PostMapping("search/simple")
    public Page<NbaPlayer> searchSimple(@RequestParam(required = false) String keyword,
                                  @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize){
        return playerService.searchSimple(keyword,pageNum,pageSize);
    }

    /**
     * 复杂查询
     */
    @PostMapping("search/complicate")
    public Page<NbaPlayer> searchComplicate(@RequestParam(required = false) String keyword,
                                  @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize){
        return playerService.searchComplicate(keyword,pageNum,pageSize);

    }

}
