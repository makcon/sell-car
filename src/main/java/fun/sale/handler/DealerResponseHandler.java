package fun.sale.handler;

import fun.sale.builder.DealerQuestionBuilder;
import fun.sale.builder.SoldCarQuestionBuilder;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import lombok.RequiredArgsConstructor;

import static fun.sale.constants.AnswerVariants.YES;

@RequiredArgsConstructor
public class DealerResponseHandler extends AbstractResponseHandler {

    private final SoldCarQuestionBuilder soldCarQuestionBuilder;
    private final DealerQuestionBuilder dealerQuestionBuilder;

    @Override
    protected Question buildNextQuestion(Seller seller,
                                         String response) {
        return YES.equals(response)
                ? soldCarQuestionBuilder.build(seller, seller.getDealerOffers())
                : dealerQuestionBuilder.build(seller);
    }
}
