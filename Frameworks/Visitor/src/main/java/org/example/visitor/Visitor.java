package org.example.visitor;

import org.example.shapes.Circle;
import org.example.shapes.CompoundShape;
import org.example.shapes.Dot;
import org.example.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
