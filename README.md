# 🎲 Snake and Ladder Game

---

## 📌 Overview

This is a graphical Snake and Ladder game built using Java and Swing. The game allows a single player to roll a dice, move across the board, and interact with snakes and ladders. The objective is to reach position 100 to win the game.

---

## 🚀 Features

- 🎨 **Graphical Board**: The game features a visually appealing board.
- 🎲 **Dice Rolling**: A randomized dice roll using Java's `Random` class.
- 🏃 **Player Movement**: Moves the player based on dice values and applies snake and ladder rules.
- 🐍 **Snakes and Ladders Mechanics**: Automatically adjusts the player's position when landing on a snake or ladder.
- 🔄 **Game Reset Option**: Allows restarting the game at any time.
- 🏆 **Win Condition**: Displays a message when the player reaches position 100.

---

## 🛠️ Technologies Used

- **Java (Swing & AWT)**: Used for UI development.
- **JPanel, JButton, JLabel**: GUI components for board display, controls, and labels.
- **Random**: To generate dice rolls.
- **ImageIcon & Graphics**: For board and dice image rendering.

---

## 📜 How to Run

1. Ensure you have Java installed on your system.
2. Download and place required images (`board.jpg`, `dice1.jpg`, `dice2.jpg`, ..., `dice6.jpg`) in the appropriate resources folder.
3. Compile and run the program using the following command:
   ```sh
   javac SnakeLadderGame.java
   java SnakeLadderGame
   ```

---

## 🎯 Game Rules

- The player starts at position 1.
- Rolling the dice moves the player forward.
- Landing on a ladder moves the player up.
- Landing on a snake moves the player down.
- The first player to reach position 100 wins.
- If a player rolls a number that exceeds 100, the move is not allowed.

---

## 📷 Screenshots

(Add screenshots here once available.)

---

## 🔮 Future Improvements

- Multiplayer support.
- Improved UI with animations.
- Sound effects for dice rolling and movement.

---

## 👨‍💻 Author

Developed by [Rounak Jaiswal](https://github.com/rounakjaiswal).

---

## 🤝 Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

---

🎉 **Enjoy playing the Snake and Ladder game!**
