/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.im.spi.InputMethod;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import screenObjects.*;

/**
 *
 * @author JamesLaptop
 */
public class TitleScreen extends AbstractScreen{
    
    long timeAtScreen;
    private String[] options;
    private Color backroundColor;
    
    //constructors
    //------------------------------------------------------------------
    public TitleScreen(){
        super();
        
        //sets backround color
        backroundColor = Color.BLACK;
        
        //sets params for input handling
        setInputMethod("default");
                
        //sets options for the menu
        options = new String[5];
        options[0] = "Play Game";
        options[1] = "HighScores";
        options[2] = "Instructions";
        options[3] = "Options";
        options[4] = "Quit";
        
        //adds screen objects
        
        addToObjectsArray(new MenuSelectorIcon(300, getHeight() / 2, 10, 10, Color.WHITE, true, true));
        
    }
    
    //handles all game logic
    //------------------------------------------------------------------
    @Override
    public void runLogic() {
        timeAtScreen = System.nanoTime();
        
        //runs all logic for screen objects
        runScreenObjectLogic();
        
        //moves all screen objects
        moveScreenObjects();
        
    }

    //handles all screen specific drawing then parses through every AbstractScreenObject to draw them
    //------------------------------------------------------------------
    
    
    
    @Override
    public void drawGame(Graphics g) {
        setBackground(backroundColor);
        
        
        drawTitleScreenText(g);
        
        
        //draws all Screen Objects
        drawScreenObjects(g);
        
        masterDebug(g);
        
    }
    
    public void drawTitleScreenText(Graphics g){
        Font currentFont = g.getFont();
        Font normalFont = new Font(Font.MONOSPACED, Font.BOLD, 16);
        Font titleFont = new Font(Font.MONOSPACED, Font.BOLD, 32);
        
        g.setColor(Color.WHITE);
        
        drawCenteredString(g, "BRICK BREAKER", getWidth() / 2, 50, titleFont);
        
        for(int x = 0; x < options.length; x++){
            drawCenteredString(g, options[x], getWidth() / 2, getHeight() / 2 + x*20, normalFont);
        }
        
    }

    //user input handling
    //------------------------------------------------------------------
    
    //this method handles almost everything
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    
    
    @Override
    public void keyPressed(KeyEvent ke) {
        
        for(AbstractScreenObject ob : getObjectsArray()){
            ob.inputHandler(getInputMethod(), ke);
            System.out.println(ke.getKeyCode());
        }
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

    //Mouse Input methods
    //------------------------------------------------------------------
    
    
    @Override
    public void mouseMoved(MouseEvent me) {
        setMouseX(me.getX());
        setMouseY(me.getY());
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        setMouseX(me.getX());
        setMouseY(me.getY());
    }
}
