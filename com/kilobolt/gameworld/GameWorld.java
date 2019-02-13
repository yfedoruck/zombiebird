package com.kilobolt.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.kilobolt.gameobjects.Bird;
import com.kilobolt.gameobjects.ScrollHandler;
import com.kilobolt.zbhelpers.AssetLoader;


public class GameWorld
{
    private Bird bird;
    private ScrollHandler scroller;
    private Rectangle ground;

    public GameWorld(int midPointY)
    {
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
    }

    public void update(float delta)
    {
        if(delta > .15f){
            delta = .15f;
        }
        bird.update(delta);
        scroller.update(delta);

        if(bird.isAlive() && scroller.collides(bird)){
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerate();
        }
    }

    public Bird getBird()
    {
        return bird;
    }

    public ScrollHandler getScroller(){
        return scroller;
    }
}
