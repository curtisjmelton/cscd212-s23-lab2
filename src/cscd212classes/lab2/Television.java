package cscd212classes.lab2;

import java.util.Objects;

public class Television {

    //data members
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    //The EVC that sets the class level variables to the values passed in
    public Television(String make, String model, boolean smart, int screenSize, int resolution) {
        // Check for valid arguments
        if (make == null || make.isEmpty() || model == null || model.isEmpty() || screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException("Invalid arguments for Television constructor");
        }

        // Initialize data members
        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.fourK = (resolution == 2160);
    }
    //The EVC that sets the class level variables to the values passed in by calling the other EVC via this method
    public Television(String model, boolean smart, int screenSize, int resolution, String make) {
        this(make, model, smart, screenSize, resolution);
    }

    //public methods
    public int getScreenSize() {
        return screenSize;
    }

    public int getResolution() {
        return resolution;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String toString() {
        String result = make + "-" + model + ", " + screenSize + " inch tv with ";
        if (smart && resolution == 2160) {
            result += "smart tv with 4K resolution";
        } else if (smart) {
            result += resolution + "resolution";
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Television)) return false;
        Television that = (Television) o;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fourK, make, model, resolution, screenSize, smart);
    }

    @Override
    public int compareTo(Television another) {
        if (another == null) {
            throw new IllegalArgumentException("Television object cannot be null");
        }

        int makeComparison = this.make.compareTo(another.getMake());
        if (makeComparison != 0) {
            return makeComparison;
        }

        int modelComparison = this.model.compareTo(another.getModel());
        if (modelComparison != 0) {
            return modelComparison;
        }

        return this.screenSize - another.getScreenSize();
    }


}
