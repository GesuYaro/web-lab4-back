package shagiev.weblab4back.services;

import org.springframework.stereotype.Service;
import shagiev.weblab4back.beans.PointBean;

import java.util.Date;

@Service
public class AreaCheckService {

    public PointBean check(PointBean point) {
        long start = System.nanoTime();
        point.setTime(new Date());
        point.setResult(isHit(point));
        point.setExecution(String.valueOf(System.nanoTime() - start));
        return point;
    }

    private boolean isHit(PointBean point) {
        double x = point.getX();
        double y = point.getY();
        double r = point.getR();

        return isRectangle(x, y, r) || isTriangle(x, y, r) || isSector(x, y, r);
    }

    private boolean isTriangle(double x, double y, double r) {
        return (x <= 0 && y >= 0) && (y <= x + r);
    }

    private boolean isSector(double x, double y, double r) {
        return (x >= 0 && y >= 0) && (y * y + x * x <= r/2 * r/2);
    }

    private boolean isRectangle(double x, double y, double r) {
        return (x <= 0 && x >= -r/2) && (y <=0 && y > -r);
    }

}
