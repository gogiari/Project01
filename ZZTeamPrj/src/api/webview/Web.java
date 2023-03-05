package api.webview;
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

public class Web {

	public Web(String Adr) {
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
			JTextField addressBar = new JTextField("https://map.kakao.com/?map_type=TYPE_MAP&q=%EB%B6%80%EC%82%B0%EA%B7%B8%EB%A6%B0%EC%BB%B4%ED%93%A8%ED%84%B0+%EC%84%9C%EB%A9%B4&urlLevel=4&urlX=972427&urlY=466374");
			addressBar.addActionListener(e ->
			browser.navigation().loadUrl(addressBar.getText()));
			frame.add(addressBar, BorderLayout.NORTH);
			frame.add(view, BorderLayout.CENTER);
			frame.setSize(800, 500);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);

			browser.navigation().loadUrl(addressBar.getText());
		});	}

	public static void main(String[] args) {

    }
}