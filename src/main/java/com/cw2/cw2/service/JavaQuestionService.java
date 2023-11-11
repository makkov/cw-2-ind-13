package com.cw2.cw2.service;

import com.cw2.cw2.entity.Question;
import com.cw2.cw2.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionForRemove = new Question(question, answer);
        questionRepository.remove(questionForRemove);
        return questionForRemove;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions = questionRepository.getAll();
        int randomIdx = new Random().nextInt(questions.size());
        return new ArrayList<>(questions).get(randomIdx);
    }
}
