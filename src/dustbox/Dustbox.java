package dustbox;

import arc.*;
import arc.util.*;
import dustbox.ui.*;
import dustbox.world.blocks.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.type.*;

public class Dustbox extends Mod{

    public Dustbox(){
        Events.on(FileTreeInitEvent.class, e -> {
            DustboxStyles.init();
        });

        Events.on(ClientLoadEvent.class, e -> {
            DustboxVars.edit = new EditDialog();
            DustboxVars.scripts = Vars.mods.getScripts();

            Log.info("Testers Vars Initialized");//test
        });
    }

    @Override
    public void loadContent(){
        new BaseTester("base-tester"){{
            requirements(Category.logic, ItemStack.with(Items.copper, 1));
            size = 1;
        }};

        new DrawTester("draw-tester"){{
            requirements(Category.logic, ItemStack.with(Items.copper, 1));
            size = 1;
        }};
    }

}
