package edu.ufp.inf.lp2.geocaching;

public class UserLogs {

    Date data;
    String serialNumber;
    public String objetocolocado;
    public String objetoretirado;

    /**
     * Construtor UserLogs
     * @param data
     * @param serialNumber
     * @param objetocolocado
     * @param objetoretirado
     */

    public UserLogs(Date data, String serialNumber, String objetocolocado, String objetoretirado) {
        this.data = data;
        this.serialNumber = serialNumber;
        this.objetocolocado = objetocolocado;
        this.objetoretirado = objetoretirado;
    }

    @Override
    public String toString() {
        if(objetocolocado == null && objetoretirado== null){
            return "UserLogs{" +
                    "data=" + data.print() +
                    ", serialNumber='" + serialNumber + '\'' +
                    ", objetocolocado='" + "null" + '\'' +
                    ", objetoretirado='" + "null" + '\'' +
                    '}';
        }else if(objetocolocado != null && objetoretirado== null){
            return "UserLogs{" +
                    "data=" + data.print() +
                    ", serialNumber='" + serialNumber + '\'' +
                    ", objetocolocado='" + objetocolocado + '\'' +
                    ", objetoretirado='" + "null" + '\'' +
                    '}';
        }else  if (objetocolocado == null){
            return "UserLogs{" +
                    "data=" + data.print() +
                    ", serialNumber='" + serialNumber + '\'' +
                    ", objetocolocado='" + "null" + '\'' +
                    ", objetoretirado='" + objetoretirado + '\'' +
                    '}';
        }
        return "UserLogs{" +
                "data=" + data.print() +
                ", serialNumber='" + serialNumber + '\'' +
                ", objetocolocado='" + objetocolocado + '\'' +
                ", objetoretirado='" + objetoretirado + '\'' +
                '}';

    }
}
