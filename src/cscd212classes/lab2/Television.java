package cscd212classes.lab2;

import java.util.Comparator;
import java.util.Objects;

public class Television implements Comparable<Television> {

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
            throw new IllegalArgumentException("Invalid parameter in constructor");
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
        String result = make + "-" + model + ", " + screenSize + " inch ";

        if (smart && fourK) {
            result += "smart tv with 4K resolution";
        } else if (smart) {
            result += "smart tv with " + resolution + " resolution";
        } else if (fourK) {
            result += "tv with 4K resolution";
        } else {
            result += "tv with " + resolution + " resolution";
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

    public int hashCode() {
        Boolean smartObject = Boolean.valueOf(smart);
        Boolean fourKObject = Boolean.valueOf(fourK);

        return  (int) make.hashCode() + model.hashCode() + getResolution() + smartObject.hashCode() + fourKObject.hashCode();
    }



    @Override
    public int compareTo(Television another) {
        if (another == null) {
            throw new IllegalArgumentException("null parameter in the compareTo method");
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
