package com.learn.nbaplayer.service.impl;

import com.learn.nbaplayer.entity.NbaPlayer;
import com.learn.nbaplayer.dao.es.PlayerRepository;
import com.learn.nbaplayer.dao.mysql.PlayerMapper;
import com.learn.nbaplayer.service.PlayerService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Boolean delete(String id) {
        playerRepository.deleteById(id);
        return true;
    }


    @Override
    public NbaPlayer create(String id) {
        NbaPlayer player = playerMapper.selectById(id);
        NbaPlayer result = playerRepository.save(player);
        return result;
    }


    @Override
    public NbaPlayer searchById(String id) {
        Optional<NbaPlayer> op = playerRepository.findById(id);
        return op.get();
    }

    @Override
    public Page<NbaPlayer> searchSimple(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        return playerRepository.findByCountryOrCountryEn(keyword,keyword,pageable);

    }

    @Override
    public Page<NbaPlayer> searchComplicate(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders = new ArrayList<>();
        filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("displayNameEn", keyword),
                ScoreFunctionBuilders.weightFactorFunction(8)));
        FunctionScoreQueryBuilder.FilterFunctionBuilder[] builders = new FunctionScoreQueryBuilder.FilterFunctionBuilder[filterFunctionBuilders.size()];
        filterFunctionBuilders.toArray(builders);
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(builders);
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(functionScoreQueryBuilder);
        builder.withPageable(pageable);
        NativeSearchQuery searchQuery = builder.build();
        System.out.println( searchQuery.getQuery().toString());

        return playerRepository.search(searchQuery);
    }

}
