package com.learn.nbaplayer.service;

import com.learn.nbaplayer.entity.NbaPlayer;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

/**
 * @author chengpengfei
 */
public interface PlayerService {


    Iterator<NbaPlayer> findAll();

    Integer importAll();

    Boolean delete(String id);

    NbaPlayer create(String id);

    NbaPlayer searchById(String id);

    Page<NbaPlayer> searchSimple(String keyword, Integer pageNum, Integer pageSize);

    Page<NbaPlayer> searchComplicate(String keyword, Integer pageNum, Integer pageSize);
}
