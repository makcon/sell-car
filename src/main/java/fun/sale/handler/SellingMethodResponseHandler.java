package fun.sale.handler;

import fun.sale.builder.AdQuestionBuilder;
import fun.sale.builder.DealerQuestionBuilder;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import lombok.RequiredArgsConstructor;

import static fun.sale.constants.AnswerVariants.DEALER;

@RequiredArgsConstructor
public class SellingMethodResponseHandler extends AbstractResponseHandler {

    private final DealerQuestionBuilder dealerQuestionBuilder;
    private final AdQuestionBuilder adQuestionBuilder;

    @Override
    protected Question buildNextQuestion(Seller seller,
                                         String response) {
        return DEALER.equals(response)
                ? dealerQuestionBuilder.build(seller)
                : adQuestionBuilder.build(seller);
    }
}
