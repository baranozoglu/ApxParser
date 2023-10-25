package model.enums;

public enum TLabelEnum {
    HOUR("Hour"),
    NET_VOLUME("Net Volume"),
    ORDER("Order"),
    PRICE("Price");

    private String label;

    TLabelEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
