public enum Grade {
    A(4),
    B(3),
    C(2),
    D(1),
    F(0),
    I(-1),
    W(-1),
    NONE(-1);

    private int gradeValue;

    private Grade(int gradeValue) {
        this.gradeValue = gradeValue;
    }

    /**
     * @return The value of a grade on a 4.0 GPA scale. -1 indicates the value should not be included in GPA
     *      calculations
     */
    public int getGradeValue() {
        return this.gradeValue;
    }
}
