package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Quotes {
    @JsonProperty("quote")
    private List<Quote> quotes;

    public Quotes() {
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
