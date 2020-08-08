/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author cuongnm
 */
public class IntPhoneNumber extends PhoneNumber {

    String countryCode;

    public IntPhoneNumber() {
    }

    public IntPhoneNumber(String countryCode, int area, String number) {
        super(area, number);
        this.countryCode = countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    void display() {
        System.out.println(countryCode + " - " + area + " - " + number);
    }
}
