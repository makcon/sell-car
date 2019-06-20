package fun.sale.handler;

import fun.sale.domain.BuyerOffer;
import fun.sale.domain.Seller;
import fun.sale.storage.SellersStorage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static fun.sale.constants.AnswerVariants.NO;
import static fun.sale.constants.AnswerVariants.YES;
import static fun.sale.constants.StaticQuestions.FIRST_QUESTION;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LastStepResponseHandlerTest {

    @InjectMocks
    private LastStepResponseHandler handler;

    @Mock
    private SellersStorage storage;


    @Test
    public void buildNextQuestion_shouldCallStorageAndClearBuyerFields() {
        var seller = new Seller("name");
        seller.getDealerOffers().add(mock(BuyerOffer.class));
        seller.getPrivateBuyerOffers().add(mock(BuyerOffer.class));

        handler.buildNextQuestion(seller, YES);

        verifyStorageCall(seller);
        assertThat(seller.getDealerOffers(), hasSize(0));
        assertThat(seller.getPrivateBuyerOffers(), hasSize(0));
    }

    @Test
    public void buildNextQuestion_answerYes_shouldReturnFIRST_QUESTION() {
        var seller = new Seller("name");

        var question = handler.buildNextQuestion(seller, YES);

        assertThat(question, equalTo(FIRST_QUESTION));
    }

    @Test
    public void buildNextQuestion_answerNo_shouldReturnNull() {
        var seller = new Seller("name");

        var question = handler.buildNextQuestion(seller, NO);

        assertThat(question, nullValue());
    }

    // Util methods

    private void verifyStorageCall(Seller seller) {
        verify(storage).save(seller);
    }
}