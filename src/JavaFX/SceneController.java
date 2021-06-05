package JavaFX;

import Graph.Aresta_Projeto;
import Graph.Grafo_Projeto;
import edu.ufp.inf.lp2.geocaching.UserAdmin;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static edu.ufp.inf.lp2.geocaching.UserAdmin.grafoTS;
import static edu.ufp.inf.lp2.geocaching.UserAdmin.subGrafo;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Grafo_Projeto gG;
    public Group graphGroup;

    private final int RADIO=20;



    public void switchToMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("JavaFX.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUser(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserAdmin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToGeoCaches(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GeoCaches.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMap(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Map.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void GraphGeral(ActionEvent actionEvent){
        try{

            System.out.println("A criar graph...\n");
            gG = grafoTS.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                c.setFill(Color.BLUEVIOLET);

                Text t = new Text(i + 1 + "");
                t.setFont(Font.font(40));
                StackPane stack = new StackPane();
                stack.setLayoutX(gG.positionsX[i] - RADIO);
                stack.setLayoutY(gG.positionsY[i]- RADIO);
                stack.getChildren().addAll(c, t);
                graphGroup.getChildren().add(stack);
            }
            for (int i = 0; i < gG.V(); i++) {
                if (gG.E() > 0) {
                    for (String key : grafoTS.st) {
                        int index = grafoTS.st.get(key);
                        if (index == i) {
                            for (Aresta_Projeto edg : gG.adj(index)) {
                                int v = edg.from();
                                int w = edg.to();
                                Arrow arrow = new Arrow(gG.positionsX[v], gG.positionsY[v], gG.positionsX[w], gG.positionsY[w], 15);

                                graphGroup.getChildren().add(arrow);
                            }

                        }
                    }

                }
            }
        }catch (Exception e){
            System.err.println("Erro ao criar grafo");
        }

    }


    public void GraphRegiaoNorte(ActionEvent actionEvent){
        try{

            System.out.println("A criar graph Norte...\n");
            UserAdmin.SubGraphZona("norte");
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                c.setFill(Color.BLUEVIOLET);

                Text t = new Text(i + 1 + "");
                t.setFont(Font.font(40));
                StackPane stack = new StackPane();
                stack.setLayoutX(gG.positionsX[i] - RADIO);
                stack.setLayoutY(gG.positionsY[i]- RADIO);
                stack.getChildren().addAll(c, t);
                graphGroup.getChildren().add(stack);
            }
            for (int i = 0; i < gG.V(); i++) {
                if (gG.E() > 0) {
                    for (String key : grafoTS.st) {
                        int index = grafoTS.st.get(key);
                        if (index == i) {
                            for (Aresta_Projeto edg : gG.adj(index)) {
                                int v = edg.from();
                                int w = edg.to();
                                Arrow arrow = new Arrow(gG.positionsX[v], gG.positionsY[v], gG.positionsX[w], gG.positionsY[w], 15);

                                graphGroup.getChildren().add(arrow);
                            }

                        }
                    }

                }
            }
        }catch (Exception e){
            System.err.println("Erro ao criar grafo");
        }

    }

    public void GraphRegiaoCentro(ActionEvent actionEvent){
        try{

            System.out.println("A criar graph Centro...\n");
            UserAdmin.SubGraphZona("centro");
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                c.setFill(Color.BLUEVIOLET);

                Text t = new Text(i + 1 + "");
                t.setFont(Font.font(40));
                StackPane stack = new StackPane();
                stack.setLayoutX(gG.positionsX[i] - RADIO);
                stack.setLayoutY(gG.positionsY[i]- RADIO);
                stack.getChildren().addAll(c, t);
                graphGroup.getChildren().add(stack);
            }
            for (int i = 0; i < gG.V(); i++) {
                if (gG.E() > 0) {
                    for (String key : grafoTS.st) {
                        int index = grafoTS.st.get(key);
                        if (index == i) {
                            for (Aresta_Projeto edg : gG.adj(index)) {
                                int v = edg.from();
                                int w = edg.to();
                                Arrow arrow = new Arrow(gG.positionsX[v], gG.positionsY[v], gG.positionsX[w], gG.positionsY[w], 15);

                                graphGroup.getChildren().add(arrow);
                            }

                        }
                    }

                }
            }
        }catch (Exception e){
            System.err.println("Erro ao criar grafo");
        }

    }

    public void GraphRegiaoSul(ActionEvent actionEvent){
        try{

            System.out.println("A criar graph Sul...\n");
            UserAdmin.SubGraphZona("sul");
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                c.setFill(Color.BLUEVIOLET);

                Text t = new Text(i + 1 + "");
                t.setFont(Font.font(40));
                StackPane stack = new StackPane();
                stack.setLayoutX(gG.positionsX[i] - RADIO);
                stack.setLayoutY(gG.positionsY[i]- RADIO);
                stack.getChildren().addAll(c, t);
                graphGroup.getChildren().add(stack);
            }
            for (int i = 0; i < gG.V(); i++) {
                if (gG.E() > 0) {
                    for (String key : grafoTS.st) {
                        int index = grafoTS.st.get(key);
                        if (index == i) {
                            for (Aresta_Projeto edg : gG.adj(index)) {
                                int v = edg.from();
                                int w = edg.to();
                                Arrow arrow = new Arrow(gG.positionsX[v], gG.positionsY[v], gG.positionsX[w], gG.positionsY[w], 15);

                                graphGroup.getChildren().add(arrow);
                            }

                        }
                    }

                }
            }
        }catch (Exception e){
            System.err.println("Erro ao criar grafo");
        }

    }



}