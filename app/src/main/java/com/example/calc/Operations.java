package com.example.calc;

class Operations {
    private double number1;
    private double number2;
    private double result;
    private int set = 1;
    private int identify_operation;

    Operations() {
        number1 = 0;
        number2 = 0;
        result = 0;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
        set = 2;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setIdentify_operation(int identify_operation) {
        this.identify_operation = identify_operation;
    }

    public void result() {
        switch (identify_operation) {
            case 1:
                sum();
                identify_operation = 0;
                break;
            case 2:
                minus();
                identify_operation = 0;
                break;
            case 3:
                multiplication();
                identify_operation = 0;
                break;
            case 4:
                divide();
                identify_operation = 0;
                break;
        }
    }

    public void sum() {
        result = number1 + number2;
        number1 = result;
    }

    public void minus() {
        result = number1 - number2;
        number1 = result;
    }

    public void multiplication() {
        result = number1 * number2;
        number1 = result;
    }

    public void divide() {
        result = number1 / number2;
        number1 = result;
    }


}
