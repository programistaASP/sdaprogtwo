package pl.sdacademy.prog.Slack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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
}
