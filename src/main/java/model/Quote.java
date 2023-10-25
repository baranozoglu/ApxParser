package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Quote {
    private String market;
    @JsonProperty("date_applied")
    private Date dateApplied;
    @JsonProperty("values")
    private List<QuoteValue> quoteValues;

    public Quote() {
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

    public List<QuoteValue> getQuoteValues() {
        return quoteValues;
    }

    public void setQuoteValues(List<QuoteValue> quoteValues) {
        this.quoteValues = quoteValues;
    }
}
