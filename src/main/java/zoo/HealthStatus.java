package zoo;

public class HealthStatus {
    private String status;

    // Конструктор для Builder
    public HealthStatus(HealthStatusBuilder builder) {
        this.status = builder.status;
    }

    public String getStatus() {
        return status;
    }

    public static class HealthStatusBuilder {
        private String status;

        public HealthStatusBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public HealthStatus build() {
            return new HealthStatus(this);
        }
    }
}
