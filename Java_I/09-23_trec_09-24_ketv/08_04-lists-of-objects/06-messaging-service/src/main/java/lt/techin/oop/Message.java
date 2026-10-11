package lt.techin.oop;

public class Message {
 private final String sender,content;
 public Message(String sender,String content){this.sender=sender;this.content=content;}
 public String getSender(){return sender;} public String getContent(){return content;}
 @Override public String toString(){return sender+": "+content;}
 @Override public boolean equals(Object other){if(this==other)return true;if(!(other instanceof Message m))return false;return java.util.Objects.equals(sender,m.sender)&&java.util.Objects.equals(content,m.content);}
 @Override public int hashCode(){return java.util.Objects.hash(sender,content);}
}
