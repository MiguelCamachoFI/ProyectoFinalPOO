/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;
import java.util.List;

/**
 *
 * @author MarioTeran
 */
public class NumeroDeInscripcion {
    public int partition(List<GeneradorRegistros> arr, int low, int high){
        GeneradorRegistros pivot = arr.get(high);
        //System.out.println("Pivote: " + pivot);
        int i = (low-1);
        for (int j=low; j<high; j++){
            if (arr.get(j).getIndicadorEscolar() >= pivot.getIndicadorEscolar()) {
                i++;
                swap(arr, i,j);
            }
        }
        GeneradorRegistros temp = arr.get(i+1);
        arr.set(i+1, arr.get(high));
        arr.set(high, temp);
        return i+1;
    }

    public void QuickSort(List<GeneradorRegistros> arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            //Herramientas.printSubarray(arr, low, pi - 1);
            QuickSort(arr, low, pi-1);
            //Herramientas.printSubarray(arr, pi + 1, high);
            QuickSort(arr, pi+1, high);
        }
    }
    public void swap (List<GeneradorRegistros> arr, int i, int j){
        GeneradorRegistros temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

}
