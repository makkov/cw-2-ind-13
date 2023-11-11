package com.cw2.cw2.service;

import com.cw2.cw2.entity.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int size);
}
