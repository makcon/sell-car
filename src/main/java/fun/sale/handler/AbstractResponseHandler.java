package fun.sale.handler;

import fun.sale.domain.Question;
import fun.sale.domain.Seller;

import java.util.Optional;

public abstract class AbstractResponseHandler implements ResponseHandler {

    @Override
    public boolean isValid(Question question,
                           String response) {
        if (question.getAnswerVariants().isEmpty()) {
            return true;
        }

        return question.getAnswerVariants().contains(response);
    }

    @Override
    public Optional<Question> getNextQuestion(Seller seller,
                                              String response) {
        return Optional.ofNullable(buildNextQuestion(seller, response));
    }

    protected abstract Question buildNextQuestion(Seller seller,
                                                  String response);
}
