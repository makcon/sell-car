package fun.sale.builder;

import fun.sale.domain.Question;
import fun.sale.domain.Seller;

import static fun.sale.AppBeans.CAR_DETAILS_HANDLER;

public class CarDetailsQuestionBuilder {

    public Question build(Seller seller) {
        return Question.builder()
                .seller(seller)
                .text(String.format("%s, please provide your car's details in format model|year|price", seller.getName()))
                .responseHandler(CAR_DETAILS_HANDLER)
                .build();
    }
}
