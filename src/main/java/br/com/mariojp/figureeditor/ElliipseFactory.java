package br.com.mariojp.figureeditor;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ElliipseFactory implements ShapeFactory {
    @Override
    public Shape createShape(Point start, Point end) {
      return contrutorEllipse(start,end);
    }

    @Override
    public Shape previewShape(Point start, Point end) {
        return contrutorEllipse(start,end);
    }

    private Shape contrutorEllipse(Point start, Point end) {
        if (end == null) return new Ellipse2D.Double();
        if (start == null) {
            int size = 60;
            return new Ellipse2D.Double(end.x - size / 2, end.y - size / 2, size, size);
        }


        return new Ellipse2D.Double(
                Math.min(start.x, end.x),
                Math.min(start.y, end.y),
                Math.abs(start.x - end.x),
                Math.abs(start.y - end.y)
        );
    }

}
