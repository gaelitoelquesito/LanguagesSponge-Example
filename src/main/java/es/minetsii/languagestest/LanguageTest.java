package es.minetsii.languagestest;


import es.minetsii.sponge.languages.events.LangsLoadEvent;
import es.minetsii.sponge.languages.exceptions.PluginNotValidException;
import es.minetsii.sponge.languages.utils.LanguageUtils;
import es.minetsii.sponge.languages.utils.SendManager;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

@Plugin (id = "languagestest", name = "Languages test", version = "1.0", description = "Languages API TEST - Multi-language servers!",
         dependencies = @Dependency (id = "languages"))
public class LanguageTest {


	@Listener
	public void onServerStart (GameStartedServerEvent event) {
		LanguageUtils.loadPlugin(this);
	}

	@Listener
	public void onLangsLoad (LangsLoadEvent event) {
		try {
			event.addPlugin(this);
		} catch (PluginNotValidException e) {
			e.printStackTrace();
		}
	}

	@Listener
	public void playerJoin (ClientConnectionEvent.Join event) {
		SendManager.sendMessage("join", event.getTargetEntity(), this, event.getTargetEntity().getName());
	}

}
