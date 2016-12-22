package blatt9;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Rocke
 */
public class Rectangle extends Figure{
    public Rectangle (Point p1, Point p2){
        points.add(p1);
        Point temp = new Point();
        temp.setLocation(p1.getX(), p2.getY());
        points.add(temp);
        points.add(p2);
        temp = new Point();
        temp.setLocation(p2.getX(), p1.getY());
        points.add(temp);
        points.add(p1);
    }
    
    public Rectangle (Rectangle o){
        for(Point point : o.points){
            this.points.add(point);
        }
    }
    
    public void scale(double d){
        if(d <= 0){throw new RuntimeException("The scaling must be positiv!");}
        
        
        Point middle = getMiddle();
        points.stream().forEach((point) -> {
            point.setLocation(
                    middle.getX() + ((point.getX() - middle.getX()) * d),
                    middle.getY() + ((point.getY() - middle.getY()) * d)
            );
        });
    }
    
    public Rectangle uniteWith(Rectangle r){
        Point thistl = tl(this);
        Point othertl = tl(r);
        Point thisbr = br(this);
        Point otherbr =br(r);
        
        Point newtl = new Point();
        newtl.setLocation(
                                Math.min(thistl.getX(), othertl.getY()),
                                Math.min(thistl.getY(), othertl.getY())
        );
       Point newbr = new Point();
       newbr.setLocation(
                                Math.max(thisbr.getX(), otherbr.getX()),
                                Math.max(thisbr.getY(), otherbr.getY())
        );
        
        return new Rectangle(newtl, newbr);
    }
    
    //Gets the TopLeft Point of the Rectancle
    private Point tl(Rectangle p){         
        Point max = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(Point point: p.points){
            if(point.x <= max.x && point.y <= max.y){
                max = point;
            }
        }
        return max;
    }
    
    //Gets the BottomRight Point of the Rectancle
    private Point br(Rectangle p){         
        Point min = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(Point point: p.points){
            if(point.x >= min.x && point.y >= min.y){
                min = point;
            }
        }
        return min;
    }
    
    private Point getMiddle(){
        Point temp = new Point();
        temp.setLocation( 
                        (tl(this).getX() + br(this).getX()) / 2,
                        (tl(this).getY() + br(this).getY()) / 2
                        );
        
        return temp;
    }
}
