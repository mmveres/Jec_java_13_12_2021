package ua.univer.lesson01;

public class Droid {
    private String name;
    private double power;
    private double speed;
    private Shield shield;
    private static Engine engine;

    static {
        Droid.engine = new Engine("A", 100);
    }

    public Droid(String name, double power, double speed) {
        this.name = name;
        this.power = power;
        this.speed = speed;
        this.shield = new Shield("S1", 50);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public static Engine getEngine() {
        return engine;
    }

    public static void setEngine(Engine engine) {
        Droid.engine = engine;
    }
    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }
    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", speed=" + speed +
                ", shield="+ shield+
                ", engine="+ engine+
                '}';
    }



    public static class Engine {
        private String name;
        private double power;
        private EngineType engineType;
        enum EngineType {
            Gasoline("G"), Electric("E"),Diesel("D");

            private String name;

            EngineType(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Eng{" +
                        "name='" + name + '\'' +
                        '}';
            }
        }

        public Engine(String name, double power) {
            this.name = name;
            this.power = power;
            this.engineType = EngineType.Electric;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPower() {
            return power;
        }

        public void setPower(double power) {
            this.power = power;
        }

        public EngineType getEngineType() {
            return engineType;
        }

        public void setEngineType(EngineType engineType) {
            this.engineType = engineType;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "name='" + name + '\'' +
                    ", power=" + power +
                    ", engineType=" + engineType +
                    '}';
        }
    }
    public class Shield {
        private String name;
        private double defence;

        public Shield(String name, double defence) {
            this.name = name;
            this.defence = defence;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getDefence() {
            return defence;
        }

        public void setDefence(double defence) {
            this.defence = defence;
        }

        @Override
        public String toString() {
            return "Shield{" +
                    "name='" + name + '\'' +
                    ", defence=" + defence +
                    '}';
        }
    }
}
