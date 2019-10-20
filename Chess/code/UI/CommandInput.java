package UI;

import static UI.CommandInput.COMMANDS.*;

public class CommandInput {

  private COMMANDS command;
  private String move;

  private CommandInput(COMMANDS command) {
    this(command, "");
  }

  private CommandInput(COMMANDS command, String move) {
    setCommand(command);
    setMove(move);
  }

  public COMMANDS getCommand() {
    return command;
  }

  public String getMove() {
    return move;
  }

  private void setCommand(COMMANDS userCommand) {
    command = userCommand;
  }

  private void setMove(String userMove) {
    move = userMove;
  }

  public static CommandInput parse(String in) {
    CommandInput command;

    switch(in.toLowerCase()) {
      case "help":
      case "h":
        command = new CommandInput(HELP);
        break;
      case "next":
      case "n":
        command = new CommandInput(NEXT);
        break;
      case "quit":
      case "q":
        command = new CommandInput(QUIT);
        break;
      default:
        command = new CommandInput(MOVE, in);
    }

    return command;
  }

  public enum COMMANDS {
    HELP, NEXT, MOVE, QUIT
  }
}
