package fun.sale.handler;

import fun.sale.builder.DealerQuestionBuilder;
import fun.sale.builder.SoldCarQuestionBuilder;
import fun.sale.domain.BuyerOffer;
import fun.sale.domain.Question;
import fun.sale.domain.Seller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static fun.sale.constants.AnswerVariants.NO;
import static fun.sale.constants.AnswerVariants.YES;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DealerResponseHandlerTest {

    @InjectMocks
    private DealerResponseHandler handler;

    @Mock
    private SoldCarQuestionBuilder soldCarQuestionBuilder;
    @Mock
    private DealerQuestionBuilder dealerQuestionBuilder;
    @Mock
    private Seller sellerMock;
    @Mock
    private BuyerOffer buyerOfferMock;
    @Mock
    private Question questionMock;

    @Test
    public void buildNextQuestion_answerYes_shouldCallSoldCarQuestionBuilder() {
        mockSellerGetDealers();
        mockSoldCarQuestionBuilder();

        var question = handler.buildNextQuestion(sellerMock, YES);

        verifySoldCarQuestionBuilderCall(1);
        verifyDealerQuestionBuilder(0);
        assertThat(question, equalTo(questionMock));
    }

    @Test
    public void buildNextQuestion_answerNo_shouldCallDealerQuestionBuilder() {
        mockDealerQuestionBuilder();

        var question = handler.buildNextQuestion(sellerMock, NO);

        verifySoldCarQuestionBuilderCall(0);
        verifyDealerQuestionBuilder(1);
        assertThat(question, equalTo(questionMock));
    }

    // Util methods

    private void mockSellerGetDealers() {
        when(sellerMock.getDealerOffers()).thenReturn(List.of(buyerOfferMock));
    }

    private void mockSoldCarQuestionBuilder() {
        when(soldCarQuestionBuilder.build(any(), anyList())).thenReturn(questionMock);
    }

    private void mockDealerQuestionBuilder() {
        when(dealerQuestionBuilder.build(any())).thenReturn(questionMock);
    }

    private void verifySoldCarQuestionBuilderCall(int times) {
        verify(soldCarQuestionBuilder, Mockito.times(times)).build(sellerMock, List.of(buyerOfferMock));
    }

    private void verifyDealerQuestionBuilder(int times) {
        verify(dealerQuestionBuilder, Mockito.times(times)).build(sellerMock);
    }
}