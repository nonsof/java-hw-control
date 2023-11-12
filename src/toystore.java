class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys; // Список призовых игрушек, ожидающих выдачи.

    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.weight = newWeight;
                break;
            }
        }
    }

    public Toy drawToy() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        Random random = new Random();
        double randomValue = random.nextDouble() * totalWeight;

        double currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomValue <= currentWeight) {
                return toy;
            }
        }

        return null;
    }
}
    public void performDrawing() {
        // Реализуйте розыгрыш и добавление выигранных игрушек в список prizeToys.
    }

    public Toy getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.get(0);
            prizeToys.remove(0);
            // Сохраните призовую игрушку в текстовый файл и уменьшите количество игрушек.
            return prizeToy;
        }
        return null;
       }

public class ToyShop {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(new Toy(1, "Toy1", 10, 10.0));
        toyStore.addToy(new Toy(2, "Toy2", 5, 20.0));
        toyStore.addToy(new Toy(3, "Toy3", 20, 15.0));

        while (true) {
            System.out.println("1. Розыгрыш игрушки");
            System.out.println("2. Выйти");
            System.out.print("Выберите опцию: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Toy drawnToy = toyStore.drawToy();
                    if (drawnToy != null) {
                        System.out.println("Вы получили игрушку: " + drawnToy.getName());
                        drawnToy.getQuantity()--;
                        if (drawnToy.getQuantity() == 0) {
                            toyStore.getToys().remove(drawnToy);
                        }
                    } else {
                        System.out.println("Нет доступных игрушек для розыгрыша.");
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }
}
