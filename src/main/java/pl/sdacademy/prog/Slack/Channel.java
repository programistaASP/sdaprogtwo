package pl.sdacademy.prog.Slack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
    private String name;
    private String topic;
    private List<User> users;
    private List<Message> messages;
    private boolean isPrivate;

    public void sendMessage(final User user, final String messageContent) {
        if(users.contains(user)) {
            final Message message = new Message(messageContent, LocalDateTime.now(), user.getDisplayName());
            messages.add(message);
            users.forEach(usr -> usr.onMessageSend(message));
        }
    }
    public void addUser(final User user) {
        final boolean userExists = users.stream()
                .anyMatch(usr ->usr.getDisplayName().equalsIgnoreCase(user.getDisplayName()));
        if (!userExists) {
            users.add(user);
        }
    }
}
