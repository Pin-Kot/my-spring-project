package by.minsk.he.models.enums;

public enum CustomStatus {
    CLEARED,
    NOT_CLEARED;

    public static CustomStatus fromString(String customStatusString) {
        if (customStatusString == null || customStatusString.isEmpty()) {
            throw new IllegalArgumentException("Custom status string cannot be null or empty");
        }

        for (CustomStatus customStatus : CustomStatus.values()) {
            if (customStatus.name().equalsIgnoreCase(customStatusString)) {
                return customStatus;
            }
        }

        throw new IllegalArgumentException("Unknown custom status: " + customStatusString);
    }
}
