package com.pesa.epesa.mastercard.resources;

public enum Property {
CONSUMERKEY("consumerKey"),
KEYALIAS("keyAlias"),
KEYPASSWORD("keyPassword"),
KEYSTOREPATH("keyStorePath"),
END_POINT("mastercardUrl");
String value;

private Property(String value) {
    this.value = value;
   }

    public String getValue() {
        return value;
    }
}
