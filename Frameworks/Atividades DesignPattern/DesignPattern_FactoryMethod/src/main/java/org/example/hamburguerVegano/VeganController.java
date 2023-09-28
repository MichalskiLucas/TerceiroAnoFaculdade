package org.example.hamburguerVegano;

import org.example.hamburguerAngus.Controller;
import org.example.hamburguerAngus.ViewEngine;

public class VeganController extends Controller {
    @Override
    protected ViewEngine createViewEngine(){
        return new VeganViewEngine();
    }
}
