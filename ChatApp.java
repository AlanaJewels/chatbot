import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatApp {

    private static JFrame frame;
    private static JTextArea textArea;
    private static JTextField textField;
    private static JButton sendButton;

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure GUI components are created on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Display a welcome popup before starting the chat
                JOptionPane.showMessageDialog(null, "Welcome to ChatBot! Type your message below to start chatting.", "Welcome", JOptionPane.INFORMATION_MESSAGE);

                // Set up the GUI components
                frame = new JFrame("ChatBot");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setLayout(new BorderLayout());

                // Text area to display the chat
                textArea = new JTextArea();
                textArea.setEditable(false);  // Set text area as non-editable
                textArea.setFont(new Font("Arial", Font.PLAIN, 14));
                frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

                // Text field for the user to input messages
                textField = new JTextField();
                textField.setFont(new Font("Arial", Font.PLAIN, 14));
                textField.setPreferredSize(new Dimension(400, 40)); // Adjust size for text field
                frame.add(textField, BorderLayout.SOUTH);

                // Send button to trigger message sending
                sendButton = new JButton("Send");
                sendButton.setFont(new Font("Arial", Font.PLAIN, 14));
                frame.add(sendButton, BorderLayout.EAST);

                // Add action listeners for sending messages
                sendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sendMessage();
                    }
                });

                // Allow the user to hit Enter to send the message
                textField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sendMessage();
                    }
                });

                // Make the frame visible
                frame.setVisible(true);

                // Focus the text field to make sure the user can type
                textField.requestFocus();
            }
        });
    }

    // Send the message and display it in the text area
    private static void sendMessage() {
        String userInput = textField.getText();  // Get the user's input from the text field
        if (!userInput.isEmpty()) {
            textArea.append("You: " + userInput + "\n");

            // Generate chatbot's response
            String botResponse = generateResponse(userInput);
            textArea.append("ChatBot: " + botResponse + "\n");

            // Clear the text field for the next message
            textField.setText("");
            textArea.setCaretPosition(textArea.getDocument().getLength());  // Scroll to the bottom
        }
    }

    // Generate a response based on the user's input
    private static String generateResponse(String input) {
        input = input.toLowerCase();  // Convert input to lowercase to make matching easier

        // Respond based on various user inputs
        if (input.contains("hello")) {
            return "Hi there! How can I help you today?";
        } else if (input.contains("how are you")) {
            return "I'm just a bot, but I'm doing great! How about you?";
        } else if (input.contains("your name")) {
            return "I'm ChatBot. What's your name?";
        } else if (input.contains("bye")) {
            return "Goodbye! I hope to chat with you again soon!";
        } else if (input.contains("what is your purpose")) {
            return "My purpose is to assist and chat with you. Feel free to ask me anything!";
        } else if (input.contains("tell me a joke")) {
            return "Why don't skeletons fight each other? They don't have the guts!";
        } else if (input.contains("what time is it")) {
            return "I don't have a clock, but you can check the time on your device!";
        } else if (input.contains("weather")) {
            return "I don't know the weather, but you can check a weather app or website for that!";
        } else if (input.contains("thanks") || input.contains("thank you")) {
            return "You're welcome! I'm always here to help.";
        } else if (input.contains("what's your favorite color")) {
            return "I don't have preferences, but I think blue is a calming color!";
        } else if (input.contains("who created you")) {
            return "I was created by a developer who wanted to build an interactive chatbot.";
        } else if (input.contains("what can you do")) {
            return "I can chat with you, tell jokes, and answer a few questions. Try asking me something!";
        } else {
            return "That's interesting! Tell me more.";
        }
    }
}
