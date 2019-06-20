package fun.sale.domain;

import fun.sale.handler.ResponseHandler;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Question {

    private final Seller seller;
    private final String text;
    private final ResponseHandler responseHandler;
    @Builder.Default
    private final List<String> answerVariants = List.of();

    public String buildFullText() {
        if (answerVariants.isEmpty()) {
            return text;
        }

        return text + " (" + String.join("/", answerVariants) + ')';
    }
}
