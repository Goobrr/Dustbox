package dustbox.ui;

import arc.*;
import arc.scene.ui.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.ui.dialogs.*;
import dustbox.world.blocks.BaseTester.*;

public class EditDialog extends BaseDialog{
    public String content = "";
    public TextArea area;

    public TesterBuild build;

    public EditDialog(){
        super(Core.bundle.get("testers.edit"));

        area = cont.add(new TextArea(content.replace("/\r/g", "\n"))).size(1000, Core.graphics.getHeight() - 120).get();
        area.setStyle(DustboxStyles.codeField);

        area.setMaxLength(1000); // packet sizes go brrrrr

        buttons.button(Core.bundle.get("ok"), Icon.save, () -> {
            Log.info(area.getText());
            if(build != null) build.configure(area.getText());
            hide();
        });

        buttons.button(Core.bundle.get("cancel"), Icon.exit, this::hide);
    }

    public Dialog show(String content, TesterBuild build){
        this.content = content;
        this.build = build;

        area.setText(this.content);

        return show();
    };
}
