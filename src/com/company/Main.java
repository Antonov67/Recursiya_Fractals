package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        double start, finish;
        start = System.currentTimeMillis();
        for (int i=0; i<=50;i++){
           // System.out.println("Фибоначчи(" + i + ")=" + nFib(i));
        }
        //рисуем фракталы
        new DrawFractals();

        finish = System.currentTimeMillis();
        System.out.println((finish - start)/1000);
    }
    //числа Фибоначчи
    public static long nFib (int n){
        if (n == 0 || n == 1)
            return 1;
        return nFib(n-1) + nFib(n - 2);
    }
}

class DrawFractals extends JFrame{
    Paint paint;
    int W = 600, H = 600;
    //рисование
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        int r = 150;
        drawCircles(g,W/2-r,H/2-r,2*r);
    }
    //рекурсия для рисования
    static void drawCircles(Graphics g, int x, int y, int r){
         g.drawOval(x, y, r, r);
         if (r>20){
             drawCircles(g,x-r/4,y+r/4,r/2);
             drawCircles(g,x+r/4,y-r/4,r/2);
             drawCircles(g,x+r/4*3 ,y+r/4,r/2);
             drawCircles(g,x+r/4,y+r/4*3,r/2);
         }
    }
    //конструктор
    public DrawFractals(){
        setBounds(200,200,W,H);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
