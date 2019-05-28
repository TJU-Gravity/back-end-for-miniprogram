package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Apply;
import com.company.project.model.Reply;
import com.company.project.model.UserTeam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyMapper extends Mapper<Apply> {
     Apply check(@Param("usernames")List<String> usernames);
}
