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
        int count = 0;
        int firstIndex = -1;

        for (int i = 0; i < listOfActors.size(); i++) {
            Actor actor = listOfActors.get(i);
            if (actor.getSurname().equals(surnameToReplace)) {
                count++;
                if (firstIndex == -1) {
                    firstIndex = i;
                }
            }
        }

        if (count == 0) {
            System.out.println("Предупреждение: актёр с фамилией '" + surnameToReplace + "' не найден!");
        } else if (count == 1) {
            Actor oldActor = listOfActors.get(firstIndex);
            listOfActors.set(firstIndex, newActor);
            System.out.println("Актёр " + oldActor.getName() + " " + oldActor.getSurname() +
                    " заменён на " + newActor.getName() + " " + newActor.getSurname());
        } else {
            System.out.println("Ошибка: найдено " + count + " актёров с фамилией '" + surnameToReplace + "'!");
            System.out.println("Для замены необходимо указать полное имя актёра.");
            System.out.println();
            System.out.println("Найденные актёры:");
            for (Actor actor : listOfActors) {
                if (actor.getSurname().equals(surnameToReplace)) {
                    System.out.println("- " + actor.getName() + " " + actor.getSurname());
                }
            }
        }
    }

    public String getTitle() {
        return title;
    }
    public int getDuration() {
        return duration;
    }
    public Director getDirector() {
        return director;
    }
    public List<Actor> getListOfActors() {
        return listOfActors;
    }
}
