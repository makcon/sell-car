package fun.sale.builder;

import fun.sale.domain.BuyerOffer;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import fun.sale.domain.SoldCar;

import java.util.List;

import static fun.sale.AppBeans.LAST_STEP_HANDLER;
import static fun.sale.constants.AnswerVariants.NO;
import static fun.sale.constants.AnswerVariants.YES;

public class SoldCarQuestionBuilder {

    public Question build(Seller seller,
                          List<BuyerOffer> buyerOffers) {
        var lastOffer = buyerOffers.get(buyerOffers.size() - 1);
        var soldCar = SoldCar.builder()
                .price(lastOffer.getPrice())
                .buyer(lastOffer.getBuyer())
                .car(seller.getCar())
                .build();

        seller.getSoldCars().add(soldCar);

        return Question.builder()
                .seller(seller)
                .text("Congrats, you have sold your car! Welcome back again. Do you want to continue?")
                .answerVariants(List.of(YES, NO))
                .responseHandler(LAST_STEP_HANDLER)
                .build();
    }
}
