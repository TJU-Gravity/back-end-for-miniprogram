package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Apply;
import com.company.project.service.model.ApplyResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyMapper extends Mapper<Apply> {
     List<ApplyResult> getMyList(@Param("username")String username);

}
