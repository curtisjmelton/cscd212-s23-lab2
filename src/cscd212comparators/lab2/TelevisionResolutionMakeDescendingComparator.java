package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television> {

        @Override
        public int compare(Television t1, Television t2) {
            if (t1 == null || t2 == null) {
                throw new IllegalArgumentException("null parameter in TelevisionResolutionMakeDescendingComparator");
            }

            int resolutionComparison = t2.getResolution() - t1.getResolution();
            if (resolutionComparison != 0) {
                return resolutionComparison;
            }

            return t2.getMake().compareTo(t1.getMake());
        }
    }
