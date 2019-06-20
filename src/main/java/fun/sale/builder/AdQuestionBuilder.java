package fun.sale.builder;

import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import fun.sale.utils.AdConstructor;

import static fun.sale.AppBeans.AD_HANDLER;

public class AdQuestionBuilder {

    public Question build(Seller seller) {
        String text = "Here is you ad:" + '\n' +
                AdConstructor.build(seller.getCar()) + '\n' +
                "Please wait when someone calls you (press Enter to continue)";

        return Question.builder()
                .seller(seller)
                .text(text)
                .responseHandler(AD_HANDLER)
                .build();
    }
}
