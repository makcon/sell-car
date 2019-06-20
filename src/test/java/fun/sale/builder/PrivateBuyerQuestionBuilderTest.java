package fun.sale.builder;

import fun.sale.domain.Buyer;
import fun.sale.domain.Car;
import fun.sale.domain.Seller;
import fun.sale.storage.PrivateBuyersStorage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static fun.sale.AppBeans.NO_PRIVATE_BUYER_HANDLER;
import static fun.sale.AppBeans.PRIVATE_BUYER_HANDLER;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrivateBuyerQuestionBuilderTest {

    private PrivateBuyerQuestionBuilder builder;

    @Mock
    private PrivateBuyersStorage storage;

    @Before
    public void setUp() {
        builder = new PrivateBuyerQuestionBuilder(storage);
    }

    @Test
    public void build_storageReturnsBuyer_shouldBuildBuyer() {
        mockStorage(mock(Buyer.class));
        var seller = new Seller("seller");
        seller.setCar(Car.builder().price(10).build());

        var question = builder.build(seller);

        assertThat(question.getSeller(), equalTo(seller));
        assertThat(question.getText(), notNullValue());
        assertThat(seller.getDealerOffers(), hasSize(0));
        assertThat(seller.getPrivateBuyerOffers(), hasSize(1));
        assertThat(question.getResponseHandler(), equalTo(PRIVATE_BUYER_HANDLER));
    }

    @Test
    public void build_storageReturnsEmptyBuyer_shouldBuildNoBuyer() {
        mockStorage(null);
        var seller = new Seller("seller");

        var question = builder.build(seller);

        assertThat(question.getSeller(), equalTo(seller));
        assertThat(question.getText(), notNullValue());
        assertThat(seller.getDealerOffers(), hasSize(0));
        assertThat(seller.getPrivateBuyerOffers(), hasSize(0));
        assertThat(question.getResponseHandler(), equalTo(NO_PRIVATE_BUYER_HANDLER));
    }

    // Util methods

    private void mockStorage(Buyer buyer) {
        when(storage.findRandom(anyList())).thenReturn(Optional.ofNullable(buyer));
    }
}