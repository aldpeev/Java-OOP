package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        supplements = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void setName(String name) {
        checkNullOrEmpty(name);
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void checkNullOrEmpty(String name) {
        if (name == null || name.trim().equals("")) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
    }

    @Override
    public int sumEnergy() {
        return players.stream().map(Player::getStrength).mapToInt(Integer::valueOf).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (players.size() >= capacity) {
            throw new IllegalStateException("Not enough capacity.");
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {

//        "{fieldName} ({fieldType}):
//        Player: {playerName1} {playerName2} {playerName3} (…) / Player: none
//        Supplement: {supplementsCount}
//        Energy: {sumEnergy}"

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());

        if (players.isEmpty()) {
            sb.append("Player: none");
        } else {
            sb.append(String.format("Player: %s", players.stream().map(Player::getName).collect(Collectors.joining(" "))));
        }

        sb.append(System.lineSeparator())
                .append(String.format("Supplement: %d", supplements.size()))
                .append(System.lineSeparator())
                .append(String.format("Energy: %d", supplements.stream().map(Supplement::getEnergy).mapToInt(Integer::valueOf).sum()))
                .append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public String getName() {
        return name;
    }
}


























