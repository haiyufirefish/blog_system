package com.ff.blog;

import com.ff.blog.dao.pojo.Category;
import com.ff.blog.vo.CategoryVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CopyUtils<T,U> {
    //it needs to use reflection to generate new object
//    private T copy(U category) {
//        T categoryVo = new T();
//        BeanUtils.copyProperties(category,categoryVo);
//        return categoryVo;
//    }
//
//    private List<T> copyList(List<U> categoryList) {
//        List<T> categoryVoList = new ArrayList<>();
//        for(U u:categoryList){
//            categoryVoList.add(copy(u));
//        }
//        return categoryVoList;
//    }
}