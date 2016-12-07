import java.awt.Point;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/*
 * Author: poniatowski
 * File:   Java_Muster_09_GeoFigure__JUnitTestFigures.java
 * Date:   Jan 14, 2015
 * State:  At work
 */
public class JUnitFiguresTest {

    /* Rectangle */
    @Test
    public void testRectangleConstructor() {
        Rectangle r = new Rectangle(new Point(200, 100), new Point(100, 200));
        Point[] expected = {new Point(100, 100), new Point(200, 100),
            new Point(200, 200), new Point(100, 200), new Point(100, 100)};
        assertTrue(expected.length == r.points.size());
        for (Point p : expected) {
            assertTrue(r.points.contains(p));
        }
    }

    @Test
    public void testRectangleCopyConstructor() {
        Rectangle r = new Rectangle(new Point(200, 100), new Point(100, 200));
        Rectangle r2 = new Rectangle(r);
        Point[] expected = {new Point(100, 100), new Point(200, 100),
            new Point(200, 200), new Point(100, 200), new Point(100, 100)};
        assertTrue(expected.length == r2.points.size());
        for (Point p : expected) {
            assertTrue(r2.points.contains(p));
        }
    }

    @Test
    public void testRectangleScaleByTwo() {
        Rectangle r = new Rectangle(new Point(200, 100), new Point(100, 200));
        r.scale(2);
        Point[] expected = {new Point(50, 50), new Point(250, 50),
            new Point(250, 250), new Point(50, 250), new Point(50, 50)};
        assertTrue(expected.length == r.points.size());
        for (Point p : expected) {
            assertTrue(r.points.contains(p));
        }
    }

    @Test
    public void testRectangleScaleByZeroDotFive() {
        Rectangle r = new Rectangle(new Point(50, 50), new Point(250, 250));
        r.scale(0.5);
        Point[] expected = {new Point(100, 100), new Point(200, 100),
            new Point(200, 200), new Point(100, 200), new Point(100, 100)};
        assertTrue(expected.length == r.points.size());
        for (Point p : expected) {
            assertTrue(r.points.contains(p));
        }
    }

    @Test(expected = RuntimeException.class)
    public void testRectangleScaleByMinusTwo() {
        Rectangle r = new Rectangle(new Point(50, 50), new Point(250, 250));
        r.scale(-2);
    }

    @Test
    public void testRectangleScaleByZero() {
        Rectangle r = new Rectangle(new Point(50, 50), new Point(150, 150));
        r.scale(0);
        Point[] expected = {new Point(100, 100), new Point(100, 100),
            new Point(100, 100), new Point(100, 100), new Point(100, 100)};
        assertTrue(expected.length == r.points.size());
        for (Point p : expected) {
            assertTrue(r.points.contains(p));
        }
    }

    @Test
    public void testRectangleScaleByOne() {
        Rectangle r = new Rectangle(new Point(50, 50), new Point(150, 150));
        r.scale(1);
        Point[] expected = {new Point(50, 50), new Point(150, 50),
            new Point(50, 150), new Point(150, 150), new Point(50, 50)};
        assertTrue(expected.length == r.points.size());
        for (Point p : expected) {
            assertTrue(r.points.contains(p));
        }
    }

    @Test
    public void testRectangleUniteWith() {
        Rectangle r2 = new Rectangle(new Point(200, 100), new Point(100, 200));
        Rectangle r3 = new Rectangle(new Point(50, 50), new Point(150, 150));
        Rectangle r4 = r3.uniteWith(r2);
        Point[] expected = {new Point(50, 50), new Point(200, 50),
            new Point(200, 200), new Point(50, 200), new Point(50, 50)};
        assertTrue(expected.length == r4.points.size());
        for (Point p : expected) {
            assertTrue(r4.points.contains(p));
        }
    }

    /* Circle */
    @Test
    public void testCircleConstructor() {
        Circle c = new Circle(new Point(100, 100));
        Point[] expected = {new Point(100, 0), new Point(100, 200),
            new Point(200, 100), new Point(0, 100)};
        for (Point p : expected) {
            assertTrue(c.points.contains(p));
        }
    }

    @Test
    public void testLineConstructor() {
        Line l = new Line(new Point(50, 50), new Point(150, 150));
        Point[] expected = {new Point(50, 50), new Point(150, 150)};
        for (Point p : expected) {
            assertTrue(l.points.contains(p));
        }
    }
}
