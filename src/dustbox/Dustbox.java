package dustbox;

import arc.*;
import dustbox.ui.*;
import dustbox.world.blocks.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.type.*;
import mindustry.world.meta.*;

public class Dustbox extends Mod{

    public Dustbox(){
        Events.on(FileTreeInitEvent.class, e -> {
            DustboxStyles.init();
        });

        Events.on(ClientLoadEvent.class, e -> {
            DustboxVars.edit = new EditDialog();
            DustboxVars.scripts = Vars.mods.getScripts();
        });
    }

    @Override
    public void loadContent(){
        new BaseTester("js-tester"){{
            buildVisibility = BuildVisibility.sandboxOnly;
            requirements(Category.logic, ItemStack.with(Items.copper, 1));
            size = 1;
        }};

        new DrawTester("draw-tester"){{
            buildVisibility = BuildVisibility.sandboxOnly;
            requirements(Category.logic, ItemStack.with(Items.copper, 1));
            size = 1;
        }};

        new EffectTester("effect-tester"){{
            buildVisibility = BuildVisibility.sandboxOnly;
            requirements(Category.logic, ItemStack.with(Items.copper, 1));
            size = 1;
        }};
    }

}
