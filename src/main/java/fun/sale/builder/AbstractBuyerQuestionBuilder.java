package fun.sale.builder;

import fun.sale.domain.Buyer;
import fun.sale.domain.BuyerOffer;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import fun.sale.handler.ResponseHandler;
import fun.sale.storage.BuyersStorage;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static fun.sale.constants.AnswerVariants.NO;
import static fun.sale.constants.AnswerVariants.YES;

@RequiredArgsConstructor
public abstract class AbstractBuyerQuestionBuilder implements BuyerQuestionBuilder {

    private final BuyersStorage buyersStorage;

    @Override
    public Question build(Seller seller) {
        return buyersStorage.findRandom(getBuyerOffers(seller))
                .map(it -> createBuyer(it, seller))
                .orElseGet(() -> createNoBuyer(seller));
    }

    protected abstract List<BuyerOffer> getBuyerOffers(Seller seller);

    protected abstract String getNoBuyerMessage();

    protected abstract String getOfferMessage(Buyer buyer,
                                              int price);

    protected abstract ResponseHandler getResponseHandler();

    protected abstract ResponseHandler getNoBuyerResponseHandler();

    private Question createBuyer(Buyer buyer,
                                 Seller seller) {
        int price = calculatePrice(buyer, seller);
        getBuyerOffers(seller).add(new BuyerOffer(buyer, price));

        return Question.builder()
                .seller(seller)
                .text(getOfferMessage(buyer, price))
                .answerVariants(List.of(YES, NO))
                .responseHandler(getResponseHandler())
                .build();
    }

    private Question createNoBuyer(Seller seller) {
        return Question.builder()
                .seller(seller)
                .text(getNoBuyerMessage())
                .answerVariants(List.of(YES, NO))
                .responseHandler(getNoBuyerResponseHandler())
                .build();
    }

    private int calculatePrice(Buyer buyer,
                               Seller seller) {
        return Math.round(buyer.getDiscountFactor() * seller.getCar().getPrice());
    }
}
