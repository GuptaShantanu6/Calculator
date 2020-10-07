package com.example.calculator

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_calculator_input.view.*
import android.view.View


class CalculatorInputView(context: Context, attributeSet: AttributeSet?) : RelativeLayout(context,attributeSet){

    init{
        //inflating the layout
        LayoutInflater.from(context).inflate(R.layout.view_calculator_input,this,true)

        attributeSet?.run{
            val typedArray : TypedArray = context.obtainStyledAttributes(attributeSet,R.styleable.CalculatorInputView)

            val textResource : String? = typedArray.getString(R.styleable.CalculatorInputView_item_text)
            val iconResource : Int = typedArray.getResourceId(R.styleable.CalculatorInputView_item_icon,-1)

            when {
                iconResource!=-1 -> {
                    input_element_text.visibility = View.GONE
                    input_element_image.apply {
                        visibility = View.VISIBLE
                        setImageResource(iconResource)
                    }
                }

                !textResource.isNullOrEmpty() -> {
                    input_element_image.visibility = View.GONE
                    input_element_text.apply {
                        visibility = View.VISIBLE
                        text = textResource
                    }
                }

                else -> {
                    input_element_text.visibility = View.GONE
                    input_element_image.visibility = View.GONE
                }
            }

            typedArray.recycle()

        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        input_element_click.setOnClickListener(l)
    }
}