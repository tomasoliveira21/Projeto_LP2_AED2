package edu.ufp.inf.lp2.geocaching;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MessageLog {

 Date date;
 String mensagem;

 public MessageLog(String date, String mensagem) {
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  Date result;
  result=null;
  try {
   result = dateFormat.parse(date);
  } catch (ParseException e) {
   e.printStackTrace();
  }
  if (result!=null){
   this.date=result;
  }else {
   this.date= Calendar.getInstance().getTime();
  }
  this.mensagem = mensagem;
 }
}