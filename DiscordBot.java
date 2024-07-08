

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class DiscordBot {

    public static void main(String[] args) throws Exception {
        JDABuilder.createDefault("YOUR_BOT_TOKEN")
            .setActivity(Activity.playing("LeetCode Challenges"))
            .addEventListeners(new BotListener())
            .build();
    

}

}
