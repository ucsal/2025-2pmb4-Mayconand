package br.com.mariojp.figureeditor;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleFactory implements ShapeFactory{
    @Override
    public Shape createShape(Point start, Point end) {
        return contrutorRectangle(start,end);
    }

    @Override
    public Shape previewShape(Point start, Point end) {
        return contrutorRectangle(start, end);
    }


    public Shape contrutorRectangle(Point start, Point end){
        if (end == null) return new Rectangle2D.Double(); // fallback
        if (start == null) {
            int size = 60;
            return new Rectangle2D.Double(end.x - size/2, end.y - size/2, size, size);
        }
        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int w = Math.max(Math.abs(start.x - end.x), 1);
        int h = Math.max(Math.abs(start.y - end.y), 1);
        return new Rectangle2D.Double(x, y, w, h);

    }
}


