package UI;

import java.util.Objects;
import java.util.Scanner;

import static UI.UserInput.COMMANDS.*;

public class UserInput {

  private Scanner inputReader;

  public UserInput(Scanner scn) {
    inputReader = Objects.requireNonNull(scn);
  }

  public COMMANDS parse() {
    return HELP;
  }

  public enum COMMANDS {
    HELP, NEXT, MOVE, QUIT
  }
}
