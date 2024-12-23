package by.minsk.he.models.enums;

public enum AdvertStatus {
    PREMIUM,
    STANDARD;

    public static AdvertStatus fromString(String advertStatusString) {
        if (advertStatusString == null || advertStatusString.isEmpty()) {
            throw new IllegalArgumentException("Advert status string cannot be null or empty");
        }

        for (AdvertStatus advertStatus : AdvertStatus.values()) {
            if (advertStatus.name().equalsIgnoreCase(advertStatusString)) {
                return advertStatus;
            }
        }

        throw new IllegalArgumentException("Unknown advert status: " + advertStatusString);
    }
}
