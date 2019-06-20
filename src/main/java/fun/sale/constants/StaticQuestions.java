package fun.sale.constants;

import fun.sale.domain.Question;
import lombok.experimental.UtilityClass;

import static fun.sale.AppBeans.INTRODUCE_SELLER_HANDLER;

@UtilityClass
public class StaticQuestions {

    public static final Question FIRST_QUESTION = Question.builder()
            .responseHandler(INTRODUCE_SELLER_HANDLER)
            .text("Hi! My name is Dillic, I'll help you to sell your car. What is you name?: ")
            .build();
}
