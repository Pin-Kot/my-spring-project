package by.minsk.he.models.enums;

public enum EngineType {
    DIESEL,
    ELECTRIC,
    GASOLINE,
    HYBRID;

    public static EngineType fromString(String engineTypeString) {
        if (engineTypeString == null || engineTypeString.isEmpty()) {
            throw new IllegalArgumentException("Engine type string cannot be null or empty");
        }

        for (EngineType engineType : EngineType.values()) {
            if (engineType.name().equalsIgnoreCase(engineTypeString)) {
                return engineType;
            }
        }

        throw new IllegalArgumentException("Unknown engine type: " + engineTypeString);
    }
}
