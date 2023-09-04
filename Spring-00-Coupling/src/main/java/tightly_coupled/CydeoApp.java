package tightly_coupled;

import loosely_coupled.FullTimeMentor;
import loosely_coupled.PartTimeMentor;

public class CydeoApp {
    public static void main(String[] args) {

        FullTimeMentor fullTime = new FullTimeMentor();
        PartTimeMentor partTime = new PartTimeMentor();

        Mentor mentor = new Mentor(fullTime, partTime); // MI
        mentor.manageAccount();
    }
}
