package edu.ufp.inf.lp2.geocaching;


public class MessageLog {

 String mensagem;


 public MessageLog(String mensagem) {
  this.mensagem = mensagem;
 }

 @Override
 public String toString() {
  return "MessageLog{" +
          "mensagem='" + mensagem + '\'' +
          '}';
 }
}