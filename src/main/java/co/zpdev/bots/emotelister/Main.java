package co.zpdev.bots.emotelister;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.AnnotatedEventManager;
import net.dv8tion.jda.core.hooks.SubscribeEvent;

public class Main {

    public static void main(String[] args) throws Exception {
        new JDABuilder(AccountType.BOT).setToken(args[0])
                .setEventManager(new AnnotatedEventManager())
                .addEventListener(new Main()).buildAsync();
    }

    @SubscribeEvent
    public void onMessage(GuildMessageReceivedEvent event) {
        if (!event.getMessage().getContentRaw().equals("emotes")) return;

        System.out.println(event.getGuild().getName() + " emotes:");
        event.getGuild().getEmotes().forEach(emote -> System.out.println(emote.getName()));
    }

}
