package dustbox.world.blocks;

import arc.scene.ui.layout.*;
import mindustry.gen.*;

// functionality from Testers by sk7725/
// ported to java & v7 by Goober.

public class DrawTester extends BaseTester{
    public DrawTester(String name){
        super(name);
    }

    public class DrawTesterBuild extends TesterBuild{
        @Override
        public void update(){
            super.update();
            if(changed) updateCons(content);
        }

        @Override
        public void draw(){
            super.draw();
            try{
                if(cons != null){
                    cons.get(this);
                }
            }catch(Exception e){
                error(e);
            }
        }

        @Override
        public void error(Exception e){
            cons = null;
            super.error(e);
        }

        public void buildConfiguration(Table table){
            table.table(t -> {
                t.button(Icon.pencil, this::edit).size(50);
                t.button(Icon.cancel, () -> cons = null).size(50);
            }).grow();
        }
    }
}
