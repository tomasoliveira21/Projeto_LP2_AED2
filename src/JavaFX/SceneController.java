package JavaFX;

import Graph.Aresta_Projeto;
import Graph.Grafo_Projeto;
import edu.ufp.inf.lp2.geocaching.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static edu.ufp.inf.lp2.geocaching.UserAdmin.*;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Grafo_Projeto gG;
    public Group graphGroup;
    public TextField graphNvisitas;

    public ArrayList<UserBasic> users;
    public ArrayList<Cache> cache;

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

                if(cacheST.get(findIndexCacheName(grafoTS,i)).type.equals(CacheType.Basic))c.setFill(Color.BLUEVIOLET);
                else{
                    c.setFill(Color.LIGHTGOLDENRODYELLOW);
                }


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
            UserAdmin.SubGraphZona("norte",false);
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                if(cacheST.get(findIndexCacheName(subGrafo,i)).type.equals(CacheType.Basic))c.setFill(Color.BLUEVIOLET);
                else{
                    c.setFill(Color.LIGHTGOLDENRODYELLOW);
                }


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
            UserAdmin.SubGraphZona("centro",false);
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                if(cacheST.get(findIndexCacheName(subGrafo,i)).type.equals(CacheType.Basic))c.setFill(Color.BLUEVIOLET);
                else{
                    c.setFill(Color.LIGHTGOLDENRODYELLOW);
                }


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
            UserAdmin.SubGraphZona("sul",false);
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                if(cacheST.get(findIndexCacheName(subGrafo,i)).type.equals(CacheType.Basic))c.setFill(Color.BLUEVIOLET);
                else{
                    c.setFill(Color.LIGHTGOLDENRODYELLOW);
                }


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

    public void GraphDifFacil(ActionEvent actionEvent){
        try{

            System.out.println("A criar graph Dif Facil...\n");
            UserAdmin.SubGraphDificuldade(CacheDiff.Easy,false);
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                if(cacheST.get(findIndexCacheName(subGrafo,i)).type.equals(CacheType.Basic))c.setFill(Color.BLUEVIOLET);
                else{
                    c.setFill(Color.LIGHTGOLDENRODYELLOW);
                }


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

    public void GraphDifMedio(ActionEvent actionEvent){
        try{

            System.out.println("A criar graph Dif Medio...\n");
            UserAdmin.SubGraphDificuldade(CacheDiff.Medium,false);
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                if(cacheST.get(findIndexCacheName(subGrafo,i)).type.equals(CacheType.Basic))c.setFill(Color.BLUEVIOLET);
                else{
                    c.setFill(Color.LIGHTGOLDENRODYELLOW);
                }


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

    public void GraphDifDificil(ActionEvent actionEvent){
        try{

            System.out.println("A criar graph Dif Dificil...\n");
            UserAdmin.SubGraphDificuldade(CacheDiff.Hard,false);
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                if(cacheST.get(findIndexCacheName(subGrafo,i)).type.equals(CacheType.Basic))c.setFill(Color.BLUEVIOLET);
                else{
                    c.setFill(Color.LIGHTGOLDENRODYELLOW);
                }


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

    public void GraphDifNvisitasmaior(ActionEvent actionEvent){
        try{
            String aux = graphNvisitas.getText();
            if(aux == null){
                System.err.println("Erro na inserção.\n");
                return;
            }
            String []number = aux.split("-");
            if(number.length>1){
                System.err.println("Erro ao criar graph n visitas maior");
                return;
            }
            if(Integer.parseInt(number[0])<0){
                System.err.println("Erro , nao existe nr visitas engativos.\n");
                return;
            }
            System.out.println("A criar graph Nr visitas maior...\n");
            UserAdmin.SubGraphNrVisitasmaior(Integer.parseInt(number[0]),false);
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                if(cacheST.get(findIndexCacheName(subGrafo,i)).type.equals(CacheType.Basic))c.setFill(Color.BLUEVIOLET);
                else{
                    c.setFill(Color.LIGHTGOLDENRODYELLOW);
                }


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

    public void GraphDifNvisitasmenor(ActionEvent actionEvent){
        try{
            String aux = graphNvisitas.getText();
            if(aux == null){
                System.err.println("Erro na inserção.\n");
                return;
            }
            String []number = aux.split("-");
            if(number.length>1){
                System.err.println("Erro ao criar graph n visitas maior.\n");
                return;
            }
            if(Integer.parseInt(number[0])<0){
                System.err.println("Erro , nao existe nr visitas engativos.\n");
                return;
            }
            System.out.println("A criar graph Nr visitas menor...\n");
            UserAdmin.SubGraphNrVisitasmenor(Integer.parseInt(number[0]),false);
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);

                if(cacheST.get(findIndexCacheName(subGrafo,i)).type.equals(CacheType.Basic))c.setFill(Color.BLUEVIOLET);
                else{
                    c.setFill(Color.LIGHTGOLDENRODYELLOW);
                }


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

    public void GraphDifNvisitasmenormaior(ActionEvent actionEvent){
        try{
            String aux = graphNvisitas.getText();
            if(aux == null){
                System.err.println("Erro na inserção.\n");
                return;
            }
            String []number = aux.split("-");
            if(number.length>2){
                System.err.println("Erro ao criar graph n visitas maior.\n");
                return;
            }
            if(Integer.parseInt(number[0])<0 || Integer.parseInt(number[1])<0){
                System.err.println("Erro , nao existe nr visitas engativos.\n");
                return;
            }
            System.out.println("A criar graph Nr visitas menor...\n");
            UserAdmin.SubGraphNrVisitasMenorMaior(Integer.parseInt(number[0]),Integer.parseInt(number[1]),false);
            gG = subGrafo.graph;

            graphGroup.getChildren().clear();
            for (int i = 0; i < gG.V(); i++) {
                Circle c = new Circle(gG.positionsX[i], gG.positionsY[i], RADIO);


                if(cacheST.get(findIndexCacheName(subGrafo,i)).type.equals(CacheType.Basic))c.setFill(Color.BLUEVIOLET);
                else{
                    c.setFill(Color.LIGHTGOLDENRODYELLOW);
                }

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