package com.Interfaces;

import com.Person;
import com.Things.Pillow;

public interface IPerson {
    void Sleep(Pillow a);
    void Speak(String topic);
    void Speak(Person a);
    boolean Think(String topic);
    void CalmDownSE(Person a);
    void CheckForTicket(Person a);
}
