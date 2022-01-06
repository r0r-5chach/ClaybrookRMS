package com.mawkish.claybrookrms.tools;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class ScreenHandler {
    private final HashMap<String,Pane> scenes = new HashMap<>();
    private final Scene currentScene;

    public ScreenHandler(Scene scene) {
        this.currentScene = scene;
    }

    public void addScreen(String name,Pane scene) {
        scenes.put(name, scene);
    }

    public void changeScreen(String name) {
        currentScene.setRoot(scenes.get(name));
    }
}
