import java.awt.*;
import java.net.URL;
import java.util.Random;
import javax.swing.*;

public class SnakeLadderGame extends JFrame {
    private JPanel boardPanel;
    private JButton rollButton, resetButton;
    private JLabel diceLabel, playerLabel, diceImageLabel;
    private int playerPosition = 1;
    private Random random;
    private Image boardImage;
    private ImageIcon[] diceImages;

    private static final int[] snakesAndLadders = new int[101];

    static {
        snakesAndLadders[5] = 58;
        snakesAndLadders[14] = 49;
        snakesAndLadders[42] = 60;
        snakesAndLadders[53] = 72;
        snakesAndLadders[64] = 83;
        snakesAndLadders[75] = 94;
        
        snakesAndLadders[97] = 61;
        snakesAndLadders[91] = 73;
        snakesAndLadders[76] = 54;
        snakesAndLadders[51] = 10;
        snakesAndLadders[38] = 20;
        snakesAndLadders[45] = 7;
    }

    public SnakeLadderGame() {
        setTitle("Snake and Ladder Game");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        loadResources();
        
        random = new Random();
        boardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBoard(g);
            }
        };
        boardPanel.setPreferredSize(new Dimension(600, 600));

        rollButton = new JButton("Roll Dice");
        resetButton = new JButton("Reset");
        diceLabel = new JLabel("Dice: 0");
        playerLabel = new JLabel("Player at: 1");
        diceImageLabel = new JLabel(diceImages[0]);

        rollButton.addActionListener(e -> rollDice());
        resetButton.addActionListener(e -> resetGame());

        JPanel controlPanel = new JPanel();
        controlPanel.add(rollButton);
        controlPanel.add(resetButton);
        controlPanel.add(diceImageLabel);
        controlPanel.add(playerLabel);

        add(boardPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void loadResources() {
        URL boardUrl = getClass().getClassLoader().getResource("board.jpg");
        if (boardUrl != null) {
            boardImage = new ImageIcon(boardUrl).getImage();
        } else {
            System.err.println("Board image not found!");
        }
    
        diceImages = new ImageIcon[6];
        for (int i = 0; i < 6; i++) {
            URL diceUrl = getClass().getClassLoader().getResource("dice" + (i + 1) + ".jpg");
            if (diceUrl != null) {
                Image originalImage = new ImageIcon(diceUrl).getImage();
                Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                diceImages[i] = new ImageIcon(resizedImage);
            } else {
                System.err.println("Dice image " + (i + 1) + " not found!");
            }
        }
    }
    

    private void drawBoard(Graphics g) {
        int panelWidth = boardPanel.getWidth();
        int panelHeight = boardPanel.getHeight();

        int imgWidth = boardImage.getWidth(null);
        int imgHeight = boardImage.getHeight(null);

        double scale = Math.min((double) panelWidth / imgWidth, (double) panelHeight / imgHeight);
        int newWidth = (int) (imgWidth * scale);
        int newHeight = (int) (imgHeight * scale);

        int x = (panelWidth - newWidth) / 2;
        int y = (panelHeight - newHeight) / 2;

        g.drawImage(boardImage, x, y, newWidth, newHeight, this);

        int tileSize = newWidth / 10;
        int row = 9 - (playerPosition - 1) / 10;
        int col = ((playerPosition - 1) % 10);
        if (row % 2 == 0) { 
            col = 9 - col; 
        }

        g.setColor(Color.BLUE);
        g.fillOval(x + col * tileSize + 5, y + row * tileSize + 5, tileSize - 10, tileSize - 10);
    }

    private void rollDice() {
        int diceValue = random.nextInt(6) + 1;
        diceLabel.setText("Dice: " + diceValue);
        diceImageLabel.setIcon(diceImages[diceValue - 1]);

        playerPosition += diceValue;
        if (playerPosition > 100) {
            playerPosition -= diceValue;
        }

        if (snakesAndLadders[playerPosition] != 0) {
            playerPosition = snakesAndLadders[playerPosition];
        }

        playerLabel.setText("Player at: " + playerPosition);
        boardPanel.repaint();

        if (playerPosition == 100) {
            JOptionPane.showMessageDialog(this, "Congratulations! You won!");
        }
    }

    private void resetGame() {
        playerPosition = 1;
        diceLabel.setText("Dice: 0");
        diceImageLabel.setIcon(diceImages[0]);
        playerLabel.setText("Player at: 1");
        boardPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeLadderGame().setVisible(true));
    }
}
