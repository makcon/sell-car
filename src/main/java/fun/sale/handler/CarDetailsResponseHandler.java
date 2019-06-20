package fun.sale.handler;

import fun.sale.domain.Car;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.regex.Pattern;

import static fun.sale.AppBeans.SELLING_METHOD_HANDLER;
import static fun.sale.constants.AnswerVariants.AD;
import static fun.sale.constants.AnswerVariants.DEALER;

@RequiredArgsConstructor
public class CarDetailsResponseHandler extends AbstractResponseHandler {

    private static final Pattern ANSWER_PATTERN = Pattern.compile("[a-zA-Z]+\\|[0-9]+\\|[0-9]+");

    @Override
    public boolean isValid(Question question,
                           String response) {
        return ANSWER_PATTERN.matcher(response).matches();
    }

    @Override
    protected Question buildNextQuestion(Seller seller,
                                         String response) {
        return getNextQuestion(seller, Car.fromString(response));
    }

    private Question getNextQuestion(Seller seller,
                                     Car car) {
        seller.setCar(car);

        return Question.builder()
                .seller(seller)
                .text("How do you want to sell the car? Publish an ad or sell it to a dealer?")
                .answerVariants(List.of(DEALER, AD))
                .responseHandler(SELLING_METHOD_HANDLER)
                .build();
    }
}
