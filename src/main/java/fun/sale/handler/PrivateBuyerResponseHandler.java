package fun.sale.handler;

import fun.sale.builder.PrivateBuyerQuestionBuilder;
import fun.sale.builder.SoldCarQuestionBuilder;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import lombok.RequiredArgsConstructor;

import static fun.sale.constants.AnswerVariants.YES;

@RequiredArgsConstructor
public class PrivateBuyerResponseHandler extends AbstractResponseHandler {

    private final SoldCarQuestionBuilder soldCarQuestionBuilder;
    private final PrivateBuyerQuestionBuilder privateBuyerQuestionBuilder;

    @Override
    protected Question buildNextQuestion(Seller seller,
                                         String response) {
       return YES.equals(response)
                ? soldCarQuestionBuilder.build(seller, seller.getPrivateBuyerOffers())
                : privateBuyerQuestionBuilder.build(seller);
    }
}
