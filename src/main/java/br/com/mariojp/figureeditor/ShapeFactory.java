package br.com.mariojp.figureeditor;

import java.awt.*;

public interface ShapeFactory {

    Shape createShape(Point start, Point end);

    Shape previewShape(Point start, Point end);

}
