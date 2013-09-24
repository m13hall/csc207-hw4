package hallmira.util;

public class badEntry extends Exception
{
  public badEntry() {
    super();
  }

  public badEntry(String reason) {
    super(reason);
  }
} // class badEntry