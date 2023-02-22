package project.view;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class WebView {
	private static String mapSuch = "부산그린컴퓨터";

    public static void main(String[] args) {
        // Creating and running Chromium engine
        EngineOptions options =
                EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("1BNDHFSC1G5GGVIP9U882Y3C0VQ1FDNR0BAAU0R1J223BLVI42PK5X1APYGZF6A46E5Q5L")
                .build();
        Engine engine = Engine.newInstance(options);
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            // Creating Swing component for rendering web content
            // loaded in the given Browser instance.
            BrowserView view = BrowserView.newInstance(browser);

            // Creating and displaying Swing app frame.
            JFrame frame = new JFrame("Hello World");
            // Close Engine and onClose app window
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JTextField addressBar = new JTextField("https://map.kakao.com/?map_type=TYPE_MAP&q="
            + mapSuch + "&urlLevel=4&urlX=969222&urlY=466399");
            addressBar.addActionListener(e ->
                    browser.navigation().loadUrl(addressBar.getText()));
         //   frame.add(addressBar, BorderLayout.NORTH);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            browser.navigation().loadUrl(addressBar.getText());
        });
    }
}