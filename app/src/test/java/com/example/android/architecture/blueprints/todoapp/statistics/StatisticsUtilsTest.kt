package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

internal class StatisticsUtilsTest{

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZero(){

        //Creamos una tarea activa (false significa que no esta completa)
        val tasks = listOf<Task>(
            Task("titulo","descripcion", isCompleted = false)
        )
        //Llamamos a getActiveAndCompletedStats con la tarea antes creada
        val result = getActiveAndCompletedStats(tasks)
        //Comprobamos el resultado
        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is` (100f))
    }

    @Test
    fun getActiveAndCompletedStats_Completed_returnsHundred(){

        //Creamos una tarea activa (false significa que no esta completa)
        val tasks = listOf<Task>(
            Task("titulo","descripcion", isCompleted = true)
        )
        //Llamamos a getActiveAndCompletedStats con la tarea antes creada
        val result = getActiveAndCompletedStats(tasks)
        //Comprobamos el resultado
        assertThat(result.completedTasksPercent, `is` (100f))
        assertThat(result.activeTasksPercent, `is` (0f))
    }

    @Test
    fun getActiveAndCompletedStats_TwoCompletedThreActives_returnsFortySixty(){

        //Creamos una tarea activa (false significa que no esta completa)
        val tasks = listOf(
            Task("titulo","descripcion", isCompleted = true),
            Task("titulo", "descripcion", isCompleted = true),
            Task("titulo","descripcion", isCompleted = false),
            Task("titulo", "descripcion", isCompleted = false),
            Task("titulo", "descripcion", isCompleted = false)
        )
        //Llamamos a getActiveAndCompletedStats con la tarea antes creada
        val result = getActiveAndCompletedStats(tasks)
        //Comprobamos el resultado
        assertThat(result.completedTasksPercent, `is` (40f))
        assertThat(result.activeTasksPercent, `is` (60f))
    }

}