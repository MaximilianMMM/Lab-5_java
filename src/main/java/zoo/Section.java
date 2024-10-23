package zoo;

public class Section {
    private String sectionName;
    private String location;

    // Конструктор для Builder
    public Section(SectionBuilder builder) {
        this.sectionName = builder.sectionName;
        this.location = builder.location;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getLocation() {
        return location;
    }

    public static class SectionBuilder {
        private String sectionName;
        private String location;

        public SectionBuilder setSectionName(String sectionName) {
            this.sectionName = sectionName;
            return this;
        }

        public SectionBuilder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Section build() {
            return new Section(this);
        }
    }
}
