package com.example.calc;

import android.os.Parcel;
import android.os.Parcelable;

class Operations implements Parcelable {
    static final Creator<Operations> CREATOR = new Creator<Operations>() {
        @Override
        public Operations createFromParcel(Parcel in) {
            return new Operations(in);
        }

        @Override
        public Operations[] newArray(int size) {
            return new Operations[size];
        }
    };
    private double number1;
    private double number2;
    private double result;
    private int set = 1;
    private int identify_operation;
    private int whichButton = 0;
    private String currentDigital;

    Operations() {
        number1 = 0;
        number2 = 0;
        result = 0;
    }

    protected Operations(Parcel in) {
        number1 = in.readDouble();
        number2 = in.readDouble();
        result = in.readDouble();
        set = in.readInt();
        identify_operation = in.readInt();
        whichButton = in.readInt();
        currentDigital = in.readString();
    }

    public String getCurrentDigital() {
        return currentDigital;
    }

    public void setCurrentDigital(String currentDigital) {
        this.currentDigital = currentDigital;
    }

    public int getWhichButton() {
        return whichButton;
    }

    public void setWhichButton(int whichButton) {
        this.whichButton = whichButton;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(number1);
        dest.writeDouble(number2);
        dest.writeDouble(result);
        dest.writeInt(set);
        dest.writeInt(identify_operation);
        dest.writeInt(whichButton);
        dest.writeString(currentDigital);
    }
}
