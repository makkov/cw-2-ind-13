package com.cw2.cw2.repository;

import com.cw2.cw2.entity.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
