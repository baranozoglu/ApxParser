package model.response;

import model.QuoteValue;

import java.util.ArrayList;
import java.util.List;

public class QuoteValueResponse {
    private String tLabel;
    private String cLabel;
    private String value;
    private String unit;
    private Long position;
    private Boolean chartShow;
    private String chartType;
    private String color;
    private Long precision;

    public QuoteValueResponse(String tLabel, String cLabel, String value, String unit, Long position, Boolean chartShow, String chartType, String color, Long precision) {
        this.tLabel = tLabel;
        this.cLabel = cLabel;
        this.value = value;
        this.unit = unit;
        this.position = position;
        this.chartShow = chartShow;
        this.chartType = chartType;
        this.color = color;
        this.precision = precision;
    }

    public static List<QuoteValueResponse> of(List<QuoteValue> values) {
        List<QuoteValueResponse> quoteValueResponses = new ArrayList<>();
        values.forEach(value -> quoteValueResponses.add(new QuoteValueResponse(value.gettLabel(),
                value.getcLabel(),
                value.getValue(),
                value.getUnit(),
                value.getPosition(),
                value.getChartShow(),
                value.getChartType(),
                value.getColor(),
                value.getPrecision()
        )));
        return quoteValueResponses;
    }

    public String gettLabel() {
        return tLabel;
    }

    public void settLabel(String tLabel) {
        this.tLabel = tLabel;
    }

    public String getcLabel() {
        return cLabel;
    }

    public void setcLabel(String cLabel) {
        this.cLabel = cLabel;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public Boolean getChartShow() {
        return chartShow;
    }

    public void setChartShow(Boolean chartShow) {
        this.chartShow = chartShow;
    }

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getPrecision() {
        return precision;
    }

    public void setPrecision(Long precision) {
        this.precision = precision;
    }
}
