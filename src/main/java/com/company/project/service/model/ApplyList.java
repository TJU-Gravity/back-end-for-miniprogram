package com.company.project.service.model;

import java.util.List;

public class ApplyList {
    public ApplyList(List<ApplyResult> passed,List<ApplyResult> pending) {
        this.passed = passed;
        this.pending = pending;
    }
    public List<ApplyResult> passed;
    public List<ApplyResult> pending;
}
