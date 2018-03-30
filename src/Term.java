public enum Term {
    SPRING,
    SUMMER_A,
    SUMMER_B,
    SUMMER_C,
    FALL;

    @Override
    public String toString() {
        String term;
        switch(this) {
            case SPRING:
                term = "Spring";
                break;
            case SUMMER_A:
                term = "Summer A";
                break;
            case SUMMER_B:
                term = "Summer B";
                break;
            case SUMMER_C:
                term = "Summer C";
                break;
            case FALL:
                term = "Fall";
                break;
            default:
                // Should be unreachable
                term = "???";
                break;
        }

        return term;
    }
}

