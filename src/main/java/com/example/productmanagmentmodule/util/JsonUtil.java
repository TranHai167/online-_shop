package com.example.productmanagmentmodule.util;

import com.example.productmanagmentmodule.dto.BaseResponseNw;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;
import java.util.List;

@Slf4j
public final class JsonUtil {
    private JsonUtil(){
        throw new UnsupportedOperationException("This is a Utility class and cannot be instantiated");
    }

    public static <T> Page<T> applyPaging(List<T> data, Integer page, Integer size) {
        int start = page * size;
        int end = Math.min(start + size, data.size());
        List<T> pagedResult = start < data.size() ? data.subList(start, end) : Collections.emptyList();

        return new PageImpl<>(pagedResult, PageRequest.of(page, size), data.size());
    }

    public static <T> BaseResponseNw<T> createSuccessResponse(T data) {
        BaseResponseNw<T> res = new BaseResponseNw<>();
        res.setMessage("Successful!!");
        res.setCode(0);
        res.setStatus(0);
        res.setData(data);
        return res;
    }

}
