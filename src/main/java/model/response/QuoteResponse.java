package model.response;

import model.Quote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuoteResponse {
    private String market;
    private Date dateApplied;
    private List<QuoteValueResponse> quoteValueResponses;

    public QuoteResponse(String market, Date dateApplied, List<QuoteValueResponse> quoteValueResponses) {
        this.market = market;
        this.dateApplied = dateApplied;
        this.quoteValueResponses = quoteValueResponses;
    }

    public static List<QuoteResponse> of(List<Quote> quotes) {
        List<QuoteResponse> quoteResponses = new ArrayList<>();
        quotes.forEach(quote -> quoteResponses.add(new QuoteResponse(quote.getMarket(),
                quote.getDateApplied(),
                QuoteValueResponse.of(quote.getQuoteValues()))));
        return quoteResponses;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public List<QuoteValueResponse> getQuoteValueResponses() {
        return quoteValueResponses;
    }

    public void setQuoteValueResponses(List<QuoteValueResponse> quoteValueResponses) {
        this.quoteValueResponses = quoteValueResponses;
    }
}
