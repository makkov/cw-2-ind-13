package com.cw2.cw2.service;

import com.cw2.cw2.entity.Question;
import com.cw2.cw2.repository.JavaQuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionService javaQuestionService;


    @Test
    void add() {
        //Подготовка входных данных
        String answer = "answer";
        String question = "question";

        //Подготовка ожидаемого результат
        Question expectedQuestion = new Question(question, answer);
        when(javaQuestionRepository.add(eq(expectedQuestion))).thenReturn(expectedQuestion);

        //Начало теста
        Question actualQuestion = javaQuestionService.add(question, answer);
        assertEquals(expectedQuestion, actualQuestion);
        verify(javaQuestionRepository).add(expectedQuestion);
    }
}
