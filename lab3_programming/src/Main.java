
import com.*;
import com.Exceptions.PriceExeption;
import com.Things.Cane;
import com.Things.Pillow;
import com.Things.Properties;
import com.Things.Ticket;
import com.Transport.Train;
import com.Transport.TrainModels;

public class Main {

    public static void main(String[] args)  {
        Train train = new Train("поезд", TrainModels.NOTCOOL);
        Ticket ticket = new Ticket("билет", train.getTrainModel().getI());
        Properties[] properties_array = { Properties.UNCOMFORTABLE, Properties.HARD };
        Pillow pillow = new Pillow("подушка", properties_array);
        Cane cane = new Cane("трость", 10);
        Person person = new Person("Скуперфильд", 1000);
        Person julio = new Person("Жулио");
        person.Kick(julio, cane);
        if (ticket.getPrice() < 0 || cane.getPrice() < 0){
            throw new PriceExeption("Цена указана неправильно");
        }
        if(!train.getEngine().getCondition()){
            System.out.println("*Объекту " + person.getName() + " придётся задержаться*");
            if (person.getCane() == null){
                if (person.Think("Не забыл ли я свою трость в том дупле?")){
                    person.Run();
                    if (person.TryToFind(cane)) {
                        person.PickUpCane(cane);
                    }
                }
            }
        }
        if (person.BuyTicket(ticket)){
            return;
        }
        person.GetOnTheTrain(train);
        Person employee = new Employee("проводник", ticket);
        employee.CheckForTicket(person);
        PersonProperties[] passengerProperties = {PersonProperties.RUDE, PersonProperties.TACITURN};
        Person passenger = new Person("Сосед", passengerProperties);
        if (person.TryToSpeak(passenger)){
            person.Speak(passenger);
        }
        if (person.getCane() != null) {
            person.Sleep(pillow);
        }
        else{
            if (person.Think("Не забыл ли я свою трость в том дупле?")) {
                person.GetNervous();
                employee.CalmDownSE(person);
                person.CalmDown();
                person.Sleep(pillow);
            }
            else{
                person.Sleep(pillow);
            }
        }
    }
}
