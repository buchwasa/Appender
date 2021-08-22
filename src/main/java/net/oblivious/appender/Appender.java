package net.oblivious.appender;

import com.google.gson.JsonObject;
import dev.waterdog.waterdogpe.event.defaults.PlayerPreLoginEvent;
import dev.waterdog.waterdogpe.plugin.Plugin;

public class Appender extends Plugin {

    public void onEnable() {
        this.getProxy().getEventManager().subscribe(PlayerPreLoginEvent.class, this::onPreLogin);
    }

    public void onPreLogin(PlayerPreLoginEvent event){
        JsonObject clientData = event.getLoginData().getClientData();
        clientData.remove("PlatformOnlineId");
        clientData.addProperty("PlatformOnlineId", event.getLoginData().getXuid());
        clientData.remove("PlatformOfflineId");
        clientData.addProperty("PlatformOfflineId", event.getAddress().getAddress().getHostAddress());
    }
}
