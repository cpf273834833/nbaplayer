package com.learn.nbaplayer.dao.es;

import com.learn.nbaplayer.entity.NbaPlayer;
import com.learn.nbaplayer.provider.PlayerProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/**
 * @author chengpengfei
 */
public interface PlayerRepository extends ElasticsearchRepository<NbaPlayer,String> {


}
