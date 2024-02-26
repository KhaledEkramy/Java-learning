import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
public class BruteCollinearPoints {
//    private Point points[];
    private final LineSegment[] lineSegments;
    public BruteCollinearPoints(Point[] points){// finds all line segments containing 4 points
        if(points == null){
            throw new IllegalArgumentException();
        }
        for(Point point: points){
            if(point == null){
                throw new IllegalArgumentException("Point shouldn't be null");
            }
        }
        for(int i = 1 ; i < points.length ;i++){
            if(points[i].compareTo(points[i-1]) ==0){
                throw new IllegalArgumentException("Duplicate values");
            }
        }
        Arrays.sort(points);
        List<LineSegment> segments = new ArrayList<>();
        for(int i = 0 ; i < points.length-3; i++){
            for(int j = i+1; j < points.length-2; j++){
                for(int m = j+1; m < points.length-1; m++){
                    for(int n = m+1; n < points.length; n++){
                        Comparator<Point> com = points[i].slopeOrder();
                        if(com.compare(points[j],points[m]) == 0 && com.compare(points[j], points[n]) == 0){
                            LineSegment LS = new LineSegment(points[i], points[n]);
                            if(!segments.contains(LS)){
                                segments.add(LS);
                            }
                        }
                    }
                }
            }
        }
        this.lineSegments = segments.toArray(new LineSegment[0]);
    }
    public           int numberOfSegments(){// the number of line segments
        return this.lineSegments.length;
    }

    public LineSegment[] segments(){// the line segments
        return lineSegments;
    }
}
