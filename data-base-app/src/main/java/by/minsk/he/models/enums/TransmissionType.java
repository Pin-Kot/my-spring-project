package by.minsk.he.models.enums;

public enum TransmissionType {
    AUTO,
    MANUAL;

    public static TransmissionType fromString(String transmissionTypeString) {
        if (transmissionTypeString == null || transmissionTypeString.isEmpty()) {
            throw new IllegalArgumentException("Transmission type string cannot be null or empty");
        }

        for (TransmissionType transmissionType : TransmissionType.values()) {
            if (transmissionType.name().equalsIgnoreCase(transmissionTypeString)) {
                return transmissionType;
            }
        }

        throw new IllegalArgumentException("Unknown transmission type: " + transmissionTypeString);
    }
}
