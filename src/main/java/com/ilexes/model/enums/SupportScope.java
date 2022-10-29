package com.ilexes.model.enums;

public enum SupportScope {

    TWENTY_FOUR_SEVEN_EMEA("24x7", "The support will be delivered within the period Monday - Sunday from 00:00 to 23:59.", Region.EMEA),
    TWENTY_FOUR_FIVE_EMEA("24x5", "The support will be delivered within the period Monday - Friday from 00:00 to 23:59.", Region.EMEA),
    TWELVE_SEVEN_EMEA("12x7", "The support will be delivered within the period Monday - Sunday from 08:00 to 20:00.", Region.EMEA),
    TWELVE_FIVE_EMEA("12x5", "The support will be delivered within the period Monday - Friday from 08:00 to 20:00.", Region.EMEA),
    TWENTY_FOUR_SEVEN_NA("24x7", "The support will be delivered within the period Monday - Sunday from 00:00 to 23:59.", Region.NA),
    TWENTY_FOUR_FIVE_NA("24x5", "The support will be delivered within the period Monday - Friday from 00:00 to 23:59.", Region.NA),
    TWELVE_SEVEN_NA("12x7", "The support will be delivered within the period Monday - Sunday from 08:00 to 20:00.", Region.NA),
    TWELVE_FIVE_NA("12x5", "The support will be delivered within the period Monday - Friday from 08:00 to 20:00.", Region.NA);

    private SupportScope(String value, String description, Region region) {
    }
}
