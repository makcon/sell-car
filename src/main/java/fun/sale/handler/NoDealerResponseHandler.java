package fun.sale.handler;

import fun.sale.builder.AdQuestionBuilder;
import fun.sale.builder.NotSoldQuestionBuilder;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import lombok.RequiredArgsConstructor;

import static fun.sale.constants.AnswerVariants.YES;

@RequiredArgsConstructor
public class NoDealerResponseHandler extends AbstractResponseHandler {

    private final AdQuestionBuilder adQuestionBuilder;
    private final NotSoldQuestionBuilder notSoldQuestionBuilder;

    @Override
    protected Question buildNextQuestion(Seller seller,
                                         String response) {
        return YES.equals(response)
                ? adQuestionBuilder.build(seller)
                : notSoldQuestionBuilder.build(seller);
    }
}
