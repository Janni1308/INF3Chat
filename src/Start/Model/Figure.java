/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start.Model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author schel
 */
public class Figure implements Serializable
{
    private ArrayList<Point> points;

    public Figure()
    {
        points = new ArrayList();
    }
    public void addPoint(Point p )
    {
        points.add(p);
    }
    public List<Point> getPoints()
    {
        return Collections.unmodifiableList(points);
    }
     
}
