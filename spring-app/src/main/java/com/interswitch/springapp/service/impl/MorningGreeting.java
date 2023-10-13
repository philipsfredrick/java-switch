package com.interswitch.springapp.service.impl;

import com.interswitch.springapp.service.Greet;

public class MorningGreeting implements Greet {
    @Override
    public void greeting() {
        System.out.println("Good morning");
    }
}
