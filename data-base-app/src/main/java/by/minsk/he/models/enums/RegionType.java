package by.minsk.he.models.enums;

public enum RegionType {
    BREST_REGION,
    VITEBSK_REGION,
    GOMEL_REGION,
    GRODNO_REGION,
    MINSK_REGION,
    MOGILEV_REGION,
    MINSK;

    public static RegionType fromString(String regionTypeString) {
        if (regionTypeString == null || regionTypeString.isEmpty()) {
            throw new IllegalArgumentException("Region type string cannot be null or empty");
        }

        for (RegionType regionType : RegionType.values()) {
            if (regionType.name().equalsIgnoreCase(regionTypeString)) {
                return regionType;
            }
        }

        throw new IllegalArgumentException("Unknown region type: " + regionTypeString);
    }
}
