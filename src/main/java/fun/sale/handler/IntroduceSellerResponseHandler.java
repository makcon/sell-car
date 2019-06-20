package fun.sale.handler;

import fun.sale.builder.CarDetailsQuestionBuilder;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import fun.sale.storage.SellersStorage;
import fun.sale.utils.SoldCarsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static fun.sale.AppBeans.RECOGNIZE_SELLER_HANDLER;
import static fun.sale.constants.AnswerVariants.NO;
import static fun.sale.constants.AnswerVariants.YES;

@RequiredArgsConstructor
public class IntroduceSellerResponseHandler extends AbstractResponseHandler {

    private final CarDetailsQuestionBuilder carDetailsQuestionBuilder;
    private final SellersStorage sellersStorage;

    @Override
    protected Question buildNextQuestion(Seller seller,
                                         String response) {
        return sellersStorage.findByName(response)
                .map(this::getQuestionForExisted)
                .orElseGet(() -> carDetailsQuestionBuilder.build(new Seller(response)));
    }

    private Question getQuestionForExisted(Seller seller) {
        var text = seller.getSoldCars().isEmpty()
                ? buildTextForEmptySoldCars(seller)
                : buildTextForSoldCars(seller);

        return Question.builder()
                .seller(seller)
                .text(text)
                .responseHandler(RECOGNIZE_SELLER_HANDLER)
                .answerVariants(List.of(YES, NO))
                .build();
    }

    private String buildTextForSoldCars(Seller seller) {
        return String.format(
                "Hi %s! Welcome back. We know you already sold these cars:\n%s\n Is it you?",
                seller.getName(),
                SoldCarsConstructor.construct(seller.getSoldCars())
        );
    }

    private String buildTextForEmptySoldCars(Seller seller) {
        return String.format(
                "Hi %s! Seems we know you. You tried to sell cars but didn't. Is it you?",
                seller.getName()
        );
    }
}
