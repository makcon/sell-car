package fun.sale.builder;

import fun.sale.domain.Question;
import fun.sale.domain.Seller;

@FunctionalInterface
public interface BuyerQuestionBuilder {

    Question build(Seller seller);
}
