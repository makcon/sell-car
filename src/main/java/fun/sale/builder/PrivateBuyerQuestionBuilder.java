package fun.sale.builder;

import fun.sale.domain.Buyer;
import fun.sale.domain.BuyerOffer;
import fun.sale.domain.Seller;
import fun.sale.handler.ResponseHandler;
import fun.sale.storage.BuyersStorage;

import java.util.List;

import static fun.sale.AppBeans.NO_PRIVATE_BUYER_HANDLER;
import static fun.sale.AppBeans.PRIVATE_BUYER_HANDLER;

public class PrivateBuyerQuestionBuilder extends AbstractBuyerQuestionBuilder {

    public PrivateBuyerQuestionBuilder(BuyersStorage buyersStorage) {
        super(buyersStorage);
    }

    @Override
    protected List<BuyerOffer> getBuyerOffers(Seller seller) {
        return seller.getPrivateBuyerOffers();
    }

    @Override
    protected String getNoBuyerMessage() {
        return "Seems no one of private buyers wants to buy your car. Do you want to sell it to a dealer?";
    }

    @Override
    protected String getOfferMessage(Buyer buyer,
                                     int price) {
        return String.format("Hi! My name is %s. I found your ad and want to buy your car for %d. Agreed?", buyer.getName(), price);
    }

    @Override
    protected ResponseHandler getResponseHandler() {
        return PRIVATE_BUYER_HANDLER;
    }

    @Override
    protected ResponseHandler getNoBuyerResponseHandler() {
        return NO_PRIVATE_BUYER_HANDLER;
    }
}
