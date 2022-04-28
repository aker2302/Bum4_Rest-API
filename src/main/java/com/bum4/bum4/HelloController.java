package com.bum4.bum4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private TextField AreaCC;

    @FXML
    private Button NextBtn;

    @FXML
    private Button PreviousBtn;

    @FXML
    private TextField AreaId;

    @FXML
    private TextField AreaName;

    @FXML
    private TextField ComId;

    @FXML
    private TextField ComName;

    @FXML
    private WebView MyLogo;

    private WebEngine engine;

    private List<Competition> Comps = new ArrayList<>();
    int Index ;

    @FXML
    void initialize(){
        AreaCC.setDisable(true);
        AreaId.setDisable(true);
        AreaName.setDisable(true);
        ComId.setDisable(true);
        ComName.setDisable(true);

        Comps = Api.setCompetitions();
        Index = 0;

        engine = MyLogo.getEngine();
        if(Comps.get(Index).emblemUrl != null){
            System.out.println("************ Url available ***********");
            engine.load(Comps.get(Index).emblemUrl);
            MyLogo.setZoom(0.36);
        }else{
            System.out.println("============= No Url ============");
            engine.loadContent("");
            MyLogo.setZoom(0.36);
        }

        AreaId.setText(String.valueOf(Comps.get(Index).area.id));
        AreaCC.setText(String.valueOf(Comps.get(Index).area.countryCode));
        AreaName.setText(String.valueOf(Comps.get(Index).area.name));
        ComId.setText(String.valueOf(Comps.get(Index).id));
        ComName.setText(String.valueOf(Comps.get(Index).name));
    }

    @FXML
    void OnNext(ActionEvent event) {
        if(Index < Comps.size()-1){
            //engine.loadContent("");
            Index++;
            AreaId.setText(String.valueOf(Comps.get(Index).area.id));
            AreaCC.setText(String.valueOf(Comps.get(Index).area.countryCode));
            AreaName.setText(String.valueOf(Comps.get(Index).area.name));
            ComId.setText(String.valueOf(Comps.get(Index).id));
            ComName.setText(String.valueOf(Comps.get(Index).name));
            PreviousBtn.setDisable(false);
            if(Comps.get(Index).emblemUrl != null){
                System.out.println("************ Url available ***********");
                engine.load(Comps.get(Index).emblemUrl);
                MyLogo.setZoom(0.36);
            }else{
                System.out.println("============= No Url ============");
                engine.loadContent("");
                MyLogo.setZoom(0.36);
            }

        }else{
            NextBtn.setDisable(true);
        }
    }

    @FXML
    void OnPrevious(ActionEvent event) {
        if(Index > 0){
            //engine.loadContent("");
            Index--;
            AreaId.setText(String.valueOf(Comps.get(Index).area.id));
            AreaCC.setText(String.valueOf(Comps.get(Index).area.countryCode));
            AreaName.setText(String.valueOf(Comps.get(Index).area.name));
            ComId.setText(String.valueOf(Comps.get(Index).id));
            ComName.setText(String.valueOf(Comps.get(Index).name));
            NextBtn.setDisable(false);
            if(Comps.get(Index).emblemUrl != null){
                System.out.println("************ Url available ***********");
                engine.load(Comps.get(Index).emblemUrl);
                MyLogo.setZoom(0.36);
            }else{
                System.out.println("============= No Url ============");
                engine.loadContent("");
                MyLogo.setZoom(0.36);
            }

        }else{
            PreviousBtn.setDisable(true);
        }
    }


}