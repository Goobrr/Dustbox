package dustbox.world.blocks;

import arc.*;
import arc.func.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.entities.Effect.*;
import rhino.*;

import static dustbox.DustboxVars.scripts;

// functionality from Testers by sk7725/
// ported to java & v7 by Goober.

public class EffectTester extends BaseTester{
    public EffectTester(String name){
        super(name);
    }

    public class EffectTesterBuild extends TesterBuild{
        public Effect effect;
        public Cons<EffectContainer> cons;

        public float lifetime = 60;

        public void updateCons(String text){
            Core.app.post(() -> {
                try{
                    // oh my fucking god
                    cons = (Cons<EffectContainer>) ((Wrapper) scripts.context.evaluateString(scripts.scope, getCode(text), this + "@" + x + "," + y, 0)).unwrap();
                }catch(Exception e){
                    error(e);
                    Log.info(e);
                }
            });
        }

        @Override
        public String getCode(String text){
            return "cons(e=>{try{" + text + "}catch(error){e.lifetime = 0; e.data.error(error.message);}})";
        }

        public void error(String s){
            message("[scarlet]Error:[] " + s);
        }

        @Override
        public void run(){
            if(changed || effect == null){
                updateCons(content);
                if(effect == null) effect = new Effect(60, e -> {});
                effect.renderer = cons;
            }

            effect.lifetime = lifetime;
            effect.at(x, y, 0, this);

            changed = false;
        }
    }
}
