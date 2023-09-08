package stereotype_annotations.Model;

import org.springframework.stereotype.Component;

@Component
public class DataStructure {
    public void getTotalHours() {
        System.out.println("Total hours: " + 40);
    }
}
