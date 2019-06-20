package fun.sale.builder;

import fun.sale.domain.Seller;
import org.junit.Test;

import static fun.sale.AppBeans.CAR_DETAILS_HANDLER;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class CarDetailsQuestionBuilderTest {

    private final CarDetailsQuestionBuilder builder = new CarDetailsQuestionBuilder();

    @Test
    public void build_shouldBuildCorrectQuestion() {
        var seller = new Seller("Maks");

        var question = builder.build(seller);

        assertThat(question.getSeller(), equalTo(seller));
        assertThat(question.getText(), notNullValue());
        assertThat(question.getAnswerVariants().isEmpty(), is(true));
        assertThat(question.getResponseHandler(), equalTo(CAR_DETAILS_HANDLER));
    }
}