package pl.sdacademy.prog.Slack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String email;
    private String displayName;
    private List<Channel> subscribedChannels;
    private Communicator communicator;

    public void onMessageSend(final Message message) {

    }

    public Optional<Channel> subscribe(final String channelName) throws IOException {
        final Optional<Channel> optionalChannel = communicator.getPublicChannels().stream()
                .filter(channel -> channel.getName().equalsIgnoreCase(channelName))
                .findFirst();
        if (optionalChannel.isEmpty()) {
            return Optional.empty();
        }
        final Channel channel = optionalChannel.get();
        channel.addUser(this);

        Files.write(Paths.get(ApplicationConts.CHANNEL_OUTPUT_PATH + "/" + channelName
                + "_" + displayName + ".txt"), channel.getAllMessagesAsStrings(),
                StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);
        return optionalChannel;
    }
    public void sendMessage(final String messageContent, final String channelName) throws IOException {
        final Optional<Channel> optionalChannel = communicator.getPublicChannels().stream()
                .filter(channel -> channel.getName().equalsIgnoreCase(channelName))
                .findFirst();
        if (optionalChannel.isPresent()) {
            optionalChannel.get().sendMessage(this, messageContent);
        }
        subscribe(channelName).ifPresent(ch->ch.sendMessage(this, messageContent));

    }
}
