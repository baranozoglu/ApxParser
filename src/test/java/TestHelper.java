import model.response.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TestHelper {
    public static QuotesResponse createMockedQuotes() {
        return new QuotesResponse(List.of(createMockedQuote()));
    }

    public static InternalResponses createMockedInternalResponse() {
        return InternalResponses.of(List.of(new InternalResponse(LocalDateTime.of(
                        2019,
                        11,
                        13,
                        1,
                        0),
                        "4514.20",
                        "34"),
                new InternalResponse(LocalDateTime.of(
                        2019,
                        11,
                        13,
                        2,
                        0),
                        "4699.90",
                        "33.90")
        ));
    }

    public static QuoteResponse createMockedQuote() {
        return new QuoteResponse("APX Power NL Hourly",
                new Date(1573599600000L),
                createMockedQuoteValue());
    }

    public static List<QuoteValueResponse> createMockedQuoteValue() {
        QuoteValueResponse quoteValueResponse = new QuoteValueResponse(
                "Order",
                "noLabel",
                "1",
                "none",
                0L,
                false,
                "none",
                null,
                0L
        );
        return List.of(quoteValueResponse);
    }
}
