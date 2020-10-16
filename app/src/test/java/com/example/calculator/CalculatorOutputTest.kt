package com.example.calculator

import com.example.calculator.calculator.CalculatorOutputInterfaceView
import com.example.calculator.calculator.CalculatorOutputPresenter
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito

class CalculatorOutputTest {
    private val mmPresenter = CalculatorOutputPresenter
    private val mmMockView = Mockito.mock(CalculatorOutputInterfaceView::class.java)

    @Test
    fun `1 plus 1 is 2`(){

        //Given that the view is attached
        mmPresenter.attach(mmMockView)

        //When a number is added
        mmPresenter.add("1+1")

        //Then the correct equation should be set
        then(mmMockView).should().setEquation("1+1")

        //Then the correct outcome should be set to
        then(mmMockView).should().setOutcome("2")

        //Clear Presenter
        mmPresenter.clear()

    }
}