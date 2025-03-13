package ClassPackage;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchWithPopup {
    private static final String API_KEY = "AIzaSyC71KHWhjLNacCj1odRg4sh9pD7IzyIaRA"; // Replace with your actual key

    private JPopupMenu popupMenu;
    private JList<String> suggestionList;
    private DefaultListModel<String> listModel;
    private JTextField targetField;

    public SearchWithPopup(JTextField textField) {
        this.targetField = textField;

        popupMenu = new JPopupMenu();
        listModel = new DefaultListModel<>();
        suggestionList = new JList<>(listModel);
        suggestionList.setPreferredSize(new java.awt.Dimension(250, 150)); // Adjust list size
        suggestionList.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14)); // Adjust font size
        popupMenu.add(new JScrollPane(suggestionList));

        // Set preferred size of the text field
        targetField.setPreferredSize(new java.awt.Dimension(200, 30)); // Adjust text field size
        targetField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14)); // Adjust font size

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                showSuggestions();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                showSuggestions();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                showSuggestions();
            }
        });

        suggestionList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Double-click to select
                    targetField.setText(suggestionList.getSelectedValue());
                    popupMenu.setVisible(false);
                }
            }
        });
    }

    public void showSuggestions() {
        String input = targetField.getText().trim();
        if (input.isEmpty()) {
            popupMenu.setVisible(false);
            return;
        }

        List<String> suggestions = getGooglePlaceSuggestions(input);

        if (suggestions.isEmpty()) {
            popupMenu.setVisible(false);
        } else {
            listModel.clear();
            for (String suggestion : suggestions) {
                listModel.addElement(suggestion);
            }

            popupMenu.show(targetField, 0, targetField.getHeight());
            targetField.requestFocus();
        }
    }

 private List<String> getGooglePlaceSuggestions(String input) {
    List<String> placeSuggestions = new ArrayList<>();
    try {
        String encodedInput = URLEncoder.encode(input, StandardCharsets.UTF_8);

        String apiUrl = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" 
                        + encodedInput + "&key=" + API_KEY;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.out.println("Error: HTTP response code " + response.statusCode());
            return placeSuggestions;
        }

        JSONObject jsonResponse = new JSONObject(response.body());
        JSONArray predictions = jsonResponse.getJSONArray("predictions");

        for (int i = 0; i < predictions.length(); i++) {
            String place = predictions.getJSONObject(i).getString("description");
            placeSuggestions.add(place);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return placeSuggestions;
}

    public static void main(String[] args) {
        // Set up your JFrame or JPanel layout to include both fields

        JFrame frame = new JFrame("Search With Popup Example");
        JPanel panel = new JPanel();

        JTextField targetField = new JTextField();
        JTextField dropField = new JTextField();

        // Create SearchWithPopup instances for both targetField and dropField
        SearchWithPopup targetSearch = new SearchWithPopup(targetField);
        SearchWithPopup dropSearch = new SearchWithPopup(dropField);

        panel.add(targetField);
        panel.add(dropField);

        frame.add(panel);
        frame.setSize(400, 200); // Adjust frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
