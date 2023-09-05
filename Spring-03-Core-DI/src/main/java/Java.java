import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor // Spring will handle the Dependency Injection
public class Java {

    // Field Injection - not recommended
    //@Autowired

    OfficeHours officeHours;

    // Constructor Injection

//    @Autowired
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours() {
        System.out.println("Weekly teaching hours: " + (20 + officeHours.getHours()));
    }
}
