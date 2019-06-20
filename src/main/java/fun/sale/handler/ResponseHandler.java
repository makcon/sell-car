package fun.sale.handler;

import fun.sale.domain.Question;
import fun.sale.domain.Seller;

import java.util.Optional;

public interface ResponseHandler {

    boolean isValid(Question question,
                    String response);

    Optional<Question> getNextQuestion(Seller seller,
                                       String response);
}
