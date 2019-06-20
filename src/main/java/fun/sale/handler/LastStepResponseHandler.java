package fun.sale.handler;

import fun.sale.constants.StaticQuestions;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import fun.sale.storage.SellersStorage;
import lombok.RequiredArgsConstructor;

import static fun.sale.constants.AnswerVariants.YES;

@RequiredArgsConstructor
public class LastStepResponseHandler extends AbstractResponseHandler {

    private final SellersStorage sellersStorage;

    @Override
    protected Question buildNextQuestion(Seller seller,
                                         String response) {
        seller.getDealerOffers().clear();
        seller.getPrivateBuyerOffers().clear();
        sellersStorage.save(seller);

        return YES.equals(response)? StaticQuestions.FIRST_QUESTION : null;
    }
}
