package edu.ufp.inf.lp2.geocaching;


import java.io.Serializable;

public class MessageLog implements Serializable {

 String mensagem;


 /**
  * Construtor do MessageLog
  * @param mensagem
  */

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