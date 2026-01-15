import java.util.ArrayList;
import java.util.List;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected List<Actor> listOfActors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = new ArrayList<>();
    }

    public void printDirectorInfo() {
        System.out.println("Режиссёр: " + director);
    }

    public void printActorsList() {
        System.out.println("Актёры в спектакле '" + title + "':");
        if (listOfActors.isEmpty()) {
            System.out.println("  (нет актёров)");
        } else {
            for (Actor actor : listOfActors) {
                System.out.println("  - " + actor);
            }
        }
    }

    public void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Предупреждение: актёр " + actor + " уже есть в спектакле!");
            return;
        }
        listOfActors.add(actor);
    }

    public void replaceActor(Actor newActor, String surnameToReplace) {
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor actor = listOfActors.get(i);
            if (actor.getSurname().equals(surnameToReplace)) {
                listOfActors.set(i, newActor);
                System.out.println("Актёр " + actor.getSurname() + " заменён на " + newActor.getSurname());
                return;
            }
        }
        System.out.println("Предупреждение: актёр с фамилией '" + surnameToReplace + "' не найден!");
    }

    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public Director getDirector() { return director; }
    public List<Actor> getListOfActors() { return listOfActors; }
}