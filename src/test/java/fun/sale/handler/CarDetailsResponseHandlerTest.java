package fun.sale.handler;

import fun.sale.domain.Car;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import org.junit.Test;

import java.util.List;

import static fun.sale.AppBeans.SELLING_METHOD_HANDLER;
import static fun.sale.constants.AnswerVariants.AD;
import static fun.sale.constants.AnswerVariants.DEALER;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class CarDetailsResponseHandlerTest {

    private final CarDetailsResponseHandler handler = new CarDetailsResponseHandler();

    @Test
    public void isValid_invalidResponse_shouldReturnFalse() {
        assertThat(handler.isValid(mock(Question.class), "invalid"), is(false));
    }

    @Test
    public void isValid_validResponse_shouldReturnTrue() {
        assertThat(handler.isValid(mock(Question.class), "toyota|2006|5000"), is(true));
    }

    @Test
    public void buildNextQuestion_shouldBuildValidQuestion() {
        var seller = new Seller("name");
        var response = "toyota|2006|5000";

        var question = handler.buildNextQuestion(seller, response);

        assertThat(question.getSeller(), equalTo(seller));
        assertThat(question.getSeller().getCar(), equalTo(Car.fromString(response)));
        assertThat(question.getText(), notNullValue());
        assertThat(question.getAnswerVariants(), equalTo(List.of(DEALER, AD)));
        assertThat(question.getResponseHandler(), equalTo(SELLING_METHOD_HANDLER));
    }
}