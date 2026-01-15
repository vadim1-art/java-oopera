public class Theatre {
    public static void main(String[] args) {

        Actor actor1 = new Actor("Иван", "Петров", Person.Gender.MALE, 180);
        Actor actor2 = new Actor("Анна", "Сидорова", Person.Gender.FEMALE, 165);
        Actor actor3 = new Actor("Сергей", "Иванов", Person.Gender.MALE, 175);

        Director director1 = new Director("Олег", "Табаков", Person.Gender.MALE, 15);
        Director director2 = new Director("Мария", "Захарова", Person.Gender.FEMALE, 8);

        String musicAuthor = "Пётр Чайковский";
        String choreographer = "Мариус Петипа";

        Show regularShow = new Show("Вишнёвый сад", 120, director1);

        Opera opera = new Opera("Евгений Онегин", 180, director2,
                musicAuthor, "Опера по роману А.С. Пушкина...", 30);

        Ballet ballet = new Ballet("Щелкунчик", 150, director1,
                musicAuthor, "Волшебная сказка о девочке Маше...",
                choreographer);

        System.out.println("Созданы спектакли:");
        System.out.println("1. " + regularShow.getTitle());
        System.out.println("2. " + opera.getTitle());
        System.out.println("3. " + ballet.getTitle());
        System.out.println();

        System.out.println("Распределяем актёров по спектаклям:");

        regularShow.addActor(actor1);
        regularShow.addActor(actor2);

        opera.addActor(actor1);
        opera.addActor(actor3);

        ballet.addActor(actor2);
        ballet.addActor(actor3);

        System.out.println("\nПробуем добавить дубликата актёра:");
        ballet.addActor(actor3);

        System.out.println();

        System.out.println("Списки актёров по спектаклям:");
        regularShow.printActorsList();
        System.out.println();
        opera.printActorsList();
        System.out.println();
        ballet.printActorsList();
        System.out.println();

        System.out.println("Заменяем актёра в опере:");
        Actor newActor = new Actor("Александр", "Новый", Person.Gender.MALE, 182);
        opera.replaceActor(newActor, "Иванов");

        System.out.println("\nОбновлённый список актёров в опере:");
        opera.printActorsList();
        System.out.println();

        System.out.println("Пробуем заменить несуществующего актёра в балете:");
        ballet.replaceActor(newActor, "Несуществующий");
        System.out.println();

        System.out.println("Информация о режиссёрах:");
        regularShow.printDirectorInfo();
        opera.printDirectorInfo();
        System.out.println();

        System.out.println("Либретто музыкальных спектаклей:");
        System.out.println("------------------------");
        opera.printLibretto();
        System.out.println("\n------------------------");
        ballet.printLibretto();
        System.out.println("------------------------");
    }
}