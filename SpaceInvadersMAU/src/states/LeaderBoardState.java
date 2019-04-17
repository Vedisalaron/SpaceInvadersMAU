package states;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class LeaderBoardState extends GameState {

	private int currentChoiceOfTable = 0;
	private int currentChoiceInTable = 0;
	private String[][] testCases = { { "1th", "Tom", "1000000" }, { "2th", "Gustav", "900000" },
			{ "3rd", "Herman", "800000" }, { "1th", "Tom", "1000000" }, { "2th", "Gustav", "900000" },
			{ "3rd", "Herman", "800000" }, { "1th", "Tom", "1000000" }, { "2th", "Gustav", "900000" },
			{ "3rd", "Herman", "800000" }, { "1th", "Tom", "1000000" }, { "2th", "Gustav", "900000" },
			{ "3rd", "Herman", "800000" } ,{ "1th", "Tom", "1000000" }, { "2th", "Gustav", "900000" },
			{ "3rd", "Herman", "800000" }, { "1th", "Tom", "1000000" }, { "2th", "Gustav", "900000" },
			{ "3rd", "Herman", "800000" }, { "1th", "Tom", "1000000" }, { "2th", "Gustav", "900000" },
			{ "3rd", "Herman", "800000" }, { "1th", "Tom", "1000000" }, { "2th", "Gustav", "900000" },
			{ "3rd", "Herman", "800000" } };
	private String header = "HIGHSCORE TOP 100";
	private String[] subHeader = { "RANK", "NAME", "SCORE" };
	private String[] options = { "MAU", "WORLD WIDE" };
	private Font headerFont;

	public LeaderBoardState(GameStateManager gsm) {
		this.gsm = gsm;

		// Initializing variables.
		init();
	}

	@Override
	public void init() {
		try {
			headerFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/ARCADE_I.TTF")).deriveFont(40f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/ARCADE_I.TTF")));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	private void select() {
		if (currentChoiceOfTable == 0) {
			gsm.setState(GameStateManager.PLAYINGSTATE);
		}
		if (currentChoiceOfTable == 1) {
			// help
		}
		if (currentChoiceOfTable == 2) {
			System.exit(0);
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setFont(headerFont);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.GRAY.darker());
		g.setStroke(new BasicStroke(2));
		g.drawLine(10, 75, WIDTH - 10, 75);
		g.setStroke(new BasicStroke(1));

		g.setColor(Color.RED);
		g.drawString(header, 20, 50);
		g.setFont(font);

		g.setColor(Color.WHITE);

		for (int i = 0; i < options.length; i++) {
			if (i == currentChoiceOfTable) {
				g.setColor(Color.YELLOW);
			} else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 120 + i * 250, 115);
		}

		g.setColor(Color.WHITE);

		for (int i = 0; i < subHeader.length; i++) {
			g.drawString(subHeader[i], 40 + i * 240, 170);
		}

		g.setColor(Color.GRAY.darker());
		g.setStroke(new BasicStroke(2));
		g.drawLine(10, 130, WIDTH - 10, 130);
		g.setStroke(new BasicStroke(1));
		g.setColor(Color.WHITE);

		for (int i = 0; i < testCases.length; i++) {
			for (int j = 0; j < testCases[i].length; j++) {

				if (i == currentChoiceInTable) {
					g.setColor(Color.YELLOW);
				} else {
					g.setColor(Color.WHITE);
				}
				g.drawString(testCases[i][j], 40 + j * 240, 220 + i * 40);
			}
		}

//		
//		for (int i = 0; i < options.length; i++) {
//			if (i == currentChoice) {
//				g.setColor(Color.WHITE);
//			} else {
//				g.setColor(Color.GREEN);
//			}
//			textLength = (int) g.getFontMetrics().getStringBounds(options[i], g).getWidth();
//			g.drawString(options[i], (700 - textLength) / 2, (700 / 2) - 60 + 60 * i);
//		}

	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			select();
		}
		if (k == KeyEvent.VK_LEFT) {
			currentChoiceOfTable--;
			if (currentChoiceOfTable == -1) {
				currentChoiceOfTable = options.length - 1;
			}
		}
		if (k == KeyEvent.VK_RIGHT) {
			currentChoiceOfTable++;
			if (currentChoiceOfTable == options.length) {
				currentChoiceOfTable = 0;
			}
		}
		if (k == KeyEvent.VK_UP) {
			currentChoiceInTable--;
			if (currentChoiceInTable == -1) {
				currentChoiceInTable = 0;
			}
		}
		if (k == KeyEvent.VK_DOWN) {
			currentChoiceInTable++;
			if (currentChoiceInTable == testCases.length) {
				currentChoiceInTable = testCases.length-1;
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

}