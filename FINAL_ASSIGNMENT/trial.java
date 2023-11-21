import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class trial extends JFrame {

    private static final int BOARD_SIZE = 4;
    private int[][] board;
    private JLabel[][] tileLabels;
    private JLabel scoreLabel;
    private JLabel gameOverLabel;

    public trial() {
        initializeUI();
        initializeGame();
    }

    private void initializeUI() {
        setTitle("2048 Game");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.GRAY);

        JPanel boardPanel = createBoardPanel();
        add(boardPanel, BorderLayout.CENTER);

        createScorePanel();
        createGameOverLabel();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createBoardPanel() {
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        boardPanel.setBackground(Color.GRAY);
        add(boardPanel, BorderLayout.CENTER);

        tileLabels = new JLabel[BOARD_SIZE][BOARD_SIZE];
        initializeBoard(boardPanel);

        addKeyListener(new ArrowKeyListener());
        setFocusable(true);

        return boardPanel;
    }

    private void initializeGame() {
        spawnRandomTile();
        spawnRandomTile();
        updateUI();
    }

    private void initializeBoard(JPanel boardPanel) {
        board = new int[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = 0;
                tileLabels[i][j] = createTileLabel();
                boardPanel.add(tileLabels[i][j]);
            }
        }
    }

    private JLabel createTileLabel() {
        JLabel tileLabel = new JLabel("", SwingConstants.CENTER);
        tileLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        tileLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tileLabel.setPreferredSize(new Dimension(80, 80));
        tileLabel.setOpaque(true);
        return tileLabel;
    }

    private void createScorePanel() {
        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scorePanel.add(scoreLabel);
        scorePanel.setBackground(Color.GRAY);
        add(scorePanel, BorderLayout.NORTH);
    }

    private void createGameOverLabel() {
        gameOverLabel = new JLabel("", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(gameOverLabel, BorderLayout.SOUTH);
    }

    private void spawnRandomTile() {
        Random random = new Random();
        int value = random.nextInt(10) < 9 ? 2 : 4;
        int row, col;

        do {
            row = random.nextInt(BOARD_SIZE);
            col = random.nextInt(BOARD_SIZE);
        } while (board[row][col] != 0);

        board[row][col] = value;
    }

    private void updateUI() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                tileLabels[i][j].setText(board[i][j] == 0 ? "" : String.valueOf(board[i][j]));
                tileLabels[i][j].setBackground(getTileColor(board[i][j]));
            }
        }
    }

    private Color getTileColor(int value) {

        switch (value) {
            case 2:
                return new Color(255, 240, 245);
            case 4:
                return new Color(255, 228, 225);
            case 8:
                return new Color(255, 69, 0);
            case 16:
                return new Color(255, 165, 0);
            case 32:
                return new Color(255, 215, 0);
            case 64:
                return new Color(255, 255, 0);
            case 128:
            case 256:
            case 512:
                return new Color(152, 251, 152);
            case 1024:
            case 2048:
                return new Color(0, 128, 0);
            default:
                return Color.WHITE;
        }
    }

    private void showGameOver() {
        gameOverLabel.setText("Game Over! You can't make any more moves.");
    }

    private boolean moveUp() {
        boolean moved = false;
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 1; i < BOARD_SIZE; i++) {
                if (board[i][j] != 0) {
                    int k = i;
                    while (k > 0 && board[k - 1][j] == 0) {
                        board[k - 1][j] = board[k][j];
                        board[k][j] = 0;
                        k--;
                        moved = true;
                    }
                    if (k > 0 && board[k - 1][j] == board[k][j]) {
                        board[k - 1][j] *= 2;
                        board[k][j] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean moveDown() {
        boolean moved = false;
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = BOARD_SIZE - 2; i >= 0; i--) {
                if (board[i][j] != 0) {
                    int k = i;
                    while (k < BOARD_SIZE - 1 && board[k + 1][j] == 0) {
                        board[k + 1][j] = board[k][j];
                        board[k][j] = 0;
                        k++;
                        moved = true;
                    }
                    if (k < BOARD_SIZE - 1 && board[k + 1][j] == board[k][j]) {
                        board[k + 1][j] *= 2;
                        board[k][j] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean moveLeft() {
        boolean moved = false;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 1; j < BOARD_SIZE; j++) {
                if (board[i][j] != 0) {
                    int k = j;
                    while (k > 0 && board[i][k - 1] == 0) {
                        board[i][k - 1] = board[i][k];
                        board[i][k] = 0;
                        k--;
                        moved = true;
                    }
                    if (k > 0 && board[i][k - 1] == board[i][k]) {
                        board[i][k - 1] *= 2;
                        board[i][k] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean moveRight() {
        boolean moved = false;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = BOARD_SIZE - 2; j >= 0; j--) {
                if (board[i][j] != 0) {
                    int k = j;
                    while (k < BOARD_SIZE - 1 && board[i][k + 1] == 0) {
                        board[i][k + 1] = board[i][k];
                        board[i][k] = 0;
                        k++;
                        moved = true;
                    }
                    if (k < BOARD_SIZE - 1 && board[i][k + 1] == board[i][k]) {
                        board[i][k + 1] *= 2;
                        board[i][k] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private class ArrowKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN
                    || keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
                if (moveTiles(keyCode)) {
                    spawnRandomTile();
                    updateUI();
                }
                if (isGameOver()) {
                    showGameOver();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        private boolean moveTiles(int direction) {
            boolean moved = false;

            switch (direction) {
                case KeyEvent.VK_UP:
                    moved = moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    moved = moveDown();
                    break;
                case KeyEvent.VK_LEFT:
                    moved = moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    moved = moveRight();
                    break;
            }

            return moved;
        }

        private boolean isGameOver() {

            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] == 0) {
                        return false;
                    }
                }
            }

            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if ((j < BOARD_SIZE - 1 && board[i][j] == board[i][j + 1]) ||
                            (i < BOARD_SIZE - 1 && board[i][j] == board[i + 1][j])) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(trial::new);
    }
}
