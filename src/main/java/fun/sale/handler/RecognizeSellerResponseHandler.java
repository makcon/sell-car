package fun.sale.handler;

import fun.sale.builder.CarDetailsQuestionBuilder;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import lombok.RequiredArgsConstructor;

import static fun.sale.AppBeans.INTRODUCE_SELLER_HANDLER;
import static fun.sale.constants.AnswerVariants.YES;

@RequiredArgsConstructor
public class RecognizeSellerResponseHandler extends AbstractResponseHandler {

    private final CarDetailsQuestionBuilder carDetailsQuestionBuilder;

    @Override
    protected Question buildNextQuestion(Seller seller,
                                         String response) {
        return YES.equals(response)
                ? carDetailsQuestionBuilder.build(seller)
                : Question.builder()
                        .seller(seller)
                        .text("In this case please enter another name")
                        .responseHandler(INTRODUCE_SELLER_HANDLER)
                        .build();
    }
}
