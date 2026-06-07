import javax.swing.*;
import java.awt.Color;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import org.fife.ui.rtextarea.CaretStyle;
import org.fife.ui.rtextarea.RTextArea;
import org.fife.ui.rtextarea.ConfigurableCaret;

import org.fife.ui.rtextarea.Gutter;
import java.awt.Font;
import java.io.File;

import java.awt.Insets;

import javax.swing.BorderFactory;


public class EditorTestV0 {
	public static void main (String[] args) throws Exception {
		RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
		textArea.setCodeFoldingEnabled(true);

		textArea.setBackground(new Color(0, 19, 33)); // main backgrounds color
		textArea.setForeground(new Color(230, 228, 228)); // main text
		textArea.setCaretColor(new Color(230, 228, 228)); // cursor color
		textArea.setSelectionColor(new Color(40, 90, 110)); // text
		textArea.setCurrentLineHighlightColor(new Color(7, 49, 64));

		RTextScrollPane scrollPane = new RTextScrollPane(textArea);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());

		//scrollPane.getVerticalScrollBar().setBackground(new Color(7, 49, 64));

		scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI()); // attempted fix for the scrollbar pt1

		textArea.setCaretStyle(RTextArea.INSERT_MODE, CaretStyle.BLOCK_STYLE);
		textArea.setCaretStyle(RTextArea.OVERWRITE_MODE, CaretStyle.UNDERLINE_STYLE);
		textArea.getCaret().setBlinkRate(0);

		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		Gutter gutter = scrollPane.getGutter();
		gutter.setBorderColor(new Color(7, 49, 64));
		//gutter.setLineNumberStartOffset(400);

		Font regularFont = Font.createFont(Font.TRUETYPE_FONT, new File("IBMPlexMono-Regular.ttf")).deriveFont(17f);
		Font boldFont = Font.createFont(Font.TRUETYPE_FONT, new File("IBMPlexMono-Regular.ttf")).deriveFont(17f);

		scrollPane.getViewport().setBackground(new Color(7, 49, 64));
		scrollPane.getGutter().setBackground(new Color(0, 39, 56)); // side idiot
		scrollPane.getViewport().setForeground(new Color(7, 49, 64));

		scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 13, 0, 0)); // hoh boy
		scrollPane.setBackground(new Color(0, 39, 56)); // phahaha.... I'm such a fraud :3

		textArea.setFont(regularFont);
		textArea.setMargin(new Insets(0, 5, 0, 0));
		gutter.setLineNumberFont(boldFont);

		JFrame frame = new JFrame ("Editor Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(scrollPane);
		frame.setSize(800,600);
		frame.setVisible(true);
	}
	private static class CustomScrollBarUI extends javax.swing.plaf.basic.BasicScrollBarUI {
		@Override
		protected void configureScrollBarColors() {
			this.trackColor = new Color (0, 19, 33);  // back
			this.thumbColor = new Color (0, 12, 20); //drag
		}
		@Override
		protected javax.swing.JButton createDecreaseButton(int orientation) {
			javax.swing.JButton b = new javax.swing.JButton();
			b.setPreferredSize(new java.awt.Dimension(0, 0));
			b.setVisible(false);
			return b;
		}
		@Override
		protected javax.swing.JButton createIncreaseButton(int orientation) {
			javax.swing.JButton b = new javax.swing.JButton();
			b.setPreferredSize(new java.awt.Dimension(0, 0));
			b.setVisible(false);
			return b;
		}
	}	
}
