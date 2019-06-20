package fun.sale.handler;

import fun.sale.builder.DealerQuestionBuilder;
import fun.sale.builder.NotSoldQuestionBuilder;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import fun.sale.storage.DealerStorage;
import lombok.RequiredArgsConstructor;

import static fun.sale.constants.AnswerVariants.YES;

@RequiredArgsConstructor
public class NoPrivateBuyerResponseHandler extends AbstractResponseHandler {

    private final DealerStorage dealerStorage;
    private final DealerQuestionBuilder dealerQuestionBuilder;
    private final NotSoldQuestionBuilder notSoldQuestionBuilder;

    @Override
    protected Question buildNextQuestion(Seller seller,
                                         String response) {
        return YES.equals(response)
                ? tryFindDealer(seller)
                : notSoldQuestionBuilder.build(seller);
    }

    private Question tryFindDealer(Seller seller) {
        return dealerStorage.findRandom(seller.getDealerOffers())
                .map(it -> dealerQuestionBuilder.build(seller))
                .orElseGet(() -> notSoldQuestionBuilder.build(seller));
    }
}
