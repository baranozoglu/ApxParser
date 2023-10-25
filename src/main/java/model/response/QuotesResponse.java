package model.response;

import model.Quotes;

import java.util.List;

public class QuotesResponse {
    List<QuoteResponse> quoteResponses;

    public QuotesResponse(List<QuoteResponse> quoteResponses) {
        this.quoteResponses = quoteResponses;
    }

    public static QuotesResponse of(Quotes quotes) {
        return new QuotesResponse(QuoteResponse.of(quotes.getQuotes()));
    }

    public List<QuoteResponse> getQuoteResponses() {
        return quoteResponses;
    }

    public void setQuoteResponses(List<QuoteResponse> quoteResponses) {
        this.quoteResponses = quoteResponses;
    }
}
