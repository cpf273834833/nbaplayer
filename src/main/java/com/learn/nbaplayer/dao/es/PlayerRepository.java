package com.learn.nbaplayer.dao.es;

import com.learn.nbaplayer.entity.NbaPlayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @author chengpengfei
 */
public interface PlayerRepository extends ElasticsearchRepository<NbaPlayer,String> {

    Page<NbaPlayer> findByCountryOrCountryEn(String country,String countyEn,Pageable pageable);
}
