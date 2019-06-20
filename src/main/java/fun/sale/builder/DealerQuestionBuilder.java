package fun.sale.builder;

import fun.sale.domain.Buyer;
import fun.sale.domain.BuyerOffer;
import fun.sale.domain.Seller;
import fun.sale.handler.ResponseHandler;
import fun.sale.storage.BuyersStorage;

import java.util.List;

import static fun.sale.AppBeans.DEALER_HANDLER;
import static fun.sale.AppBeans.NO_DEALER_HANDLER;

public class DealerQuestionBuilder extends AbstractBuyerQuestionBuilder {

    public DealerQuestionBuilder(BuyersStorage buyersStorage) {
        super(buyersStorage);
    }

    @Override
    protected List<BuyerOffer> getBuyerOffers(Seller seller) {
        return seller.getDealerOffers();
    }

    @Override
    protected String getNoBuyerMessage() {
        return "Sorry, no more dealer available at the moment. Do you want to publish an ad?";
    }

    @Override
    protected String getOfferMessage(Buyer buyer,
                                     int price) {
        return String.format("Hi! My name is %s. I can buy your car for %d. Are you agree?", buyer.getName(), price);
    }

    @Override
    protected ResponseHandler getResponseHandler() {
        return DEALER_HANDLER;
    }

    @Override
    protected ResponseHandler getNoBuyerResponseHandler() {
        return NO_DEALER_HANDLER;
    }
}
