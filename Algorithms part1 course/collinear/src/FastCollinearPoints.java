import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {
    private final LineSegment[] lineSegments;
    public FastCollinearPoints(Point[] points){ // finds all line segments containing 4 or more points
        if(points == null){
            throw new IllegalArgumentException();
        }
        checkForNullPoints(points);

        Point[] sortedOriginalPoints = Arrays.copyOf(points, points.length);
        Point[] sortedBySlopePoints = Arrays.copyOf(points, points.length);
        List<LineSegment> segmentsList = new ArrayList<LineSegment>();
        Arrays.sort(sortedBySlopePoints);
        checkForDuplicatedPoints(sortedBySlopePoints);
        for (Point origin : sortedBySlopePoints) {
            Arrays.sort(sortedOriginalPoints);
            Arrays.sort(sortedOriginalPoints, origin.slopeOrder());
            int count = 1;
            Point lineBeginning = null;
            for (int j = 0; j < sortedOriginalPoints.length - 1; ++j) {
                if (sortedOriginalPoints[j].slopeTo(origin) == sortedOriginalPoints[j + 1].slopeTo(origin)) {
                    count++;
                    if (count == 2) {
                        lineBeginning = sortedOriginalPoints[j];
                        count++;
                    } else if (count >= 4 && j + 1 == sortedOriginalPoints.length - 1) {
                        if (lineBeginning.compareTo(origin) > 0) {
                            segmentsList.add(new LineSegment(origin, sortedOriginalPoints[j + 1]));
                        }
                        count = 1;
                    }
                } else if (count >= 4) {
                    if (lineBeginning.compareTo(origin) > 0) {
                        segmentsList.add(new LineSegment(origin, sortedOriginalPoints[j]));
                    }
                    count = 1;
                } else {
                    count = 1;
                }
            }
        }
        this.lineSegments = segmentsList.toArray(new LineSegment[0]);

    }

    private void checkForDuplicatedPoints(Point[] sortedBySlopePoints) {
        for(int i = 1; i < sortedBySlopePoints.length; i++){
            if(sortedBySlopePoints[i].compareTo(sortedBySlopePoints[i-1]) == 0)
                throw new IllegalArgumentException("Duplicate values");
        }
    }

    public           int numberOfSegments(){// the number of line segments
        return this.lineSegments.length;
    }
    public LineSegment[] segments(){// the line segments
        return this.lineSegments;
    }
    private void checkForNullPoints(Point[] points) {
        for (Point point : points) {
            if (point == null) {
                throw new NullPointerException("At least one point in the array is null");
            }
        }
    }

}