package com.example.productmanagmentmodule.service;


import com.example.productmanagmentmodule.entity.Products;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RawQueryService {
    private final EntityManager entityManager;

    public List<Products> searchItem(Integer page, Integer size, String keyWord){
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlWhereCondition = new StringBuilder();
        sqlWhereCondition.append("WHERE 1 = 1 ");

        sql.append("SELECT * FROM item ");

        // Tim theo keyWord
        if (keyWord != null && !keyWord.isBlank()){
            sqlWhereCondition.append(" AND UPPER(name) LIKE :keyWord ");
        }

        sql.append(sqlWhereCondition);
        log.info("[PRODUCTS]: Get item list: {}", sql);
        Query dataQuery = entityManager.createNativeQuery(String.valueOf(sql), Products.class);
        setQueryParameter(dataQuery, keyWord);

        return dataQuery.getResultList();
    }

    private void setQueryParameter(Query dataQuery, String keyWord){
        if (keyWord != null && !keyWord.isBlank()){
            dataQuery.setParameter("keyWord", "%" + keyWord.trim().toUpperCase() + "%");
        }
    }
}
