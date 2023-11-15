package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static football.common.ExceptionMessages.INVALID_FIELD_TYPE;

public class ControllerImpl implements Controller {
    private SupplementRepository supplement = new SupplementRepositoryImpl();
    private Collection<Field> fields = new ArrayList<>();

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;

        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }

        this.fields.add(field);

        return String.format("Successfully added %s.", fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement currentSupplement;

        if (type.equals("Powdered")){
            currentSupplement = new Powdered();
        } else if (type.equals("Liquid")){
            currentSupplement = new Liquid();
        } else {
            throw new IllegalArgumentException("Invalid supplement type.");
        }

        supplement.add(currentSupplement);

        return String.format("Successfully added %s.", type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement sp = supplement.findByType(supplementType);

        if (sp == null){
            throw new IllegalArgumentException(String.format("There isn't a Supplement of type %s.", supplementType));
        }

        Field field = findField(fieldName);

        field.addSupplement(sp);
        supplement.remove(sp);

        return String.format("Successfully added %s to %s.",supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;

        if (playerType.equals("Men")){
            player = new Men(playerName,nationality,strength);
        } else if (playerType.equals("Women")){
            player = new Women(playerName,nationality,strength);
        } else {
            throw new IllegalArgumentException("Invalid player type.");
        }

        Field field = findField(fieldName);
        field.addPlayer(player);

        String out;

        if (field.getClass().getSimpleName().equals("ArtificialTurf")){
            if (player.getClass().getSimpleName().equals("Men")){
                out = "The pavement of the terrain is not suitable.";
            } else {
                out = String.format("Successfully added %s to %s.", playerType, fieldName);
            }
        } else {
            if (player.getClass().getSimpleName().equals("Men")){
                out = String.format("Successfully added %s to %s.", playerType, fieldName);
            } else {
                out = "The pavement of the terrain is not suitable.";
            }
        }

        return out;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = findField(fieldName);

        field.drag();

        return String.format("Player drag: %d", field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field =findField(fieldName);

        return String.format("The strength of Field %s is %d.",fieldName, field.sumEnergy());
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Field field : fields) {
            sb.append(field.getInfo()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private Field findField(String fieldName) {
        Field field = null;

        for (Field f : fields) {
            if (f.getName().equals(fieldName)){
                field = f;
                break;
            }
        }
        return field;
    }
}
