package fun.sale.builder;

import fun.sale.domain.Car;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import org.junit.Test;

import static fun.sale.AppBeans.AD_HANDLER;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class AdQuestionBuilderTest {

    private final AdQuestionBuilder builder = new AdQuestionBuilder();

    @Test
    public void build_shouldBuildCorrectQuestion() {
        var seller = new Seller("Maks");
        seller.setCar(Car.builder().build());

        Question question = builder.build(seller);

        assertThat(question.getSeller(), equalTo(seller));
        assertThat(question.getText(), notNullValue());
        assertThat(question.getAnswerVariants().isEmpty(), is(true));
        assertThat(question.getResponseHandler(), equalTo(AD_HANDLER));
    }
}