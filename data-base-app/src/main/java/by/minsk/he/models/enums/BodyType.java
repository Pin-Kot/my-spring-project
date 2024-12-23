package by.minsk.he.models.enums;

public enum BodyType {
    CABRIO,
    COOUPE,
    HATCHBACK,
    LIFTBACK,
    SEDAN,
    SUV,
    UNIVERSAL,
    VAGON;

    public static BodyType fromString(String bodyTypeString) {
        if (bodyTypeString == null || bodyTypeString.isEmpty()) {
            throw new IllegalArgumentException("Body type string cannot be null or empty");
        }

        for (BodyType bodyType : BodyType.values()) {
            if (bodyType.name().equalsIgnoreCase(bodyTypeString)) {
                return bodyType;
            }
        }

        throw new IllegalArgumentException("Unknown body type: " + bodyTypeString);
    }
}
