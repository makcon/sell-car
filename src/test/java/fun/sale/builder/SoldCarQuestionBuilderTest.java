package fun.sale.builder;

import fun.sale.domain.*;
import org.junit.Test;

import java.util.List;

import static fun.sale.AppBeans.LAST_STEP_HANDLER;
import static fun.sale.constants.AnswerVariants.NO;
import static fun.sale.constants.AnswerVariants.YES;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SoldCarQuestionBuilderTest {

    private final SoldCarQuestionBuilder builder = new SoldCarQuestionBuilder();

    @Test
    public void build_shouldBuildCorrectQuestionAndStoreSeller() {
        var sellerName = "seller";
        var seller = new Seller(sellerName);
        var car = Car.builder().model("toyota").build();
        seller.setCar(car);
        var offer1 = createOffer("buyer1", 1);
        var offer2 = createOffer("buyer2", 2);

        var question = builder.build(seller, List.of(offer1, offer2));

        assertThat(question.getSeller(), equalTo(seller));
        assertThat(question.getText(), notNullValue());
        assertThat(question.getAnswerVariants(), equalTo(List.of(YES, NO)));
        assertThat(question.getResponseHandler(), equalTo(LAST_STEP_HANDLER));
        verifySellerHasSolrCar(seller, offer2, car);
    }

    // Util methods

    private BuyerOffer createOffer(String name,
                                   int price) {
        return new BuyerOffer(new Buyer(name, 0.7f), price);
    }

    private void verifySellerHasSolrCar(Seller seller,
                                        BuyerOffer offer,
                                        Car car) {
        var soldCar = SoldCar.builder()
                .car(car)
                .buyer(offer.getBuyer())
                .price(offer.getPrice())
                .build();

        assertThat(seller.getSoldCars(), equalTo(List.of(soldCar)));
    }
}