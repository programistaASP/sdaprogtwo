package pl.sdacademy.prog.Slack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String content;
    private LocalDateTime createdAt;
    private String author;

    public String getReadableMessage() {
        return createdAt.toString() + " " + author + "\n" + content;
    }
}
