package fun.sale;

import fun.sale.builder.*;
import fun.sale.handler.*;
import fun.sale.storage.DealerStorage;
import fun.sale.storage.PrivateBuyersStorage;
import fun.sale.storage.SellersStorage;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

/**
 * It is primitive emulator of beans container.
 */
@NoArgsConstructor(access = PRIVATE)
public final class AppBeans {

    public static final Game GAME_INSTANCE = new Game();

    public static final PrivateBuyersStorage PRIVATE_BUYERS_STORAGE = new PrivateBuyersStorage();
    public static final DealerStorage DEALERS_STORAGE = new DealerStorage();
    public static final SellersStorage SELLERS_STORAGE = new SellersStorage();

    public static final CarDetailsQuestionBuilder CAR_DETAILS_QUESTION_BUILDER = new CarDetailsQuestionBuilder();
    public static final PrivateBuyerQuestionBuilder PRIVATE_BUYER_QUESTION_BUILDER = new PrivateBuyerQuestionBuilder(PRIVATE_BUYERS_STORAGE);
    public static final DealerQuestionBuilder DEALER_QUESTION_BUILDER = new DealerQuestionBuilder(DEALERS_STORAGE);
    public static final AdQuestionBuilder AD_QUESTION_BUILDER = new AdQuestionBuilder();
    public static final SoldCarQuestionBuilder SOLD_CAR_QUESTION_BUILDER = new SoldCarQuestionBuilder();
    public static final NotSoldQuestionBuilder NOT_SOLD_QUESTION_BUILDER = new NotSoldQuestionBuilder();

    public static final IntroduceSellerResponseHandler INTRODUCE_SELLER_HANDLER = new IntroduceSellerResponseHandler(CAR_DETAILS_QUESTION_BUILDER, SELLERS_STORAGE);
    public static final RecognizeSellerResponseHandler RECOGNIZE_SELLER_HANDLER = new RecognizeSellerResponseHandler(CAR_DETAILS_QUESTION_BUILDER);
    public static final AdResponseHandler AD_HANDLER = new AdResponseHandler(PRIVATE_BUYER_QUESTION_BUILDER);
    public static final SellingMethodResponseHandler SELLING_METHOD_HANDLER = new SellingMethodResponseHandler(DEALER_QUESTION_BUILDER, AD_QUESTION_BUILDER);
    public static final PrivateBuyerResponseHandler PRIVATE_BUYER_HANDLER = new PrivateBuyerResponseHandler(SOLD_CAR_QUESTION_BUILDER, PRIVATE_BUYER_QUESTION_BUILDER);
    public static final NoPrivateBuyerResponseHandler NO_PRIVATE_BUYER_HANDLER = new NoPrivateBuyerResponseHandler(DEALERS_STORAGE, DEALER_QUESTION_BUILDER, NOT_SOLD_QUESTION_BUILDER);
    public static final NoDealerResponseHandler NO_DEALER_HANDLER = new NoDealerResponseHandler(AD_QUESTION_BUILDER, NOT_SOLD_QUESTION_BUILDER);
    public static final DealerResponseHandler DEALER_HANDLER = new DealerResponseHandler(SOLD_CAR_QUESTION_BUILDER, DEALER_QUESTION_BUILDER);
    public static final CarDetailsResponseHandler CAR_DETAILS_HANDLER = new CarDetailsResponseHandler();
    public static final LastStepResponseHandler LAST_STEP_HANDLER = new LastStepResponseHandler(SELLERS_STORAGE);

}
