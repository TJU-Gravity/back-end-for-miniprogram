package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.Apply;
import com.company.project.service.model.ApplyList;
import com.company.project.service.model.ApplyResult;

import java.util.List;

public interface ApplyService extends Service<Apply> {
    ApplyList getMyList(String username);
    Apply check(List<String> usernames);
}
