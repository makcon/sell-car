package fun.sale.handler;

import fun.sale.builder.PrivateBuyerQuestionBuilder;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import fun.sale.utils.DelayUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdResponseHandler extends AbstractResponseHandler {

    private static final int BUYER_CALL_DELAY_MILLIS = 1000;

    private final PrivateBuyerQuestionBuilder privateBuyerQuestionBuilder;

    @Override
    protected Question buildNextQuestion(Seller seller,
                                         String response) {
        DelayUtils.delay(BUYER_CALL_DELAY_MILLIS);

        return privateBuyerQuestionBuilder.build(seller);
    }
}
