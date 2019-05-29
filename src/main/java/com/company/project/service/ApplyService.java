package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.Apply;

import java.util.List;

public interface ApplyService extends Service<Apply> {
    Apply check(List<String> usernames);
    void delete(List<String> usernames);
}
