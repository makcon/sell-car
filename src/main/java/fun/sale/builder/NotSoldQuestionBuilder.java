package fun.sale.builder;

import fun.sale.domain.Question;
import fun.sale.domain.Seller;

import java.util.List;

import static fun.sale.AppBeans.LAST_STEP_HANDLER;
import static fun.sale.constants.AnswerVariants.NO;
import static fun.sale.constants.AnswerVariants.YES;

public class NotSoldQuestionBuilder {

    public Question build(Seller seller) {
        return Question.builder()
                .seller(seller)
                .text("Unfortunately, you didn't sell your car but we are waiting for you again. Do you want to continue?")
                .answerVariants(List.of(YES, NO))
                .responseHandler(LAST_STEP_HANDLER)
                .build();
    }
}
